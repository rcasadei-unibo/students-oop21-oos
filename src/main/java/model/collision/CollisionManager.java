package model.collision;

import java.util.List;

import model.Model;
import model.entity.DynamicEntity;
import model.player.Player;

public interface CollisionManager {

    /**
     * @param pl the Player
     * @param objects the list of Objects
     * @param model the Model
     */
    void playerCollidesWidth(Player pl, List<DynamicEntity> objects, Model model);

}
