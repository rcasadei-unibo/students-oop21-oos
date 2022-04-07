package view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import model.entity.DynamicEntity;

public class PlayerViewImpl implements PlayerView {

    private final Pane pane; 
    /**
     * Width of the sprite.
     */
    public static final int MAIN_CHARACTER_WIDTH = 96;
    /**
     * Height of the sprite.
     */
    public static final int MAIN_CHARACTER_HEIGHT = 96;
    /**
     * Where to find the image with all the png.
     */
    public static final String IMAGE_PATH = "src/main/resources/Player1.png";

    /*public static final int TOTAL_MOVEMENTS = 2;
    public static final int NORMAL = 0;
    public static final int JUMP = 1;

    //coordinate dello sprite nel png per scegliere l'orso che mi serve
    private int spriteX;
    private int spriteY;
    private int currentDirection;
    private byte currentSprite;

    private int[][] spriteXCoordinates = new int[TOTAL_MOVEMENTS][];
    private int[][] spriteYCoordinates = new int[TOTAL_MOVEMENTS][];*/

    //il player
    private Player player;
    private ImageView lastSpriteImage;

    public PlayerViewImpl(final Pane pane, final Player pl) {
        this.pane = pane;
        this.player = pl;
        /*this.currentDirection = NORMAL;
        this.currentSprite = 0;
        try {
            image = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
            this.spriteImage = new ImageView(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        spriteXCoordinates[NORMAL] = new int[] {480}; //la coordinata delle prime due immagini
        spriteYCoordinates[NORMAL] = new int[] {0, 0, 0, 0};
        spriteXCoordinates[JUMP] = new int[] {1248, 1344, 1440}; // le ccoridnate delle altre
        spriteYCoordinates[JUMP] = new int[] {0, 0, 0, 0};*/
    }

    /*private void animate() {
        if (this.player.isJumping() && this.currentDirection != JUMP) {
            this.currentDirection = JUMP;
            this.currentSprite = 0;
        } else if (!this.player.isJumping() && this.currentDirection != NORMAL) {
            this.currentDirection = NORMAL;
            this.currentSprite = 0;
        } else {
            this.currentSprite = (byte) ((this.currentSprite + 1)
                    %  spriteXCoordinates[this.currentDirection].length);
        }

        spriteX = spriteXCoordinates[this.currentDirection][this.currentSprite];
        spriteY = spriteYCoordinates[this.currentDirection][this.currentSprite];
    }*/

    @Override
    public void render() {
        this.pane.getChildren().remove(lastSpriteImage);
        this.lastSpriteImage = this.createImage(player);
        //dire quale è la sprite imagine da mettere
        this.pane.getChildren().add(this.lastSpriteImage);
    }

    private ImageView createImage(final Player pl) {
        final ImageView image = new ImageView(IMAGE_PATH);
        image.setPreserveRatio(true);
        image.setX(pl.getX());
        image.setY(pl.getY());
        image.setFitHeight(MAIN_CHARACTER_HEIGHT);
        image.setFitWidth(MAIN_CHARACTER_WIDTH);
        return image;
    }

}
