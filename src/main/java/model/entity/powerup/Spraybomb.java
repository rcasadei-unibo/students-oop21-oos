package model.entity.powerup;

import java.awt.geom.Point2D.Double;

import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntityImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public class Spraybomb extends DynamicEntityImpl {

    public Spraybomb(final Double coordinates, final Image image, final EntityLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    //Da rivedere 
    @Override
    public void activateEffect(final Model model) {
        // TODO Auto-generated method stub
        model.getGameState().getEntities().clear();
    }

}
