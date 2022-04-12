package model.entity;

import java.awt.geom.Point2D;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import model.Model;

public abstract class DynamicEntityImpl implements DynamicEntity {

    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private double nextDistance;
    private final Image image;
    private final EntityLevel level;
    private final EntityType type;
    private boolean hit;


    public DynamicEntityImpl(final Point2D.Double coordinates, final Image image, final EntityLevel level, final EntityType type) {

        this.coordinates = coordinates;
        this.image = image;
        this.level = level;
        this.type = type;
        this.dimensions = new Dimension2D(image.getWidth(), image.getHeight());
        this.hit = false;

    }

    @Override
    public final void updatePosition(final double speedX) {
        this.coordinates.setLocation(coordinates.getX() - speedX, coordinates.getY());
    }

    @Override
    public final Rectangle2D getBounds() {
        return new Rectangle2D(coordinates.getX(), coordinates.getY(), dimensions.getWidth(), dimensions.getHeight());
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
    public final  EntityLevel getLevelType() {
        return this.level;
    }

    public final EntityType getType() {
        return this.type;
    }

    @Override
    public final double getDistance() {
       return this.nextDistance;
    }

    @Override
    public final void setDistance(final double distance) {
        this.nextDistance = distance;
    }

    @Override
    public final void hit(final boolean hit) {
        this.hit = hit;
    }

    @Override
    public final boolean wasHit() {
        return this.hit;
    }

    @Override
    public abstract void activateEffect(Model model);

}
