package view;

import controller.Controller;

public interface ViewController {

    void startMenu();

    void game();

    void gameOver();

    void shop();

    void render();

    Controller getController();

}
