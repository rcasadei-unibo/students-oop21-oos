package model.entity;

public interface DynamicEntityFactory {

    /**
     * Create a new {@link Obstacle}'s instance.
     * @param level the level on which obstacle spawn
     * @param speedX the speed of the obstacle
     * @return a new {@link Obstacle} 's instance 
     */
    DynamicEntity createObsatcle(EntityLevel level, double speedX);

    /**
     * Create a new {@link Platform}'s instance.
     * @param level the level on which platform spawn
     * @param speedX the speed of the platform
     * @return a new {@link Platform} 's instance 
     */
    DynamicEntity createPlatform(EntityLevel level, double speedX);

    /**
     * Create a new {@link Coin}'s instance.
     * @param level the level on which coin spawn
     * @param speedX the speed of the coin
     * @return a new {@link Coin} 's instance 
     */
    DynamicEntity createCoin(EntityLevel level, double speedX);

    /**
     * Create a new Powerup.
     * @param level the level on which the powerup spawns.
     * @param speedX the speed of the powerup. 
     * @return a new Powerup instance.
     */
    DynamicEntity createPowerup(EntityLevel level, double speedX); 

}
