package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public final class Coin extends CollectibleEntityImpl {

    public Coin(final EntityLevelType level, final Dimension2D worldDimension, final Image image) {
        super(worldDimension, image, level);
    }

    @Override
    public void activateEffect() {
        /*
         * Aumento il valore delle monete contenuto nelle statistiche 
         * */
    }

}
