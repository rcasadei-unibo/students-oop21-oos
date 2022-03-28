package main.model.generator;

import java.util.List;

import main.model.entity.DynamicEntity;

public interface EntityGenerator {

    /**
     * 
     * @return a list containing the entity that are actually in the game.
     */
    List<DynamicEntity> getEntityList();

    /**
     * Update the position of every entity in the list, remove and add element.
     */
    void updateList();

    /**
     * Add a DynamicEntity to the list.
     */
    void addEntity();

    /**
     * Remove entity from the list, if it isn't empty and the entity is out of the screen.
     */
    void removeEntity();

    /**
     * 
     * @return true if the distance to spawn a new entity is , false otherwise. 
     */
    boolean checkPosition();
}
