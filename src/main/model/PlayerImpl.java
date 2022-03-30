package main.model;

public final class PlayerImpl implements Player {

    //decido quanto � lungo un salto, quanto deve passare tra un salto e l'altro
    public static final int JUMP_TIME = 30;
    public static final int WAIT_JUMP_TIME = 10;
    //posizione di default di partenza
    public static final int INITIAL_X = 380;
    public static final int INITIAL_Y = 375;
    //coordinate nello schermo
    private int x;
    private int y;

    //se sta saltando, da quanto e se deve aspettare
    private boolean isJumping = false;
    private int jumpTime = 0;
    private int waitTime;
    private int jumpHeight = 60;

    //numero di vite e scudo
    private int numLifes;
    private boolean shieldActive;

    public PlayerImpl() {
        this.x = INITIAL_X;
        this.y = INITIAL_Y;
        this.waitTime = WAIT_JUMP_TIME;
        this.numLifes = 0;
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
    public int getJumpHeight() {
        return this.jumpHeight;
    }

    @Override
    public int getLifes() {
        return this.numLifes;
    }

    @Override
    public boolean isShieldActive() {
        return shieldActive;
    }

    @Override
    public void setJumpHeight(final int h) {
        this.jumpHeight = h;
    }

    @Override
    public void setNumberOfLifes(final int lifes) {
        this.numLifes = lifes;
    }

    @Override
    public void setShield(final boolean active) {
        this.shieldActive = active;
    }

}
