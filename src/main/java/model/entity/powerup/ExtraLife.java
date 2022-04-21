package model.entity.powerup;

import java.awt.geom.Point2D.Double;

import javafx.scene.image.Image;
import model.Model;
import model.entity.AbstractDynamicEntity;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public class ExtraLife extends AbstractDynamicEntity {

    public ExtraLife(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type, final double distance) {
        super(coordinates, image, level, type, distance);
    }

    @Override
    public void activateEffect(final Model model) {
        model.getGameState().getPlayer().setNumberOfLives(1);
    }

}
