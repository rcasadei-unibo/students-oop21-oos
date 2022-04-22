package controller;

import model.Model;

/**
 * 
 * The controller of the application.
 *
 */
public interface Controller {

    /**
     * Prepares the game to start.
     * 
     */
    void setup();

    /**
     * Process the input.
     * 
     */
    void processInput();

    /**
     * Updates the {@link Model}.
     * 
     */
    void update();

    /**
     * Renders the {@link View}.
     * 
     */
    void render();

    /**
     * Starts the game loop.
     * 
     */
    void start();

    /**
     * Stops the game loop.
     * 
     */
    void stop();

    /**
     * Gets the {@link Model}.
     * @return the {@link Model}.
     */
    Model getModel();

    /**
     * Gets the width of the game screen.
     * @return the width of the game screen.
     */
    double getWidth();

    /**
     * Gets the height of the game screen.
     * @return the height of the game screen.
     */
    double getHeight();
}
