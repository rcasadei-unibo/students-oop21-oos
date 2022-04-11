package model.entity;

public enum EntityType {

    /**
     * Obstacle's type.
     */
    OBSATCLE(5.0), 

    /**
     * Platform's type.
     */
    PLATFORM(0.0), 

    /**
     * Coin's type.
     */
    COIN(3.0), 

    /**
     * Powerup's type. 
     */
    POWERUP(5.0); 

    private final double distanceFactor;

    EntityType(final double distanceFactor) {
        this.distanceFactor = distanceFactor;
    }

    public double getDistanceFactor() {
        return this.distanceFactor;
    }

}
