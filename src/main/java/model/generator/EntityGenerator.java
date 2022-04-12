package model.generator;

import java.util.List;

import model.entity.DynamicEntity;

public interface EntityGenerator {

    /**
     * 
     * @return a list containing the entity that are actually in the game.
     */
    List<DynamicEntity> getEntities();

    /**
     * 
     * @param speedX the speed of the entity.
     */
    void setSpeedX(double speedX);

    /**
     * Update the position of every entity in the list, remove and add element.
     */
    void updateList();

}
