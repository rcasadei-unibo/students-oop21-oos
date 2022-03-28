package main.model.entity;

import java.awt.geom.Point2D.Double;

import javafx.geometry.Dimension2D;

public final class Obstacle extends DynamicEntityImpl {

    public Obstacle(final Double coordinates, final Dimension2D dimensions) {
        super(coordinates, dimensions);
    }

}
