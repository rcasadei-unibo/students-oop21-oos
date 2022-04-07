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

    //decido quanto � lungo un salto, quanto deve passare tra un salto e l'altro
    public static final int JUMP_TIME = 30;
    public static final int WAIT_JUMP_TIME = 10;
    //posizione di default di partenza
    public static final int INITIAL_X = 380;
    public static final int INITIAL_Y = 375;
    public static final int JUMP_HEIGHT = 110;
    //coordinate nello schermo
    private int x;
    private int y;

    //se sta saltando, da quanto e se deve aspettare
    private boolean isJumping = false;
    private boolean isGoingDown = false;
    private boolean isOnPlatform = false;
    private int jumpHeight;
    private int landHeight;

    //numero di vite e scudo
    private int numLives;
    private boolean shieldActive;

    public PlayerImpl() {
        this.x = INITIAL_X;
        this.y = INITIAL_Y;
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
            if (this.y < this.jumpHeight && !this.isGoingDown) {
                this.y--;
            } else if (this.y <= this.jumpHeight && this.isGoingDown) {
                this.y++;
            }
            if (this.y == this.landHeight) {
                this.isJumping = false;
                this.isGoingDown = false;
            }
        }
        if (!this.isOnPlatform) {
            this.landHeight = INITIAL_Y;
        }
    }

    @Override
    public int getX() { 
            return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getLives() {
        return this.numLives;
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(this.getX(), this.getY(), MAIN_CHARACTER_WIDTH, MAIN_CHARACTER_HEIGHT);
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
