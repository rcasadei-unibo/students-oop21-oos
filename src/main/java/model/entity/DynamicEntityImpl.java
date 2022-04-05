package model.entity;

import java.awt.geom.Point2D;

import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import model.Model;

public class DynamicEntityImpl implements DynamicEntity {

    private final Point2D.Double coordinates;
    private final Dimension2D dimensions;
    private final double speedX;
    private double nextDistance;
    private final Image image;
    private final EntityLevel level;
    private final EntityType type;


    private DynamicEntityImpl(final Point2D.Double coordinates, final Image image, final EntityLevel level, final EntityType type, final double speedX) {

        this.coordinates = coordinates;
        this.image = image;
        this.level = level;
        this.type = type;
        this.speedX = speedX;
        this.dimensions = new Dimension2D(image.getWidth(), image.getHeight());

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
    public void activateEffect(final Model model) {
        // TODO Auto-generated method stub
    }

    public static final class Builder {

        private final Dimension2D worldDimensions;
        private final double speedX;
        private double distanceFactor;
        private Image image;
        private EntityLevel level;
        private EntityType type;

        public Builder(final Dimension2D worldDimensions, final double speedX) {
            this.worldDimensions = worldDimensions;
            this.speedX = speedX;
        }

        public Builder image(final Image i) {
            this.image = i;
            return this;
        }

        public Builder level(final EntityLevel level) {
            this.level = level; 
            return this;
        }

        public Builder type(final EntityType type) {
            this.type = type;
            return this;
        }

        public Builder distance(final double distanceFactor) {
            this.distanceFactor = distanceFactor;
            return this;
        }

        public DynamicEntity build() {
            final DynamicEntity e = new DynamicEntityImpl(this.generatePoint(), image, level, type, speedX);
            e.setDistance(worldDimensions.getWidth() - image.getWidth());
            return e;
        }

        private Point2D.Double generatePoint() {
            final double x = worldDimensions.getWidth() * level.getSpawnX() + image.getWidth() * distanceFactor;
            final double y = worldDimensions.getHeight() * level.getSpawnY() - image.getHeight();
            return new Point2D.Double(x, y);
        }

    }

}
