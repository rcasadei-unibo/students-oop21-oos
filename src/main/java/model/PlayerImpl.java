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
    public static final double INITIAL_X = 40.0f;
    /**
     * How much does the player jump.
     */
    public static final double JUMP_HEIGHT = 160.0f;

    private static final double JUMP_HEIGHT_ON_UPPER_PLATFORM = 80.0f;
    private static final double GRAVITY = 4.5f;

    //coordinate nello schermo
    private final double x;
    private double y;

    //se sta saltando, da quanto e se deve aspettare
    private boolean isJumping;
    private boolean isGoingDown;
    private boolean isOnPlatform;
    private boolean isDoubleJumpActive;
    private double jumpHeight;
    private double landHeight;
    private double initialY;
    private int jumpCounter;
    private Sound jumpSound;

    //numero di vite e scudo
    private int numLives;
    private boolean shieldActive;

    public PlayerImpl(final SoundFactory soundFactory) {
        this.x = INITIAL_X;
        this.y = LAND - MAIN_CHARACTER_HEIGHT;
        this.isJumping = false;
        this.isGoingDown = false;
        this.isOnPlatform = false;
        this.isDoubleJumpActive = false;
        this.jumpHeight = JUMP_HEIGHT;
        this.landHeight = LAND;
        this.numLives = 1;
        this.shieldActive = false;
        this.initialY = this.y;
        this.jumpCounter = 0;
        this.jumpSound = soundFactory.createJumpSound();
    }

    @Override
    public void jump() {
        if (!this.isJumping) {
            this.isJumping = true;
            this.initialY = this.y;
            this.jumpHeight = JUMP_HEIGHT;
            this.jumpCounter++;
            this.jumpSound.play();
            if (this.isDoubleJumpActive) {
                this.jumpHeight = this.jumpHeight * 2;
                if (initialY - jumpHeight / 2 <= 0) {
                    this.jumpHeight = JUMP_HEIGHT_ON_UPPER_PLATFORM;
                }
            }
            if (initialY - jumpHeight <= 0) {
                this.jumpHeight = JUMP_HEIGHT_ON_UPPER_PLATFORM;
            }
        }
    }

    @Override
    public void updateJump() {
        if (this.isJumping) {
            if (this.y <= initialY - jumpHeight) {
                this.isGoingDown = true;
            }
            if (this.y > this.jumpHeight - this.initialY && !this.isGoingDown) {
                this.y = this.y - GRAVITY;
            } else if (this.y >= this.jumpHeight - this.landHeight && this.isGoingDown) {
                this.y = this.y + GRAVITY;
            }
            if (this.y >= this.landHeight - MAIN_CHARACTER_HEIGHT) {
                this.isJumping = false;
                this.isGoingDown = false;
                this.y = landHeight - MAIN_CHARACTER_HEIGHT;
            }
        }
        if (!this.isOnPlatform) {
            this.landHeight = LAND;

        }
        if (!this.isJumping && this.y < this.landHeight - MAIN_CHARACTER_HEIGHT) {
            this.isJumping = true;
            this.isGoingDown = true;
            this.y = this.y + GRAVITY;
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
        return new Rectangle2D(this.x, this.y, MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
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

    @Override
    public void setOnPlatform(final boolean on) {
        this.isOnPlatform = on;
    }

}
