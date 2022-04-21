package view.player;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.player.JumpState;
import model.player.Player;
import model.player.PlayerImpl;

/**
 * 
 * Class that render the Player during the game.
 *
 */
public final class PlayerViewImpl implements PlayerView {

    private static final byte SPRITE_CHANGE = 40;
    private static final int IMAGE1 = 15; 
    private static final int IMAGE2 = 120;
    private static final int IMAGE3 = 225;
    private static final int IMAGE4 = 330;
    private static final int IMAGE5 = 450;
    private static final int HEIGHT = 20;
    private static final int IMAGE_WIDTH = 90;
    private static final int IMAGE_HEIGHT = 140; 

    private final Pane pane; 
    private final Player player;
    private JumpState currentState;
    private byte currentSprite;
    private byte currentSpriteChange;
    private final Map<JumpState, int[]> spriteXCoordinates = new HashMap<>();
    private final Map<JumpState, int[]> spriteYCoordinates = new HashMap<>();
    private int spriteX;
    private int spriteY;
    private ImageView spriteImage;

    /**
     * @param pane the pane where to draw the entity. 
     * @param pl the Player to render. 
     */
    public PlayerViewImpl(final Pane pane, final Player pl) {
        this.pane = pane;
        this.player = pl;
        this.currentState = JumpState.NOT_JUMPING;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;
        spriteXCoordinates.put(JumpState.NOT_JUMPING, new int[] {IMAGE1, IMAGE2, IMAGE3});
        spriteYCoordinates.put(JumpState.NOT_JUMPING, new int[] {HEIGHT, HEIGHT, HEIGHT});
        spriteXCoordinates.put(JumpState.UP, new int[] {IMAGE4});
        spriteYCoordinates.put(JumpState.UP, new int[] {HEIGHT});
        spriteXCoordinates.put(JumpState.DOWN, new int[] {IMAGE5});
        spriteYCoordinates.put(JumpState.DOWN, new int[] {HEIGHT});
    }

    /**
     * Changes the image based on the JumpState, and animate the NOT_JUMPING
     * state with three different images.
     */
    private void animate() {
        if (!this.changeState()) {
            this.currentSpriteChange++;
                if (currentSpriteChange >= SPRITE_CHANGE) {
                        currentSprite = (byte) ((currentSprite + 1) 
                        % spriteXCoordinates.get(currentState).length);
                        currentSpriteChange = 0;
                }
        }
        spriteX = spriteXCoordinates.get(this.currentState)[this.currentSprite];
        spriteY = spriteYCoordinates.get(this.currentState)[this.currentSprite];
    }

    /**
     * Change the curentState if it's different from player's state.
     * @return true if currentState have been changed
     */
    private boolean changeState() {
        if (this.player.getJumpState() != this.currentState) {
            this.currentState = this.player.getJumpState();
            this.currentSprite = 0;
            this.currentSpriteChange = 0;
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        this.pane.getChildren().remove(spriteImage);
        this.animate();
        this.spriteImage = this.createImage(player);
        this.pane.getChildren().add(this.spriteImage);
    }

    /**
     * Create the Image of the player.
     * @param pl the Player
     * @return the right ImageView of the Player
     */
    private ImageView createImage(final Player pl) {
        final ImageView image = new ImageView(pl.getImage());
        image.setViewport(new Rectangle2D(spriteX, spriteY, IMAGE_WIDTH, IMAGE_HEIGHT));
        image.setPreserveRatio(true);
        image.setX(pl.getBounds().getMinX());
        image.setY(pl.getBounds().getMinY());
        image.setFitHeight(PlayerImpl.MAIN_CHARACTER_HEIGHT);
        image.setFitWidth(PlayerImpl.MAIN_CHARACTER_WIDTH);
        return image;
    }
}
