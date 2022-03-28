package main.view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.model.Player;

public class PlayerViewImpl implements PlayerView {

    //MANCA TUTTA L'ANIMAZIONE

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
    private Image spriteImage;

    //il player
    private Player player;

    public PlayerViewImpl(final Player player) {
        this.player = player;
        try {
            this.spriteImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(spriteImage, spriteX, spriteY, MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT, player.getX(), player.getY(), width, height);
}

}
