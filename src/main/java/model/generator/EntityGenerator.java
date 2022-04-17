package model.generator;

import java.util.List;

import model.entity.DynamicEntity;

/**
 * 
 * Interface identifying the generator for {@link DynamicEntity}.
 *
 */
public interface EntityGenerator {

    /**
     * 
     * @return a list containing the entities that are actually on the game.
     */
    List<DynamicEntity> getEntities();

    /**
     * 
     * @param speedX the speed of the entities.
     */
    void setSpeedX(double speedX);

    /**
     * Update the position of every entity in the list, remove and add element.
     */
    void updateList();

}
