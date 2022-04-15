package model;

import model.marker.MarkerManager;

public interface Model {

    GameState getGameState();

    Statistics getStatistics();

    StatisticsUpdater getStatisticsUpdater();

    MarkerManager getMarkerManager();

    void update();

}
