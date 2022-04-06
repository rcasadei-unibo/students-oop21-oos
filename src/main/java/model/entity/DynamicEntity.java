package model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import model.Model;

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
     * Check if the entity is out of the screen.
     * @return true if the entity is out of the screen, false otherwise 
     */
    boolean isOutofScreen();

    /**
     * Get the image related with the entity.
     * @return the image corresponding to the entity
     */
    Image getImage();

    /**
     * 
     * @return the level in which the entity is placed. 
     */
    EntityLevel getLevelType();

    /**
     * 
     * @return the type of entity created.
     */
    EntityType getType();

    /**
     * 
     * @return the distance of the next entity
     */
    double getDistance();

    /**
     * Set the field distance. 
     * @param distance distance of the next entity
     */
    void setDistance(double distance);

    /**
     * Activate the effect related to the entity, when it gets hit. 
     * @param model 
     */
    void activateEffect(Model model);
}