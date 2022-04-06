package model.entity;

import java.awt.geom.Point2D;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import view.entity.EntityImages;

public final class DynamicEntityFactoryImpl implements DynamicEntityFactory {

    private final Dimension2D worldDimension;

    public DynamicEntityFactoryImpl(final Dimension2D worldDimension) {
        this.worldDimension = worldDimension;
    }

    @Override
    public DynamicEntity createObsatcle(final EntityLevel level, final double speedX) {

        final Image image = Math.random() > 0.5 ? EntityImages.OBSTACLE_ONE.getImageFromPath() : EntityImages.OBSTACLE_TWO.getImageFromPath();
        final Point2D.Double coordinates = this.generatePoint(level, image, EntityType.OBSATCLE.getDistanceFactor());
        final DynamicEntity ob = new Obstacle(coordinates, image, level, EntityType.OBSATCLE, speedX);
        ob.setDistance(worldDimension.getWidth() - image.getWidth());
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
        cn.setDistance(worldDimension.getWidth() - image.getWidth());
        return cn;

    }

    private Point2D.Double generatePoint(final EntityLevel level, final Image image, final double distanceFactor) {
        final double x = worldDimension.getWidth() * level.getSpawnX() + image.getWidth() * distanceFactor;
        final double y = worldDimension.getHeight() * level.getSpawnY() - image.getHeight();
        return new Point2D.Double(x, y);
    }

    /*
     * Aggiungere metodi che costruiscano collezioni con due Entità ? 
     * 
     * */
}
