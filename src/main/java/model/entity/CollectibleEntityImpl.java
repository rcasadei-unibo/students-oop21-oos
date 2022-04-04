package model.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public abstract class CollectibleEntityImpl extends DynamicEntityImpl implements CollectibleEntity {

    private static final int DISTANCE_FACTOR = 5;
    private boolean collected;

    public CollectibleEntityImpl(final Dimension2D worldDimension, final Image image, final EntityLevelType level) {
        super(worldDimension, image, level, image.getWidth() * DISTANCE_FACTOR);
        super.setDistance(worldDimension.getWidth() - image.getWidth() * DISTANCE_FACTOR);
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
