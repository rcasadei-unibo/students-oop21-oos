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

}
