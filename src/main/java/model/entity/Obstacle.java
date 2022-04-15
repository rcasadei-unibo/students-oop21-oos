package model.entity;

import java.awt.geom.Point2D.Double;
import javafx.scene.image.Image;
import model.Model;

public class Obstacle extends DynamicEntityImpl {

    private static final int DOWN_LIFE = -1;

    public Obstacle(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    @Override
    public final void activateEffect(final Model model) {
        model.getGameState().getPlayer().setNumberOfLives(DOWN_LIFE);
    }
}
