package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.AbstractDynamicEntity;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public final class Shield extends AbstractDynamicEntity {
 
    private static final boolean ACTIVATESHIELD = true; 
    private final EffectTimer shieldTimer; 

    public Shield(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
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
