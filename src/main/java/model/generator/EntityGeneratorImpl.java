package model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.entity.EntityFactory;
import model.entity.EntityFactoryImpl;
import model.entity.SpawnLevel;
import model.entity.EntityType;

/**
 * 
 * Class used to generate a list of {@link DynamicEntity}.
 *
 */
public final class EntityGeneratorImpl implements EntityGenerator {

    private static final double INITIAL_SPEEDX = 2.0;
    private static final int POWERUP_RARITY = 25;
    private static final int MAX_CASE = 3;

    private final List<DynamicEntity> entities;
    private final EntityFactory factory;
    private final Counter counter;
    private final Random random; 
    private double speedX;

    /**
     * 
     * @param worldDimensions the game's world dimensions.
     */
    public EntityGeneratorImpl(final Dimension2D worldDimensions) {

        this.factory = new EntityFactoryImpl(worldDimensions);
        this.counter = new Counter();
        this.entities = new ArrayList<>();
        this.speedX = INITIAL_SPEEDX;
        this.random = new Random();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> getEntities() {
        return this.entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeedX(final double speedX) {
        this.speedX = speedX;
    }

    /**
     * {@inheritDoc}
     */
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
            switch (last.getLevel()) {
                case ZERO:
                    this.levelZeroConfig();
                    break;
                case ONE:
                    this.levelOneConfig();
                    break;
                case TWO:
                    this.levelTwoConfig();
                    break;
                default:
                    break;
            }
        } else {
            this.entities.add(factory.createPowerup(SpawnLevel.values()[rand]));
            this.counter.reset();
        }
    }


    private void levelZeroConfig() {

        final Stream.Builder<List<DynamicEntity>> builder = Stream.builder();
        final List<DynamicEntity> entity = builder.add(factory.combineObstacleCoin(SpawnLevel.ZERO, SpawnLevel.ONE))
                                                  .add(factory.combinePlatformObstacle(SpawnLevel.ONE, SpawnLevel.ZERO))
                                                  .add(List.of(factory.createPlatform(SpawnLevel.ONE)))
                                                  .build()
                                                  .skip(random.nextInt(MAX_CASE))
                                                  .findFirst()
                                                  .get();
        this.entities.addAll(entity);
        this.counter.increment(entity.size());

    }

    private void levelOneConfig() {

        final Stream.Builder<List<DynamicEntity>> builder = Stream.builder();
        final List<DynamicEntity> entity = builder.add(factory.combinePlatformObstacle(SpawnLevel.TWO, SpawnLevel.ZERO))
                                                  .add(factory.combinePlatformCoin(SpawnLevel.TWO, SpawnLevel.ONE))
                                                  .add(List.of(factory.createObstacle(SpawnLevel.ZERO)))
                                                  .build()
                                                  .skip(random.nextInt(MAX_CASE))
                                                  .findFirst()
                                                  .get();
        this.entities.addAll(entity);
        this.counter.increment(entity.size());

    }

    private void levelTwoConfig() {

        final Stream.Builder<List<DynamicEntity>> builder = Stream.builder();
        final List<DynamicEntity> entity = builder.add(factory.combinePlatformCoin(SpawnLevel.ONE, SpawnLevel.TWO))
                                                  .add(factory.combinePlatformObstacle(SpawnLevel.ONE, SpawnLevel.ZERO))
                                                  .add(List.of(factory.createCoin(SpawnLevel.ONE)))
                                                  .build()
                                                  .skip(random.nextInt(MAX_CASE))
                                                  .findFirst()
                                                  .get();
        this.entities.addAll(entity);
        this.counter.increment(entity.size());
    }

    private void removeEntity(final Predicate<DynamicEntity> filterCondition) {

        this.entities.removeAll(entities.stream()
                                        .filter(filterCondition)
                                        .collect(Collectors.toList()));

    }

    private boolean checkPosition() {
        final DynamicEntity last = entities.get(entities.size() - 1);
        return last.getBounds().getMinX() <= last.getDistance();
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
