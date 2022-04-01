package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Obstacle extends DynamicEntityImpl {

    public Obstacle(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(worldDimension, image, level);
    }

}
