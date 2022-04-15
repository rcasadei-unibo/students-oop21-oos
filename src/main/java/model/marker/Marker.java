package model.marker;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public interface Marker {

    void update(double velocity);

    boolean isOutOfScreen();

    double getX();

    double getY();

    Dimension2D getDimension();

    Image getImage();

    String getText();

}
