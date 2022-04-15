package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntityImpl;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public final class Superjump extends DynamicEntityImpl {

    private static final int SUPERJUMP_HEIGHT = 2; 
    private static final double NORMALJUMP_HEIGHT = 0.5; 
    private final EffectTimer jumpTimer; 

    public Superjump(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
        jumpTimer = new EffectTimer(); 
    }

    @Override
    public void activateEffect(final Model model) {
        //model.getGameState().getPlayer().setJumpHeight(SUPERJUMP_HEIGHT);
        jumpTask(model);
    }

    private void jumpTask(final Model model) {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //model.getGameState().getPlayer().setJumpHeight(NORMALJUMP_HEIGHT);
            }
        };
        jumpTimer.scheduleTask(task);
    }

}
