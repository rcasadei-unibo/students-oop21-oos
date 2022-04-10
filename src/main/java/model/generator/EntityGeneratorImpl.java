package model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.entity.DynamicEntityFactory;
import model.entity.DynamicEntityFactoryImpl;
import model.entity.EntityLevel;

public final class EntityGeneratorImpl implements EntityGenerator {

    private static final int MAX_CASE = 3;
    private static final int POWERUP_RARITY = 15;
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
        this.entityList.add(factory.createObsatcle(EntityLevel.ZERO, speedX));
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
    public void removeEntity(final DynamicEntity entity) {
        this.entityList.remove(entity);
    }

    @Override
    public void clearEntity() {
        this.entityList.clear();
    }

    @Override
    public void updateList() {
        this.removeIfOut();

        if (this.entityList.isEmpty() || this.checkPosition()) {
            if (entitiesCount.getCounter() < POWERUP_RARITY) {
                this.addEntity();
            } else  {
                this.entityList.add(factory.createPowerup(EntityLevel.ZERO, speedX));
                this.entitiesCount.reset();
            }

        }
        this.entityList.forEach(e -> e.updatePosition());

    }

    private void addEntity() {
        final int random = rand.nextInt(MAX_CASE);
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
    }


    private void levelZeroConfig(final int random) {
        switch (Case.values()[random]) {
        case CASE_0:
            /*Obstacle ground level*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO, speedX));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Platform level one with under an obstacle*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO, speedX));
            this.entityList.add(factory.createPlatform(EntityLevel.ONE, speedX));
            this.entitiesCount.increment(2);
            break;
        case CASE_2:
            /*Platform level one with under a coin*/
            this.entityList.add(factory.createCoin(EntityLevel.ZERO, speedX));
            this.entityList.add(factory.createPlatform(EntityLevel.ONE, speedX));
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
            this.entityList.add(factory.createPlatform(EntityLevel.TWO, speedX));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Obstacle ground level*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO, speedX));
            this.entitiesCount.increment(1);
            break;
        case CASE_2:
            /*Collection of coin*/
            this.entityList.addAll(factory.createCoinCollection(EntityLevel.ONE, speedX));
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
            this.entityList.add(factory.createPlatform(EntityLevel.ONE, speedX));
            this.entitiesCount.increment(1);
            break;
        case CASE_1:
            /*Obstacle ground level*/
            this.entityList.add(factory.createObsatcle(EntityLevel.ZERO, speedX));
            this.entitiesCount.increment(1);
            break;
        case CASE_2:
            /*Collection of coin*/
            this.entityList.add(factory.createCoin(EntityLevel.ZERO, speedX));
            this.entitiesCount.increment(1);
            break;

        default:
            break;
        }
    }

    private void removeIfOut() {
        if (!this.entityList.isEmpty() && this.entityList.get(0).isOutofScreen()) {
            this.entityList.remove(0);
        }

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
