package main.model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public abstract class CollectibleEntityImpl extends DynamicEntityImpl implements CollectibleEntity {

    private boolean collected;

    public CollectibleEntityImpl(final Dimension2D worldDimensions, final Image image, final EntityLevelType level) {
        super(worldDimensions, image, level);
        this.collected = false;
    }

    @Override
    public final void setCollected(final boolean collectedState) {
        this.collected = collectedState;
    }

    @Override
    public final boolean wasCollected() {
        return this.collected;
    }

    @Override
    public abstract void activateEffect();

}
