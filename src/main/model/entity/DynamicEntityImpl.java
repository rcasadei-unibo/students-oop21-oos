package main.model.entity;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public abstract class DynamicEntityImpl implements DynamicEntity {

    private static final  double INITIAL_SPEEDX = 2.5;
    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private double speedX;
    private Image image;
    private final EntityLevelType levelType;

    public DynamicEntityImpl(final Double coordinates, final Dimension2D dimensions, final EntityLevelType levelType) {
        this.coordinates = coordinates;
        this.dimensions = dimensions;
        this.levelType = levelType;
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
    public final void setImage(final Image image) {
        this.image = image;
    }

    @Override
    public final Image getImage() {
        return this.image;
    }

    @Override
    public final EntityLevelType getLevelType() {
        return this.levelType;
    }
}
