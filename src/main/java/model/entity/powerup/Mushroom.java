package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.TimerTask;

import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntityImpl;
import model.entity.EntityLevel;
import model.entity.EntityType;

public class Mushroom extends DynamicEntityImpl {

    private final EffectTimer mushroomTimer; 

    public Mushroom(final Double coordinates, final Image image, final EntityLevel level, final EntityType type) {
        super(coordinates, image, level, type);
        mushroomTimer = new EffectTimer(); 
    }

    @Override
    public void activateEffect(final Model model) {
        // TODO Auto-generated method stub
        //EFFETTO
        mushroomTask(model); 
    }

    private void mushroomTask(final Model model) {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //AZIONE PER QUANDO TORNA NORMALE 
            }
        };
        mushroomTimer.scheduleTask(task);
    }

}
