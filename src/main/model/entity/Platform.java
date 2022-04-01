package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Platform extends DynamicEntityImpl {

    private static final double DISTANCE_FACTOR = 0.0;

    public Platform(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(worldDimension, image, level, DISTANCE_FACTOR);
        super.setDistance(worldDimension.getWidth() - image.getWidth());
    }

}
