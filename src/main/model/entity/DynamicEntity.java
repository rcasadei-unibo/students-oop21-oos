package main.model.entity;

import javafx.geometry.Rectangle2D;

public interface DynamicEntity {

    /**
     * Updates the entity position on the screen.
     * */
    void updatePosition();
    /**
     * 
     * @return a new Rectangle2D that represents the coordinates and the dimension of the entity
     */
    Rectangle2D getBounds();

    /**
     * Set the speed of the entity.
     * @param speedX 
     */
    void setSpeedX(double speedX);

    /**
     * Check if the entity is out of the screen.
     * @return true if the entity is out of the screen, false otherwise 
     */
    boolean isOutofScreen();

}
