package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntityImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public final class Shield extends DynamicEntityImpl {
 
    private static final boolean ACTIVATESHIELD = true; 
    private final EffectTimer shieldTimer; 

    public Shield(final Double coordinates, final Image image, final EntityLevel level, final EntityType type, final double speedX) {
        super(coordinates, image, level, type, speedX);
        shieldTimer = new EffectTimer(); 
    }

    @Override
    public void activateEffect(final Model model) {
        model.getGameState().getPlayer().setShield(ACTIVATESHIELD);
        shieldTask(model); 
    }

    private void shieldTask(final Model model) {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                model.getGameState().getPlayer().setShield(!ACTIVATESHIELD);
            }
        };
        shieldTimer.scheduleTask(task);
    }

}
