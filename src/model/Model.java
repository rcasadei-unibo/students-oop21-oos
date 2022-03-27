package model;

public interface Model {

    GameState getGameState();

    Statistics getStatistics();

    void update();

}
