package model;

import java.util.List;

import model.entity.DynamicEntity;

public interface GameState {

    Player getPlayer();

    List<DynamicEntity> getEntities();

    boolean isGameOver();

    void update();

    void setVelocity(double difficulty);

}
