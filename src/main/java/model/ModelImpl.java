package model;

import java.util.List;

import model.entity.DynamicEntity;
import model.marker.MarkerManager;
import model.marker.MarkerManagerImpl;

/**
 * 
 * An implementation of {@link Model}.
 *
 */
public class ModelImpl implements Model {

    private final GameState gameState;
    private final Statistics statistics;
    private final CollisionManager collisionManager;
    private final MarkerManager markerManager;
    private final StatisticsUpdater statisticsUpdater;

    /**
     * Creates a new ModelImpl initially with new {@link GameState}, {@link Statistics}, {@link CollisionManager},
     * {@link MarkerManager}, {@link StatisticsUpdater}.
     * 
     */
    public ModelImpl() {
        this.gameState = new GameStateImpl();
        this.statistics = new StatisticsImpl();
        this.collisionManager = new CollisionManagerImpl();
        this.markerManager = new MarkerManagerImpl(this.statistics.getLastDeathDistance(), this.statistics.getRecordDistance());
        this.statisticsUpdater = new StatisticsUpdater(this.statistics, this.markerManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Statistics getStatistics() {
        return this.statistics;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StatisticsUpdater getStatisticsUpdater() {
        return this.statisticsUpdater;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MarkerManager getMarkerManager() {
        return this.markerManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.gameState.update();
        this.markerManager.update(this.statistics.getDifficulty());

        final Player player = this.gameState.getPlayer();
        final List<DynamicEntity> entities = this.gameState.getEntities();
        this.collisionManager.playerCollidesWidth(player, entities, this);

        this.gameState.setVelocity(this.statistics.getDifficulty());
    }

}
