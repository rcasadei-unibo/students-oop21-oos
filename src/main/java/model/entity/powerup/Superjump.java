package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.AbstractDynamicEntity;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public final class Superjump extends AbstractDynamicEntity {

    private static final boolean ACTIVATESUPERJUMP = true; 
    private final EffectTimer jumpTimer; 

    public Superjump(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type, final double distance) {
        super(coordinates, image, level, type, distance);
        jumpTimer = new EffectTimer(); 
    }

    @Override
    public void activateEffect(final Model model) {
        model.getGameState().getPlayer().setDoubleJump(ACTIVATESUPERJUMP);
        jumpTask(model);
    }

    private void jumpTask(final Model model) {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                model.getGameState().getPlayer().setDoubleJump(!ACTIVATESUPERJUMP);
            }
        };
        jumpTimer.scheduleTask(task);
    }

}
