package main.model;

public interface Player {

    /**
     * Move the player to the point (x,y).
     * @param x final X coordinate
     * @param y final Y coordinate
     */
    void moveTo(int x, int y);

    /**
     * Jump.
     */
    void jump();

    /**
     * @return the X coordinate of the player
     */
    int getX();

    /**
     * @return the Y coordinate of the player
     */
    int getY();
    
    /**
     * @return the high of the jumps of the player
     */
    int getJumpHigh();

    /**
     * @return the number of lifes of the player
     */
    int getLifes();

}
