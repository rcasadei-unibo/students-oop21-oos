package main.model.entity;

import java.awt.geom.Point2D.Double;

import javafx.geometry.Dimension2D;

public abstract class CollectibleEntityImpl extends DynamicEntityImpl implements CollectibleEntity {

    private boolean collected;

    public CollectibleEntityImpl(final Double coordinates, final Dimension2D dimensions, final EntityLevelType level) {
        super(coordinates, dimensions, level);
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
