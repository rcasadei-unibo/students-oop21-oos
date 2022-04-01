package main.view.entity;

import javafx.scene.image.Image;

public enum EntityImages {

    /**
     * Obstacle's image (hydrant).
     */
    OBSTACLE_ONE("res/Hydrant.png"),

    /**
     * Obstacle's image (road cone).
     */
    OBSTACLE_TWO("res/RoadCone.png"),

    /**
     * Coin's image.
     */
    COIN("res/Coin.png"),

    /**
     * Platform's image.
     */
    PLATFORM("res/Platform.png");

    private String path;

    EntityImages(final String path) {
        this.path = path;
    }

    public String getImagePath() {
        return this.path;
    }

    public Image getImageFromPath() {
        return new Image(this.path);
    }

}
