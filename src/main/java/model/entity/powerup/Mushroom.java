package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.Coin;
import model.entity.DynamicEntityImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public class Mushroom extends DynamicEntityImpl {

    private final EffectTimer mushroomTimer; 
    private static final int DOUBLECOIN = 2; 
    private static final int STDCOIN = 1; 

    public Mushroom(final Double coordinates, final Image image, final EntityLevel level, final EntityType type) {
        super(coordinates, image, level, type);
        mushroomTimer = new EffectTimer(); 
    }

    @Override
    public void activateEffect(final Model model) {
        Coin.setCoinValue(DOUBLECOIN);
        mushroomTask(model); 
    }

    private void mushroomTask(final Model model) {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Coin.setCoinValue(STDCOIN);
            }
        };
        mushroomTimer.scheduleTask(task);
    }

}
