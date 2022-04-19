package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

/**
 * 
 * Class identifying a Game's Coin. 
 *
 */
public final class Coin extends AbstractDynamicEntity {

    private static int coinValue = 1; 
    /**
     * 
     * @param coordinates the coordinates of the {@link Coin} on the screen.
     * @param image the image which identifies the {@link Coin}.
     * @param level the level on which {@link Coin} should spawn.
     * @param type the type which identifies the {@link Coin}.
     */
    public Coin(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    /**
     * Method called when a {@link Coin} collides with the player, it increments
     * the total number of coin. 
     * @param model the model that represents the actual game state.
     */
    @Override
    public void activateEffect(final Model model) {
        model.getStatistics().increaseCoin(coinValue);
    }

    /**
     * Set the value of every {@link Coin} instance to the specified number.
     * @param coinvalue the value of a {@link Coin}.
     */
    public static void setCoinValue(final int coinvalue) {
        Coin.coinValue = coinvalue;
    }
}
