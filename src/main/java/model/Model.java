package model;

public interface Model {

    GameState getGameState();

    Statistics getStatistics();

    StatisticsUpdater getStatisticsUpdater();

    void update();

}
