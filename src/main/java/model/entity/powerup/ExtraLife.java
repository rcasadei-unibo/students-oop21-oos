package model.entity.powerup;

import java.awt.geom.Point2D.Double;

import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntityImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public class ExtraLife extends DynamicEntityImpl {

    public ExtraLife(final Double coordinates, final Image image, final EntityLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    @Override
    public void activateEffect(final Model model) {
        model.getGameState().getPlayer().setNumberOfLives(2);
    }

    //Mi serve il getter della vita del personaggio di Sara 

}
