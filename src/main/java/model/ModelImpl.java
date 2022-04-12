package model;

import java.util.List;

import model.entity.DynamicEntity;

public class ModelImpl implements Model {

    private final GameState gameState;
    private final Statistics statistics;
    private final CollisionManager collisionManager;
    //private boolean isGameOVer;

    public ModelImpl() {
        this.gameState = new GameStateImpl();
        this.statistics = new StatisticsImpl();
        this.collisionManager = new CollisionManagerImpl();
        //this.isGameOVer = false;
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public Statistics getStatistics() {
        return this.statistics;
    }

    @Override
    public void update() {
        this.gameState.update();

        final Player player = this.gameState.getPlayer();
        final List<DynamicEntity> entities = this.gameState.getEntities();
        this.collisionManager.playerCollidesWidth(player, entities, this);

        this.statistics.update();
        this.gameState.setVelocity(this.statistics.getDifficulty());
    }

}
