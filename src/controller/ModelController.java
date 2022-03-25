package controller;

import model.GameState;
import model.Statistics;

public interface ModelController {

    GameState getGameState();

    Statistics getStatistics();

    void update();

}
