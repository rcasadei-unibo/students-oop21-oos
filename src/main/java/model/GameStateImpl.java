package model;

import java.util.LinkedList;
import java.util.List;

import model.entity.DynamicEntity;

public class GameStateImpl implements GameState {

    private Player player;
    private List<DynamicEntity> entities;

    public GameStateImpl() {
        this.player = new PlayerImpl();
        this.entities = new LinkedList<>();
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public List<DynamicEntity> getEntities() {
        return this.entities;
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        return false;
    }

}
