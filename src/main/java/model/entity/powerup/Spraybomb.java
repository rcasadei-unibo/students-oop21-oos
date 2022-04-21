package model.entity.powerup;

import java.awt.geom.Point2D.Double;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.Model;
import model.entity.AbstractDynamicEntity;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public class Spraybomb extends AbstractDynamicEntity {

    public Spraybomb(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type, final double distance) {
        super(coordinates, image, level, type, distance);
    }

    /**
     * Activates the Spraybomb effect.
     */
    @Override
    public final void activateEffect(final Model model) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                model.getGameState().getEntities().clear();
            }
        }); 
    }

}
