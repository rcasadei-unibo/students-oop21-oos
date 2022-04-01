package main.model;

import java.util.List;

import main.model.entity.DynamicEntity;

public interface GameState {

    Player getPlayer();

    List<DynamicEntity> getEntities();

    boolean isGameOver();

}
