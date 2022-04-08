package view.entity;

import javafx.scene.image.Image;

public enum EntityImages {

    /**
     * Obstacle's image (hydrant).
     */
    OBSTACLE_ONE("Hydrant.png"),

    /**
     * Obstacle's image (road cone).
     */
    OBSTACLE_TWO("RoadCone.png"),

    /**
     * Coin's image.
     */
    COIN("Coin.png"),

    /**
     * Platform's image.
     */
    PLATFORM("Platform.png"),

    /**
     * Extralife powerup's image. 
     */
    EXTRALIFE("ExtraLife.png"), 

    /**
     * Mushroom powerup's image. 
     */
    MUSHROOM("Mushroom.png"), 

    /**
     * Shield powerup's image. 
     */
    SHIELD("Shield.png"), 

    /**
     * Spraybomb powerup's image. 
     */
    SPRAYBOMB("SprayBomb.png"), 

    /**
     * Superjump powerup's image. 
     */
    SUPERJUMP("SuperJump.png"); 

    private String path;

    EntityImages(final String path) {
        this.path = path;
    }

    public Image getImageFromPath() {
        return new Image(this.path);
    }

}
