package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;

public final class PlayerViewImpl implements PlayerView {

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
    public static final byte SPRITE_CHANGE = 5;

    //coordinate dello sprite nel png per scegliere l'orso che mi serve
    private int spriteX;
    private int spriteY;
    private int currentDirection;
    private byte currentSprite;
    private byte currentSpriteChange;

    private int[][] spriteXCoordinates = new int[TOTAL_MOVEMENTS][];
    private int[][] spriteYCoordinates = new int[TOTAL_MOVEMENTS][];

    //il player
    private Player player;
    private ImageView lastSpriteImage;

    public PlayerViewImpl(final Pane pane, final Player pl) {
        this.pane = pane;
        this.player = pl;
        this.currentDirection = NORMAL;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;

        spriteXCoordinates[NORMAL] = new int[] {480, 560, 650}; //le coordinata delle prime tre immagini
        spriteYCoordinates[NORMAL] = new int[] {0, 0, 0, 0};
        spriteXCoordinates[JUMP] = new int[] {1248}; // le coordinata del salto
        spriteYCoordinates[JUMP] = new int[] {0};
        spriteXCoordinates[DOWN] = new int[] {1248}; // la coordinata della discesa
        spriteYCoordinates[DOWN] = new int[] {0};
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
                        currentSprite = (byte) ((currentSprite++) 
                        % spriteXCoordinates[currentDirection].length);
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
