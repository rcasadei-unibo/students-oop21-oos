package model;

import javafx.geometry.Rectangle2D;

public interface Player {

    /**
     * Move the player to the point (x,y).
     * @param x final X coordinate
     * @param y final Y coordinate
     */
    void moveTo(int x, int y);

    /**
     * Makes the jump start.
     */
    void jump();

    /**
     * Update the coordinate of the player during the jump.
     */
    void updateJump();

    /**
     * @return the X coordinate of the player
     */
    int getX();

    /**
     * @return the Y coordinate of the player
     */
    int getY();

    /**
     * @return the number of lifes of the player
     */
    int getLives();

    /**
     * @return the bounds of the Player
     */
    Rectangle2D getBounds();

    /**
     * @return true if the shield is active
     */
    boolean isShieldActive();

    /**
     * @return true if the player is jumping
     */
    boolean isJumping();

    /**
     * Sets the height of the jumps.
     * @param h the new height of the jump
     */
    void setJumpHeight(int h);

    /**
     * Sets the height of the land.
     * @param h the new height of the land
     */
    void setLandHeight(int h);

    /**
     * Sets the number of lifes of the player.
     * @param lifes the new number of lifes
     */
    void setNumberOfLives(int lifes);

    /**
     * Sets the shield.
     * @param active true if the shield is active
     */
    void setShield(boolean active);

}
