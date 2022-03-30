package main.model;

public class PlayerImpl implements Player {
    
    //decido quanto � lungo un passo
    public static final int STEP = 60;
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
    
    //numero di vite
    private int numLifes;

    public PlayerImpl() {
        this.x = INITIAL_X;
        this.y = INITIAL_Y;
        this.waitTime = WAIT_JUMP_TIME;
        this.numLifes = 0;
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
                newY -= STEP;
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
    public int getLifes() {
        return this.numLifes;
    }

}
