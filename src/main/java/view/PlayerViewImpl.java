package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Player;
import model.PlayerImpl;

public final class PlayerViewImpl implements PlayerView {

    private final Pane pane; 

    private static final int TOTAL_MOVEMENTS = 3;
    private static final int NORMAL = 0;
    private static final int JUMP = 1;
    private static final int DOWN = 2;
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
    private int currentDirection;
    private byte currentSprite;
    private byte currentSpriteChange;

    private final int[][] spriteXCoordinates = new int[TOTAL_MOVEMENTS][];
    private final int[][] spriteYCoordinates = new int[TOTAL_MOVEMENTS][];

    //il player
    private final Player player;
    private ImageView lastSpriteImage;

    public PlayerViewImpl(final Pane pane, final Player pl) {
        this.pane = pane;
        this.player = pl;
        this.currentDirection = NORMAL;
        this.currentSprite = 0;
        this.currentSpriteChange = 0;
        this.imagePath = "Player2giusto.png";

        spriteXCoordinates[NORMAL] = new int[] {IMAGE1, IMAGE2, IMAGE3}; //le coordinata delle prime tre immagini
        spriteYCoordinates[NORMAL] = new int[] {HEIGHT, HEIGHT, HEIGHT};
        spriteXCoordinates[JUMP] = new int[] {IMAGE4}; // le coordinata del salto
        spriteYCoordinates[JUMP] = new int[] {210};
        spriteXCoordinates[DOWN] = new int[] {IMAGE5}; // la coordinata della discesa
        spriteYCoordinates[DOWN] = new int[] {HEIGHT};
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
