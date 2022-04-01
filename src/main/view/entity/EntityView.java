package main.view.entity;

import java.util.List;

import main.model.entity.DynamicEntity;

/**
 * 
 * Interface of the EntityView.
 *
 */
public interface EntityView {

    /**
     * Show all the entities currently present in game.
     * @param entities the list of entities to show.
     */
    void render(List<DynamicEntity> entities);
}
