package model;

public class ModelImpl implements Model {

    private GameState gameState;
    private Statistics statistics;

    public ModelImpl() {
        this.gameState = new GameStateImpl();
        this.statistics = new StatisticsImpl();
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
        this.statistics.update();
    }

}
