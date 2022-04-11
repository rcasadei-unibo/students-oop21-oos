package model.entity;

import java.util.List;

public interface DynamicEntityFactory {

    /**
     * Create a new {@link Obstacle}'s instance.
     * @param level the level on which obstacle spawn
     * @return a new {@link Obstacle} 's instance 
     */
    DynamicEntity createObsatcle(EntityLevel level);

    /**
     * Create a new {@link Platform}'s instance.
     * @param level the level on which platform spawn
     * @return a new {@link Platform} 's instance 
     */
    DynamicEntity createPlatform(EntityLevel level);

    /**
     * Create a new {@link Coin}'s instance.
     * @param level the level on which coin spawn
     * @return a new {@link Coin} 's instance 
     */
    DynamicEntity createCoin(EntityLevel level);

    /**
     * Create a list of {@link Coin}.
     * @param level the level on which coin spawn 
     * @return a {@link Coin} list. 
     */
    List<DynamicEntity> createCoinCollection(EntityLevel level);

    /**
     * Create a new Powerup.
     * @param level the level on which the powerup spawns.
     * @return a new Powerup instance.
     */
    DynamicEntity createPowerup(EntityLevel level); 

}
