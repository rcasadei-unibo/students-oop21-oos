package model.entity;

import java.awt.geom.Point2D;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import model.Model;

/**
 * 
 * Abstract class defining behaviors common to all entity. 
 *
 */
public abstract class AbstractDynamicEntity implements DynamicEntity {

    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private final SpawnLevel level;
    private final EntityType type;
    private double nextDistance;
    private final Image image;
    private boolean hit;

    /**
     * 
     * @param coordinates the coordinates of the entity on the screen.
     * @param image the image that identifies the entity.
     * @param level the level on which the entity spawn.
     * @param type the type that identifies the entity.
     */
    public AbstractDynamicEntity(final Point2D.Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {

        this.coordinates = coordinates;
        this.image = image;
        this.level = level;
        this.type = type;
        this.hit = false;
        this.dimensions = new Dimension2D(image.getWidth(), image.getHeight());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void updatePosition(final double speedX) {
        this.coordinates.setLocation(coordinates.getX() - speedX, coordinates.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Rectangle2D getBounds() {
        return new Rectangle2D(coordinates.getX(), coordinates.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isOutofScreen() {
        return this.coordinates.getX() < -this.dimensions.getWidth(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Image getImage() {
        return this.image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final  SpawnLevel getLevel() {
        return this.level;
    }

    /**
     * {@inheritDoc}
     */
    public final EntityType getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final double getDistance() {
       return this.nextDistance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setDistance(final double distance) {
        this.nextDistance = distance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void hit(final boolean hit) {
        this.hit = hit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean wasHit() {
        return this.hit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void activateEffect(Model model);

}
