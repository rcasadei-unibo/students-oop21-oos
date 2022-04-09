package model;

import java.util.List;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.generator.EntityGenerator;
import model.generator.EntityGeneratorImpl;

public class GameStateImpl implements GameState {

    private Player player;
    private EntityGenerator entityGenerator;
    private List<DynamicEntity> entities;

    public GameStateImpl() {
        this.player = new PlayerImpl();
        this.entityGenerator = new EntityGeneratorImpl(new Dimension2D(854, 480));
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public List<DynamicEntity> getEntities() {
        return this.entityGenerator.getEntities();
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update() {
        this.player.updateJump();
        this.entityGenerator.updateList();
    }

}
