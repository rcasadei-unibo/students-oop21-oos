package model.entity;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import model.entity.powerup.ExtraLife;
import model.entity.powerup.Mushroom;
import model.entity.powerup.PowerUpType;
import model.entity.powerup.Shield;
import model.entity.powerup.Spraybomb;
import model.entity.powerup.Superjump;
import view.entity.EntityImages;
/**
 * 
 * Factory Method for {@link DynamicEntity}.
 *
 */
public final class EntityFactoryImpl implements EntityFactory {

    private static final double LAND_HEIGHT = 40;
    private final Dimension2D worldDimensions;
    private final Random rand = new Random(); 
    private static final int POWERUPS = 5; 

    /**
     * 
     * @param worldDimensions the world dimensions 
     */
    public EntityFactoryImpl(final Dimension2D worldDimensions) {

        this.worldDimensions = new Dimension2D(worldDimensions.getWidth(), worldDimensions.getHeight() - LAND_HEIGHT);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DynamicEntity createObstacle(final SpawnLevel level) {

        final Image image = Math.random() > 0.5 ? EntityImages.OBSTACLE_ONE.getImage() : EntityImages.OBSTACLE_TWO.getImage();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.OBSTACLE.getDistanceFactor());
        final DynamicEntity ob = new Obstacle(coordinates, image, level, EntityType.OBSTACLE);
        ob.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.OBSTACLE.getDistanceFactor());
        return ob;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DynamicEntity createPlatform(final SpawnLevel level) {

        final Image image = EntityImages.PLATFORM.getImage();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.PLATFORM.getDistanceFactor());
        final DynamicEntity pl = new Platform(coordinates, image, level, EntityType.PLATFORM);
        pl.setDistance(worldDimensions.getWidth() - image.getWidth());
        return pl;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DynamicEntity createCoin(final SpawnLevel level) {

        final Image image = EntityImages.COIN.getImage();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.COIN.getDistanceFactor());
        final DynamicEntity cn = new Coin(coordinates, image, level, EntityType.COIN);
        cn.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.COIN.getDistanceFactor());
        return cn;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> combinePlatformObstacle(final SpawnLevel platformLevel, final SpawnLevel obstacleLevel) {

        final Stream.Builder<DynamicEntity> builder = Stream.builder();
        return builder.add(this.createObstacle(obstacleLevel))
                     .add(this.createPlatform(platformLevel))
                     .build()
                     .collect(Collectors.toList());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> combinePlatformCoin(final SpawnLevel platformLevel, final SpawnLevel coinLevel) {

        final Stream.Builder<DynamicEntity> builder = Stream.builder();
        return builder.add(this.createCoin(coinLevel))
                     .add(this.createPlatform(platformLevel))
                     .build()
                     .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> combineObstacleCoin(final SpawnLevel obstacleLevel, final SpawnLevel coinLevel) {

        final Stream.Builder<DynamicEntity> builder = Stream.builder();
        return builder.add(this.createCoin(coinLevel))
                     .add(this.createObstacle(obstacleLevel))
                     .build()
                     .collect(Collectors.toList());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> combineAll(final SpawnLevel platformLevel, final SpawnLevel obstacleLevel, final SpawnLevel coinLevel) {

        final Stream.Builder<DynamicEntity> builder = Stream.builder();
        return builder.add(this.createCoin(coinLevel))
                      .add(this.createObstacle(obstacleLevel))
                      .add(this.createPlatform(platformLevel))
                      .build()
                      .collect(Collectors.toList());
    }



    @Override
    public DynamicEntity createPowerup(final SpawnLevel level) {

        final int random = rand.nextInt(POWERUPS); 
        final DynamicEntity powerup; 
        switch (PowerUpType.values()[random]) {
            case EXTRALIFE: 
                powerup = createExtralife(level); 
                break; 
            case MUSHROOM: 
                powerup = createMushroom(level); 
                break; 
            case SHIELD: 
                powerup = createShield(level); 
                break; 
            case SPRAYBOMB: 
                powerup = createSpraybomb(level); 
                break; 
            case SUPERJUMP: 
                powerup = createSuperjump(level); 
                break; 
            default: 
                powerup = null; 
                break; 
        }

        return powerup; 
    }

    private DynamicEntity createExtralife(final SpawnLevel level) {

        final Image image = EntityImages.EXTRALIFE.getImage(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity extralife = new ExtraLife(coordinates, image, level, EntityType.POWERUP);
        extralife.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return extralife; 
    }

    private DynamicEntity createMushroom(final SpawnLevel level) {

        final Image image = EntityImages.MUSHROOM.getImage(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity mushroom = new Mushroom(coordinates, image, level, EntityType.POWERUP);
        mushroom.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return mushroom; 
    }

    private DynamicEntity createShield(final SpawnLevel level) {

        final Image image = EntityImages.SHIELD.getImage(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity shield = new Shield(coordinates, image, level, EntityType.POWERUP);
        shield.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return shield; 
    }

    private DynamicEntity createSpraybomb(final SpawnLevel level) {

        final Image image = EntityImages.SPRAYBOMB.getImage(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity spraybomb = new Spraybomb(coordinates, image, level, EntityType.POWERUP);
        spraybomb.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return spraybomb; 
    }

    private DynamicEntity createSuperjump(final SpawnLevel level) {

        final Image image = EntityImages.SUPERJUMP.getImage(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity superjump = new Superjump(coordinates, image, level, EntityType.POWERUP);
        superjump.setDistance(worldDimensions.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return superjump; 
    }

    private Point2D.Double generatePoint(final SpawnLevel level, final Image image, final double distanceFactor) {
        final double x = worldDimensions.getWidth() * level.getSpawnX() + image.getWidth() * distanceFactor;
        final double y = worldDimensions.getHeight() * level.getSpawnY() - image.getHeight();
        return new Point2D.Double(x, y);
    }

}
