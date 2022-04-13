package model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.entity.DynamicEntityFactory;
import model.entity.DynamicEntityFactoryImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public final class EntityGeneratorImpl implements EntityGenerator {

    private static final int MAX_CASE = 3;
    private static final int POWERUP_RARITY = 20;
    private static final double INITIAL_SPEEDX = 2.0;

    private final List<DynamicEntity> entityList;
    private final Random rand = new Random();
    private final DynamicEntityFactory factory;
    private final Counter entitiesCount;
    private double speedX;

    public EntityGeneratorImpl(final Dimension2D worldDimension) {
        this.entityList = new ArrayList<>();
        this.speedX = INITIAL_SPEEDX;
        this.factory = new DynamicEntityFactoryImpl(worldDimension);
        this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
        entitiesCount = new Counter();
        entitiesCount.increment(1);
    }

    @Override
    public List<DynamicEntity> getEntities() {
        return this.entityList;
    }

    @Override
    public void setSpeedX(final double speedX) {
        this.speedX = speedX;
    }

    @Override
    public void updateList() {
        this.removeEntity(e -> e.wasHit() && (e.getType() == EntityType.POWERUP || e.getType() == EntityType.COIN));

        if (this.entityList.isEmpty() || this.checkPosition()) {
                this.addEntity();
        }

        this.entityList.forEach(e -> e.updatePosition(speedX));
        this.removeEntity(e -> e.isOutofScreen());
    }

    private void addEntity() {
        final int random = rand.nextInt(MAX_CASE);
        if (entitiesCount.getCounter() < POWERUP_RARITY) {
            switch (this.entityList.get(entityList.size() - 1).getLevelType()) {
                case ZERO:
                    this.levelZeroConfig(random);
                    break;
                case ONE:
                    this.levelOneConfig(random);
                    break;
                case TWO:
                    this.levelTwoConfig(random);
                    break;
                default:
                    break;
            }
        } else {
            this.entityList.add(factory.createPowerup(EntityLevel.ONE));
            this.entitiesCount.reset();
        }
    }


    private void levelZeroConfig(final int random) {
        switch (Case.values()[random]) {
        case CASE_0:
            /*Obstacle ground level*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Platform level one with under an obstacle*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
            this.entityList.add(factory.createPlatform(EntityLevel.ONE));
            this.entitiesCount.increment(2);
            break;
        case CASE_2:
            /*Platform level one with under a coin*/
            this.entityList.add(factory.createCoin(EntityLevel.ZERO));
            this.entityList.add(factory.createPlatform(EntityLevel.ONE));
            this.entitiesCount.increment(2);
            break;

        default:
            break;
        }

    }

    private void levelOneConfig(final int random) {

        switch (Case.values()[random]) {
        case CASE_0:
            /*Platform level two*/
            this.entityList.add(factory.createPlatform(EntityLevel.TWO));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Platform level two, coin level one*/
            this.entityList.add(factory.createCoin(EntityLevel.ONE));
            this.entityList.add(factory.createPlatform(EntityLevel.TWO));
            this.entitiesCount.increment(1);
            break;
        case CASE_2:
            /*Ground obsatcle*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
            this.entitiesCount.increment(1);
            break;

        default:
            break;
        }
    }

    private void levelTwoConfig(final int random) {

        switch (Case.values()[random]) {
        case CASE_0:
            /*Platform level one*/
            this.entityList.add(factory.createPlatform(EntityLevel.ONE));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Platform level one, ground obstacle*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
            this.entityList.add(factory.createPlatform(EntityLevel.ONE));
            this.entitiesCount.increment(2);
            break;
        case CASE_2:
            /*Obstacle ground level, coin level one*/
            this.entityList.add(factory.createCoin(EntityLevel.ONE));
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO));
            this.entitiesCount.increment(2);
            break;

        default:
            break;
        }
    }

    private void removeEntity(final Predicate<DynamicEntity> filterCondition) {
        final List<DynamicEntity> removeList = entityList.stream()
                                                         .filter(filterCondition)
                                                         .collect(Collectors.toList());
        this.entityList.removeAll(removeList);
    }

    private boolean checkPosition() {
        return entityList.get(entityList.size() - 1).getBounds().getMinX() < entityList.get(entityList.size() - 1).getDistance();
    }

    private enum Case {
        CASE_0, CASE_1, CASE_2;
    }

    private class Counter {

        private int count;

        Counter() {
            this.count = 0;
        }

        public void increment(final int increment) {
            this.count += increment;
        }

        public void reset() {
            this.count = 0;
        }

        public int getCounter() {
            return this.count;
        }
    }
}
