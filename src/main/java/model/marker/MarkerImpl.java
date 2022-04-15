package model.marker;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public class MarkerImpl implements Marker {

    private final Point2D.Double coordinates;
    private final Image image;
    private final Dimension2D dimension;
    private final String text;

    public MarkerImpl(final Double coordinates, final Image image, final String text) {
        super();
        this.coordinates = coordinates;
        this.image = image;
        this.dimension = new Dimension2D(this.image.getWidth(), this.image.getHeight());
        this.text = text;
    }

    @Override
    public void update(final double velocity) {
        this.coordinates.setLocation(this.coordinates.getX() - velocity, this.coordinates.getY());
    }

    @Override
    public boolean isOutOfScreen() {
        return this.coordinates.getX() < -this.dimension.getWidth();
    }

    @Override
    public double getX() {
        return this.coordinates.getX();
    }

    @Override
    public double getY() {
        return this.coordinates.getY();
    }

    @Override
    public Dimension2D getDimension() {
        return this.dimension;
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public String getText() {
        return this.text;
    }

}
