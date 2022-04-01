package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Obstacle extends DynamicEntityImpl {

    private static final double DISTANCE_FACTOR = 5.0;

    public Obstacle(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(worldDimension, image, level, image.getWidth() * DISTANCE_FACTOR);
        super.setDistance(worldDimension.getWidth() - image.getWidth() * DISTANCE_FACTOR);
    }

}
