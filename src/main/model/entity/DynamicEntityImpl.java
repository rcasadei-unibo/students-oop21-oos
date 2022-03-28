package main.model.entity;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;

public class DynamicEntityImpl implements DynamicEntity {

    private static final  double INITIAL_SPEEDX = 2.5;
    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private double speedX;

    public DynamicEntityImpl(final Double coordinates, final Dimension2D dimensions) {
        this.coordinates = coordinates;
        this.dimensions = dimensions;
        this.speedX = INITIAL_SPEEDX;
    }

    @Override
    public void updatePosition() {
        this.coordinates.setLocation(coordinates.getX() - speedX, coordinates.getY());
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(coordinates.getX(), coordinates.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    @Override
    public void setSpeedX(final double speedX) {
        this.speedX = speedX;
    }

    @Override
    public boolean isOutofScreen() {
        return this.coordinates.getX() < -this.dimensions.getWidth(); 
    }

}
