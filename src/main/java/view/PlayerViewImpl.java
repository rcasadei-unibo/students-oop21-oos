package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import model.PlayerImpl;

public final class PlayerViewImpl implements PlayerView {

    private final Pane pane; 

    /**
     * The total of the movements.
     */
    public static final int TOTAL_MOVEMENTS = 3;
    /**
     * The normal direction.
     */
    public static final int NORMAL = 0;
    /**
     * Jump direction.
     */
    public static final int JUMP = 1;
    /**
     * Down direction.
     */
    public static final int DOWN = 2;
    /**
     * How often i have to change the sprite.
     */
    public static final byte SPRITE_CHANGE = 40;

    private String imagePath;

    //coordinate dello sprite nel png per scegliere l'orso che mi serve
    private int spriteX;
    private int spriteY;
    private int currentDirection;
    private byte currentSprite;
    private byte currentSpriteChange;

    private final int[][] spriteXCoordinates = new int[TOTAL_MOVEMENTS][];
    private final int[][] spriteYCoordinates = new int[TOTAL_MOVEMENTS][];

    //il player
    private final PlayerImpl player;
    private ImageView lastSpriteImage;

    public PlayerViewImpl(final Pane pane, final PlayerImpl pl) {
        this.pane = pane;
        this.player = pl;
        this.currentDirection = NORMAL;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;
        this.imagePath = "Player2giusto.png";

        int var = 208;
        
        spriteXCoordinates[NORMAL] = new int[] {131, 175, 221}; //le coordinata delle prime tre immagini
        spriteYCoordinates[NORMAL] = new int[] {var, var, var};
        spriteXCoordinates[JUMP] = new int[] {252}; // le coordinata del salto
        spriteYCoordinates[JUMP] = new int[] {210};
        spriteXCoordinates[DOWN] = new int[] {307}; // la coordinata della discesa
        spriteYCoordinates[DOWN] = new int[] {var};
    }

    private void animate() {
        if (this.player.isJumping() && !this.player.isGoingDown() && this.currentDirection != JUMP) {
            this.changeDirection(JUMP);
        } else if (!this.player.isJumping() && this.currentDirection != NORMAL) {
            this.changeDirection(NORMAL);
        } else if (this.player.isGoingDown() && this.currentDirection != DOWN) {
            this.changeDirection(DOWN);
        } else {
            this.currentSpriteChange++;
                if (currentSpriteChange >= SPRITE_CHANGE) {
                        currentSprite = (byte) ((currentSprite + 1) 
                        % spriteXCoordinates[currentDirection].length);
                        currentSpriteChange = 0;
                }
        }

        spriteX = spriteXCoordinates[this.currentDirection][this.currentSprite];
        spriteY = spriteYCoordinates[this.currentDirection][this.currentSprite];
    }

    private void changeDirection(final int dir) {
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

    private ImageView createImage(final PlayerImpl pl) {
        final ImageView image = new ImageView(new Image(imagePath));
        image.setViewport(new Rectangle2D(spriteX, spriteY, 35, 45));;
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
