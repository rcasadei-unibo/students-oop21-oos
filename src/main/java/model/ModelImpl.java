package model;

import java.util.List;

import model.entity.DynamicEntity;
import model.marker.MarkerManager;
import model.marker.MarkerManagerImpl;

public class ModelImpl implements Model {

    private final GameState gameState;
    private final Statistics statistics;
    private final CollisionManager collisionManager;
    private final MarkerManager markerManager;
    private final StatisticsUpdater statisticsUpdater;
    //private boolean isGameOVer;

    public ModelImpl() {
        this.gameState = new GameStateImpl();
        this.statistics = new StatisticsImpl();
        this.collisionManager = new CollisionManagerImpl();
        this.markerManager = new MarkerManagerImpl(this.statistics.getLastDeathDistance(), this.statistics.getRecordDistance());
        this.statisticsUpdater = new StatisticsUpdater(this.statistics, this.markerManager);
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
    public StatisticsUpdater getStatisticsUpdater() {
        return this.statisticsUpdater;
    }

    @Override
    public MarkerManager getMarkerManager() {
        return this.markerManager;
    }

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
