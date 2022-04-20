package model;

import javafx.geometry.Rectangle2D;
import sound.Sound;
import sound.SoundFactory;

public final class PlayerImpl implements Player {
    /**
     * Width of the sprite.
     */
    public static final int MAIN_CHARACTER_WIDTH = 70;
    /**
     * Height of the sprite.
     */
    public static final int MAIN_CHARACTER_HEIGHT = 96;
    /**
     * Y coordinate of the land.
     */
    public static final double LAND = 440.0f;
    /**
     * X coordinate of the player.
     */
    public static final double PLAYER_X = 40.0f;
    /**
     * How much does the player jump.
     */
    public static final double JUMP_HEIGHT = 160.0f;
    /*The speed of the jump*/
    private static final double GRAVITY = 4.5f;

    private double y = LAND - MAIN_CHARACTER_HEIGHT;
    private boolean isJumping;
    private boolean isGoingDown;
    private boolean isDoubleJumpActive;
    private double jumpHeight = JUMP_HEIGHT;
    private double landHeight = LAND;
    private int numLives = 1;
    private boolean shieldActive;
    private int jumpCounter;
    private final Sound jumpSound;
    private double finalJumpY;

    public PlayerImpl(final SoundFactory soundFactory) {
        this.jumpSound = soundFactory.createJumpSound();
    }

    @Override
    public void jump() {
        if (!this.isJumping) {
            this.isJumping = true;
            this.jumpHeight = JUMP_HEIGHT;
            this.jumpCounter++;
            this.jumpSound.play();
            if (this.isDoubleJumpActive) {
                this.jumpHeight = this.jumpHeight * 2;
            }
            this.finalJumpY = Math.max(this.y - jumpHeight, 0);
        }
    }

    @Override
    public void updateJump() {
        if (this.isJumping) {
            if (this.y <= finalJumpY) {
                this.isGoingDown = true;
            }
            if (!this.isGoingDown) {
                this.y = this.y - GRAVITY;
            } else {
                this.y = this.y + GRAVITY;
            }
            if (this.y >= this.landHeight - MAIN_CHARACTER_HEIGHT) {
                this.isJumping = false;
                this.isGoingDown = false;
                this.y = landHeight - MAIN_CHARACTER_HEIGHT;
            }
        }

        if (!this.isJumping && this.y < this.landHeight - MAIN_CHARACTER_HEIGHT) {
            this.isJumping = true;
            this.isGoingDown = true;
        }
    }

    @Override
    public int getLives() {
        return this.numLives;
    }

    @Override
    public int getJumpCounter() {
        return this.jumpCounter;
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(PLAYER_X, this.y, MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
    }

    @Override
    public boolean isShieldActive() {
        return shieldActive;
    }

    @Override
    public boolean isJumping() {
        return this.isJumping;
    }

    @Override
    public boolean isGoingDown() {
        return this.isGoingDown;
    }

    @Override
    public void setDoubleJump(final boolean set) {
        this.isDoubleJumpActive = set;
    }

    @Override
    public void setLandHeight(final double h) {
        this.landHeight = h;
    }

    @Override
    public void setNumberOfLives(final int lives) {
        this.numLives += lives;
    }

    @Override
    public void setShield(final boolean active) {
        this.shieldActive = active;
    }

}
