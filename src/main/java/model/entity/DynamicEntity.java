package model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import model.Model;

/**
 * 
 * Interface that identify an entity that moves on the screen.
 *
 */
public interface DynamicEntity {

    /**
     * Updates the entity position on the screen.
     * @param speedX the speed by which entity should move.
     * */
    void updatePosition(double speedX);

    /**
     * Returns the entity Bounding Box.
     * @return a new Rectangle2D that represents the coordinates and the dimension of the entity.
     */
    Rectangle2D getBounds();

    /**
     * Check if the entity is out of the screen.
     * @return true if the entity is out of the screen, false otherwise.
     */
    boolean isOutofScreen();

    /**
     * Get the image defining the entity.
     * @return the image corresponding to the entity
     */
    Image getImage();

    /**
     * 
     * @return the level on which entity spawn. 
     */
    SpawnLevel getLevel();

    /**
     * 
     * @return the type that identify the entity.
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
     * Set the hit field.
     * @param hit true if the entity collided with the player, false otherwise.
     */
    void hit(boolean hit);

    /**
     * 
     * @return true if the entity collided with the player, false otherwise.
     */
    boolean wasHit();

    /**
     * Activate the effect related to the entity, when it collides with the player. 
     * @param model the actual state of the game. 
     */
    void activateEffect(Model model);
}
