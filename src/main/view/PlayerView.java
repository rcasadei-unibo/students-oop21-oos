package main.view;

import javafx.scene.canvas.GraphicsContext;

public interface PlayerView {

    /**
     * @param gc the GrapicsContext where to show the player
     */
    void render(GraphicsContext gc);
}
