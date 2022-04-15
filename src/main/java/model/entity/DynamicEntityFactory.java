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

    //List<DynamicEntity> createCoinCollection(EntityLevel level);
    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn. 
     * @param obstacleLevel the level on which {@link Obstacle} should spawn.
     * @return a list containing {@link Platform} and {@link Obstacle} combined. 
     */
    List<DynamicEntity> combinePlatformObstacle(EntityLevel platformLevel, EntityLevel obstacleLevel);

    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn. 
     * @param coinLevel the level on which {@link Coin} should spawn.
     * @return a list containing {@link Platform} and {@link Coin} combined. 
     */
    List<DynamicEntity> combinePlatformCoin(EntityLevel platformLevel, EntityLevel coinLevel);

    /**
     * 
     * @param obstacleLevel the level on which {@link Obstacle} should spawn. 
     * @param coinLevel the level on which {@link Coin} should spawn.
     * @return a list containing {@link Obstacle} and {@link Coin} combined. 
     */
    List<DynamicEntity> combineObstacleCoin(EntityLevel obstacleLevel, EntityLevel coinLevel);

    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn.
     * @param obstacleLevel the level on which {@link Obstacle} should spawn.
     * @param coinLevel the level on which {@link Coin} should spawn. 
     * @return a list containing {@link Platform}, {@link Obstacle} and {@link Coin} combined. 
     */
    List<DynamicEntity> combineAll(EntityLevel platformLevel, EntityLevel obstacleLevel, EntityLevel coinLevel);

    /**
     * Create a new Powerup.
     * @param level the level on which the powerup spawns.
     * @return a new Powerup instance.
     */
    DynamicEntity createPowerup(EntityLevel level); 

}
