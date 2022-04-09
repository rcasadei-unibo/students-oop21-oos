package model;

import javafx.geometry.Rectangle2D;

public final class PlayerImpl implements Player {
    /**
     * Width of the sprite.
     */
    public static final int MAIN_CHARACTER_WIDTH = 96;
    /**
     * Height of the sprite.
     */
    public static final int MAIN_CHARACTER_HEIGHT = 96;
    /**
     * Initial x of the sprite.
     */
    public static final int INITIAL_X = 40;
    /**
     * Initial y of the sprite.
     */
    public static final int INITIAL_Y = 350;
    /**
     * Jump height of the sprite.
     */
    public static final int JUMP_HEIGHT = 300;
    //coordinate nello schermo
    private int x;
    private int y;

    //se sta saltando, da quanto e se deve aspettare
    private boolean isJumping;
    private boolean isGoingDown;
    private boolean isOnPlatform;
    private int jumpHeight;
    private int landHeight;

    //numero di vite e scudo
    private int numLives;
    private boolean shieldActive;

    public PlayerImpl() {
        this.x = INITIAL_X;
        this.y = INITIAL_Y;
        this.isJumping = false;
        this.isGoingDown = false;
        this.isOnPlatform = false;
        this.jumpHeight = JUMP_HEIGHT;
        this.landHeight = INITIAL_Y;
        this.numLives = 1;
        this.shieldActive = false;
    }

    @Override
    public void jump() {
        this.isJumping = true;
    }

    @Override
    public void updateJump() {
        if (this.isJumping) {
            if (this.y == this.jumpHeight) {
                this.isGoingDown = true;
            }
            if (this.y > this.jumpHeight && !this.isGoingDown) {
                this.y--;
            } else if (this.y >= this.jumpHeight && this.isGoingDown) {
                this.y++;
            }
            if (this.y == this.landHeight) {
                this.isJumping = false;
                this.isGoingDown = false;
            }
        }
        if (!this.isOnPlatform) {
            this.landHeight = INITIAL_Y;
            this.jumpHeight = JUMP_HEIGHT;
            if (this.y < this.jumpHeight && this.y < this.landHeight) {
                this.y++;
            }
        }
    }

    @Override
    public int getLives() {
        return this.numLives;
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(this.x, this.y, MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
    }

    @Override
    public int getJumpHeight() {
        return this.jumpHeight;
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
    public void setJumpHeight(final int h) {
        this.jumpHeight = h;
    }

    @Override
    public void setLandHeight(final int h) {
        this.landHeight = h;
    }

    @Override
    public void setNumberOfLives(final int lives) {
        this.numLives = lives;
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
