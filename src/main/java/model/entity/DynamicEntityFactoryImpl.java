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

public final class DynamicEntityFactoryImpl implements DynamicEntityFactory {

    private static final int POWERUPS = 5; 
    private static final double LAND_HEIGHT = 20;
    private final Dimension2D worldDimension;
    private final Random rand = new Random(); 

    public DynamicEntityFactoryImpl(final Dimension2D worldDimension) {
        this.worldDimension = new Dimension2D(worldDimension.getWidth(), worldDimension.getHeight() - LAND_HEIGHT);
    }

    @Override
    public DynamicEntity createObsatcle(final EntityLevel level, final double speedX) {

        final Image image = Math.random() > 0.5 ? EntityImages.OBSTACLE_ONE.getImageFromPath() : EntityImages.OBSTACLE_TWO.getImageFromPath();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.OBSATCLE.getDistanceFactor());
        final DynamicEntity ob = new Obstacle(coordinates, image, level, EntityType.OBSATCLE, speedX);
        ob.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.OBSATCLE.getDistanceFactor());
        return ob;

    }

    @Override
    public DynamicEntity createPlatform(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.PLATFORM.getImageFromPath();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.PLATFORM.getDistanceFactor());
        final DynamicEntity pl = new Platform(coordinates, image, level, EntityType.PLATFORM, speedX);
        pl.setDistance(worldDimension.getWidth() - image.getWidth());
        return pl;

    }

    @Override
    public DynamicEntity createCoin(final EntityLevel level,  final double speedX) {

        final Image image = EntityImages.COIN.getImageFromPath();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.COIN.getDistanceFactor());
        final DynamicEntity cn = new Coin(coordinates, image, level, EntityType.COIN, speedX);
        cn.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.COIN.getDistanceFactor());
        return cn;

    }

    @Override
    public List<DynamicEntity> createCoinCollection(final EntityLevel level, final double speedX) {
        return Stream.generate(() -> createCoin(level, speedX))
                     .limit(3)
                     .collect(Collectors.toList());
    }

    @Override
    public DynamicEntity createPowerup(final EntityLevel level, final double speedX) {

        final int random = rand.nextInt(POWERUPS); 
        final DynamicEntity powerup; 
        switch (PowerUpType.values()[random]) {
            case EXTRALIFE: 
                powerup = createExtralife(level, speedX); 
                break; 
            case MUSHROOM: 
                powerup = createMushroom(level, speedX); 
                break; 
            case SHIELD: 
                powerup = createShield(level, speedX); 
                break; 
            case SPRAYBOMB: 
                powerup = createSpraybomb(level, speedX); 
                break; 
            case SUPERJUMP: 
                powerup = createSuperjump(level, speedX); 
                break; 
            default: 
                powerup = null; 
                break; 
        }

        return powerup; 
    }

    private DynamicEntity createExtralife(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.EXTRALIFE.getImageFromPath(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity extralife = new ExtraLife(coordinates, image, level, EntityType.POWERUP, speedX);
        extralife.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return extralife; 
    }

    private DynamicEntity createMushroom(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.MUSHROOM.getImageFromPath(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity mushroom = new Mushroom(coordinates, image, level, EntityType.POWERUP, speedX);
        mushroom.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return mushroom; 
    }

    private DynamicEntity createShield(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.SHIELD.getImageFromPath(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity shield = new Shield(coordinates, image, level, EntityType.POWERUP, speedX);
        shield.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return shield; 
    }

    private DynamicEntity createSpraybomb(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.SPRAYBOMB.getImageFromPath(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity spraybomb = new Spraybomb(coordinates, image, level, EntityType.POWERUP, speedX);
        spraybomb.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return spraybomb; 
    }

    private DynamicEntity createSuperjump(final EntityLevel level, final double speedX) {

        final Image image = EntityImages.SUPERJUMP.getImageFromPath(); 
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.POWERUP.getDistanceFactor());
        final DynamicEntity superjump = new Superjump(coordinates, image, level, EntityType.POWERUP, speedX);
        superjump.setDistance(worldDimension.getWidth() - image.getWidth() * EntityType.POWERUP.getDistanceFactor());
        return superjump; 
    }

    private Point2D.Double generatePoint(final EntityLevel level, final Image image, final double distanceFactor) {
        final double x = worldDimension.getWidth() * level.getSpawnX() + image.getWidth() * distanceFactor;
        final double y = worldDimension.getHeight() * level.getSpawnY() - image.getHeight();
        return new Point2D.Double(x, y);
    }

}
