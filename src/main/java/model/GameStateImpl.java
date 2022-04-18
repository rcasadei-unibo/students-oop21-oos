package model;

import java.util.List;

import javafx.geometry.Dimension2D;
import model.entity.DynamicEntity;
import model.generator.EntityGenerator;
import model.generator.EntityGeneratorImpl;

/**
 * 
 * An implementation of {@link GameState}.
 *
 */
public class GameStateImpl implements GameState {

    private final Player player;
    private final EntityGenerator entityGenerator;

    /**
     * Creates a new GameStateImpl initially with a new {@link Player} and a new {@link EntityGenerator}.
     * 
     */
    public GameStateImpl() {
        this.player = new PlayerImpl();
        this.entityGenerator = new EntityGeneratorImpl(new Dimension2D(854, 480));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DynamicEntity> getEntities() {
        return this.entityGenerator.getEntities();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isGameOver() {
        return this.player.getLives() < 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.player.updateJump();
        this.entityGenerator.updateList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVelocity(final double difficulty) {
        this.entityGenerator.setSpeedX(difficulty);
    }

}
