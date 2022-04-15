package model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.entity.EntityFactory;
import model.entity.EntityFactoryImpl;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public final class EntityGeneratorImpl implements EntityGenerator {

    private static final double INITIAL_SPEEDX = 2.0;
    private static final int POWERUP_RARITY = 20;
    private static final int MAX_CASE = 3;

    private final List<DynamicEntity> entities;
    private final EntityFactory factory;
    private final Counter counter;
    private final Random random; 
    private double speedX;

    public EntityGeneratorImpl(final Dimension2D worldDimension) {

        this.factory = new EntityFactoryImpl(worldDimension);
        this.counter = new Counter();
        this.entities = new ArrayList<>();
        this.speedX = INITIAL_SPEEDX;
        this.random = new Random();

    }

    @Override
    public List<DynamicEntity> getEntities() {
        return this.entities;
    }

    @Override
    public void setSpeedX(final double speedX) {
        this.speedX = speedX;
    }

    @Override
    public void updateList() {
        this.removeEntity(e -> e.wasHit() && (e.getType() == EntityType.POWERUP || e.getType() == EntityType.COIN));

        if (this.entities.isEmpty()) {
            this.entities.addAll(factory.combineAll(SpawnLevel.ONE, SpawnLevel.ZERO, SpawnLevel.TWO));
            counter.increment(3);
        } else if (this.checkPosition()) {
            this.addEntity();
        }

        this.entities.forEach(e -> e.updatePosition(speedX));
        this.removeEntity(e -> e.isOutofScreen());
    }

    private void addEntity() {
        final int rand = random.nextInt(MAX_CASE);
        final DynamicEntity last = this.entities.get(entities.size() - 1);

        if (counter.get() < POWERUP_RARITY) {
            switch (last.getLevelType()) {
                case ZERO:
                    this.levelZeroConfig(rand);
                    break;
                case ONE:
                    this.levelOneConfig(rand);
                    break;
                case TWO:
                    this.levelTwoConfig(rand);
                    break;
                default:
                    break;
            }
        } else {
            this.entities.add(factory.createPowerup(SpawnLevel.values()[rand]));
            this.counter.reset();
        }
    }


    private void levelZeroConfig(final int rand) {
        switch (Case.values()[rand]) {
        case CASE_0:
            this.entities.addAll(factory.combineObstacleCoin(SpawnLevel.ZERO, SpawnLevel.ONE));
            this.counter.increment(2);
            break;
        case CASE_1:
            this.entities.addAll(factory.combinePlatformObstacle(SpawnLevel.ONE, SpawnLevel.ZERO));
            this.counter.increment(2);
            break;
        case CASE_2:
            this.entities.add(factory.createPlatform(SpawnLevel.ONE));
            this.counter.increment(1);
            break;
        default:
            break;
        }

    }

    private void levelOneConfig(final int rand) {
        switch (Case.values()[rand]) {
        case CASE_0:
            this.entities.addAll(factory.combinePlatformObstacle(SpawnLevel.TWO, SpawnLevel.ZERO));
            this.counter.increment(1);
            break;
        case CASE_1:
            this.entities.addAll(factory.combinePlatformCoin(SpawnLevel.TWO, SpawnLevel.ONE));
            this.counter.increment(2);
            break;
        case CASE_2:
            this.entities.add(factory.createObstacle(SpawnLevel.ZERO));
            this.counter.increment(1);
            break;
        default:
            break;
        }
    }

    private void levelTwoConfig(final int rand) {
        switch (Case.values()[rand]) {
        case CASE_0:
            this.entities.addAll(factory.combinePlatformCoin(SpawnLevel.ONE, SpawnLevel.TWO));
            this.counter.increment(2);
            break;
        case CASE_1:
            this.entities.addAll(factory.combinePlatformObstacle(SpawnLevel.ONE, SpawnLevel.ZERO));
            this.counter.increment(2);
            break;
        case CASE_2:
            this.entities.add(factory.createCoin(SpawnLevel.ONE));
            this.counter.increment(1);
            break;

        default:
            break;
        }
    }

    private void removeEntity(final Predicate<DynamicEntity> filterCondition) {

        this.entities.removeAll(entities.stream()
                                        .filter(filterCondition)
                                        .collect(Collectors.toList()));

    }

    private boolean checkPosition() {
        return entities.get(entities.size() - 1).getBounds().getMinX() < entities.get(entities.size() - 1).getDistance();
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

        public int get() {
            return this.count;
        }
    }
}
