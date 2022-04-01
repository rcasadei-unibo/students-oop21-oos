package main.model.entity;

import java.awt.geom.Point2D;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public abstract class DynamicEntityImpl implements DynamicEntity {

    private static final  double INITIAL_SPEEDX = 2.5;
    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private double speedX;
    private double nextDistance; 
    private final double previousDistance;
    private final Image image;
    private final EntityLevelType level;


    public DynamicEntityImpl(final Dimension2D worldDimensions, final Image image, final EntityLevelType level, final double previousDistance) {
        this.level = level;
        this.image = image;
        this.coordinates = this.generatePoint(worldDimensions);
        this.dimensions = this.generateDimension();
        this.previousDistance = previousDistance;
        this.speedX = INITIAL_SPEEDX;
    }

    @Override
    public final void updatePosition() {
        this.coordinates.setLocation(coordinates.getX() - speedX, coordinates.getY());
    }

    @Override
    public final Rectangle2D getBounds() {
        return new Rectangle2D(coordinates.getX(), coordinates.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    @Override
    public final void setSpeedX(final double speedX) {
        this.speedX = speedX;
    }

    @Override
    public final boolean isOutofScreen() {
        return this.coordinates.getX() < -this.dimensions.getWidth(); 
    }

    @Override
    public final Image getImage() {
        return this.image;
    }

    @Override
    public final EntityLevelType getLevelType() {
        return this.level;
    }

    @Override
    public final double getDistance() {
       return this.nextDistance;
    }

    @Override
    public final void setDistance(final double distance) {
        this.nextDistance = distance;
    }

    private Point2D.Double generatePoint(final Dimension2D worldDimenion) {
        final double x = worldDimenion.getWidth() * level.getSpawnX() + previousDistance;
        final double y = worldDimenion.getHeight() * level.getSpawnY() - image.getHeight();
        return new Point2D.Double(x, y);
    }

    private Dimension2D generateDimension() {
        return new Dimension2D(image.getWidth(), image.getHeight());
    }
}
