package main.view;

import main.controller.Controller;

public interface View {

    void startMenu();

    void game();

    void gameOver();

    void shop();

    void render();

    Controller getController();

}
