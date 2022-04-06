package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

public final class Coin extends DynamicEntityImpl {

    Coin(final Double coordinates, final Image image, final EntityLevel level, final EntityType type, final double speedX) {
        super(coordinates, image, level, type, speedX);
    }

    @Override
    public void activateEffect(final Model model) {
        /*Manca implementazione metodo*/
    }
}
