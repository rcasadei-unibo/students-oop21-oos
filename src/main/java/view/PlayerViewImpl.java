package view;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.player.JumpState;
import model.player.Player;
import model.player.PlayerImpl;

public final class PlayerViewImpl implements PlayerView {

    private final Pane pane; 

    private static final byte SPRITE_CHANGE = 40;
    private static final int IMAGE1 = 131;
    private static final int IMAGE2 = 175;
    private static final int IMAGE3 = 221;
    private static final int IMAGE4 = 252;
    private static final int IMAGE5 = 307;
    private static final int HEIGHT = 208;
    private static final int IMAGE_WIDTH = 35;
    private static final int IMAGE_HEIGHT = 45;

    private String imagePath;

    //coordinate dello sprite nel png per scegliere l'orso che mi serve
    private int spriteX;
    private int spriteY;
    private JumpState currentDirection;
    private byte currentSprite;
    private byte currentSpriteChange;

    private final Map<JumpState, int[]> spriteXCoordinates = new HashMap<>();
    private final Map<JumpState, int[]> spriteYCoordinates = new HashMap<>();

    private final Player player;
    private ImageView lastSpriteImage;

    public PlayerViewImpl(final Pane pane, final Player pl) {
        this.pane = pane;
        this.player = pl;
        this.currentDirection = JumpState.NOT_JUMPING;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;
        this.imagePath = "Player2giusto.png";

        spriteXCoordinates.put(JumpState.NOT_JUMPING, new int[] {IMAGE1, IMAGE2, IMAGE3});
        spriteYCoordinates.put(JumpState.NOT_JUMPING, new int[] {HEIGHT, HEIGHT, HEIGHT});
        spriteXCoordinates.put(JumpState.UP, new int[] {IMAGE4});
        spriteYCoordinates.put(JumpState.UP, new int[] {210});
        spriteXCoordinates.put(JumpState.DOWN, new int[] {IMAGE5});
        spriteYCoordinates.put(JumpState.DOWN, new int[] {HEIGHT});
    }

    private void animate() {
        if (this.player.getJumpState() == JumpState.UP && this.currentDirection != JumpState.UP) {
            this.changeDirection(JumpState.UP);
        } else if (this.player.getJumpState() == JumpState.NOT_JUMPING 
                    && this.currentDirection != JumpState.NOT_JUMPING) {
            this.changeDirection(JumpState.NOT_JUMPING);
        } else if (this.player.getJumpState() == JumpState.DOWN && this.currentDirection != JumpState.DOWN) {
            this.changeDirection(JumpState.DOWN);
        } else {
            this.currentSpriteChange++;
                if (currentSpriteChange >= SPRITE_CHANGE) {
                        currentSprite = (byte) ((currentSprite + 1) 
                        % spriteXCoordinates.get(currentDirection).length);
                        currentSpriteChange = 0;
                }
        }
        spriteX = spriteXCoordinates.get(this.currentDirection)[this.currentSprite];
        spriteY = spriteYCoordinates.get(this.currentDirection)[this.currentSprite];
    }

    private void changeDirection(final JumpState dir) {
        this.currentDirection = dir;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;
    }

    @Override
    public void render() {
        this.pane.getChildren().remove(lastSpriteImage);
        this.animate();
        this.lastSpriteImage = this.createImage(player);
        //dire quale è la sprite imagine da mettere
        this.pane.getChildren().add(this.lastSpriteImage);
    }

    private ImageView createImage(final Player pl) {
        final ImageView image = new ImageView(new Image(imagePath));
        image.setViewport(new Rectangle2D(spriteX, spriteY, IMAGE_WIDTH, IMAGE_HEIGHT));
        image.setPreserveRatio(true);
        image.setX(pl.getBounds().getMinX());
        image.setY(pl.getBounds().getMinY());
        image.setFitHeight(PlayerImpl.MAIN_CHARACTER_HEIGHT);
        image.setFitWidth(PlayerImpl.MAIN_CHARACTER_WIDTH);
        return image;
    }

    @Override
    public void setImage(final String path) {
        this.imagePath = path;
    }
}
