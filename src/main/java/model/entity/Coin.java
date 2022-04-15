package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

public final class Coin extends DynamicEntityImpl {

    private static int coinValue = 1; 

    Coin(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    @Override
    public void activateEffect(final Model model) {
        model.getStatistics().increaseCoin(coinValue);
    }

    public static void setCoinValue(final int coinvalue) {
        Coin.coinValue = coinvalue;
    }
}
