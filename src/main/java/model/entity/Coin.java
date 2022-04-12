package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

public final class Coin extends DynamicEntityImpl {

    private static final int COIN_VALUE = 1; 

    Coin(final Double coordinates, final Image image, final EntityLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    @Override
    public void activateEffect(final Model model) {
        model.getStatistics().increaseCoin(COIN_VALUE);
    }
}
