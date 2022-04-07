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
    public static final int JUMP_HEIGHT = 60;
    //coordinate nello schermo
    private int x;
    private int y;

    //se sta saltando, da quanto e se deve aspettare
    private boolean isJumping = false;
    private int jumpTime = 0;
    private int waitTime;
    private int jumpHeight;

    //numero di vite e scudo
    private int numLives;
    private boolean shieldActive;

    public PlayerImpl() {
        this.x = INITIAL_X;
        this.y = INITIAL_Y;
        this.waitTime = WAIT_JUMP_TIME;
        this.jumpHeight = JUMP_HEIGHT;
        this.numLives = 1;
        this.shieldActive = false;
    }

    @Override
    public void moveTo(final int x, final int y) {
            this.x = x;
            this.y = y;
    }

    @Override
    public void jump() {
        if (!isJumping) {
            if (waitTime < WAIT_JUMP_TIME) {
                waitTime++;
            } else if (y == INITIAL_Y) {
                isJumping = true;
                jumpTime++;
                int newY = y;
                newY -= jumpHeight;
                moveTo(x, newY);
            }
        } else {
            jumpTime++;
            if (jumpTime >= JUMP_TIME) {
                    y = INITIAL_Y;
                    isJumping = false;
                    jumpTime = 0;
                    waitTime = 0;
            }
            //animate(movement);
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
    public void setNumberOfLives(final int lives) {
        this.numLives = lives;
    }

    @Override
    public void setShield(final boolean active) {
        this.shieldActive = active;
    }

}
