package model;

import java.util.List;

import model.entity.DynamicEntityImpl;

public interface CollisionManager {

    /**
     * @param pl the Player
     * @param objects the list of Objects
     * @param model the Model
     */
    void playerCollidesWidth(Player pl, List<DynamicEntityImpl> objects, Model model);

}
