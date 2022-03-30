package main.model.entity;

import java.awt.geom.Point2D;
import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Obstacle extends DynamicEntityImpl {

    public Obstacle(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(generatePoint(worldDimension, image, level), generateDimension(image), level);
        super.setImage(image);
    }

    private static Point2D.Double generatePoint(final Dimension2D worldDimenion, final Image image, final EntityLevelType level) {
        final double x = worldDimenion.getWidth() * level.getSpawnX();
        final double y = worldDimenion.getHeight() * level.getSpawnY() - image.getHeight();
        return new Point2D.Double(x, y);
    }

    private static Dimension2D generateDimension(final Image image) {
        return new Dimension2D(image.getWidth(), image.getHeight());
    }

}
