package main.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.model.Player;

public class PlayerViewImpl implements PlayerView {

    //MANCA TUTTA L'ANIMAZIONE

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
    public static final String IMAGE_PATH = "assets/bear.png";

    //coordinate dello sprite nel png per scegliere l'orso che mi serve
    private int spriteX;
    private int spriteY;

    //il png
    private ImageView spriteImage;

    //il player
    private Player player;

    public PlayerViewImpl(final Pane pane) {
        this.pane = pane;
        /*try {
            this.spriteImage = spriteImage; //mettere l'immagine;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void render(final Player pl) {
        this.pane.getChildren().remove(spriteImage);
        //dire quale è la sprite imagine da mettere
        this.pane.getChildren().add(spriteImage);
    }

}
