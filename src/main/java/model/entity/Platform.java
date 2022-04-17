package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

/**
 * 
 * Class identifying a Game's Platform.
 *
 */
public final class Platform extends AbstractDynamicEntity {

    /**
     * 
     * @param coordinates the coordinates of the {@link Platform} on the screen.
     * @param image the image identifying an {@link Platform}.
     * @param level the level on which {@link Platform} should spawn.
     * @param type the type identifying an {@link Platform}.
     */
    public Platform(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    /**
     * Method called when an {@link Platform} collides with the player, in the actual game is never used
     * the collision with a {@link Platform} has no effect. 
     * @param model the model that  the actual game state. 
     */
    @Override
    public void activateEffect(final Model model) {

    }
}
