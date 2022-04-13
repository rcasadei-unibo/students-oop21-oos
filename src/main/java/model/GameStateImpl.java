package model;

import java.util.List;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.generator.EntityGenerator;
import model.generator.EntityGeneratorImpl;

public class GameStateImpl implements GameState {

    private final Player player;
    private final EntityGenerator entityGenerator;

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
        return this.player.getLives() < 1;
    }

    @Override
    public void update() {
        this.player.updateJump();
        this.entityGenerator.updateList();
    }

    @Override
    public void setVelocity(final double difficulty) {
        this.entityGenerator.setSpeedX(difficulty);
    }

}
