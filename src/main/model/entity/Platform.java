package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Platform extends DynamicEntityImpl {

    public Platform(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(worldDimension, image, level);
    }

}
