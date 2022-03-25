package view;

import controller.Controller;

public interface View {

    void startMenu();

    void game();

    void gameOver();

    void shop();

    void render();

    Controller getController();

}
