package model.entity;

import java.util.List;

public interface EntityFactory {

    /**
     * Create a new {@link Obstacle}'s instance.
     * @param level the level on which obstacle spawn
     * @return a new {@link Obstacle} 's instance 
     */
    DynamicEntity createObstacle(SpawnLevel level);

    /**
     * Create a new {@link Platform}'s instance.
     * @param level the level on which platform spawn
     * @return a new {@link Platform} 's instance 
     */
    DynamicEntity createPlatform(SpawnLevel level);

    /**
     * Create a new {@link Coin}'s instance.
     * @param level the level on which coin spawn
     * @return a new {@link Coin} 's instance 
     */
    DynamicEntity createCoin(SpawnLevel level);

    //List<DynamicEntity> createCoinCollection(EntityLevel level);
    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn. 
     * @param obstacleLevel the level on which {@link Obstacle} should spawn.
     * @return a list containing {@link Platform} and {@link Obstacle} combined. 
     */
    List<DynamicEntity> combinePlatformObstacle(SpawnLevel platformLevel, SpawnLevel obstacleLevel);

    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn. 
     * @param coinLevel the level on which {@link Coin} should spawn.
     * @return a list containing {@link Platform} and {@link Coin} combined. 
     */
    List<DynamicEntity> combinePlatformCoin(SpawnLevel platformLevel, SpawnLevel coinLevel);

    /**
     * 
     * @param obstacleLevel the level on which {@link Obstacle} should spawn. 
     * @param coinLevel the level on which {@link Coin} should spawn.
     * @return a list containing {@link Obstacle} and {@link Coin} combined. 
     */
    List<DynamicEntity> combineObstacleCoin(SpawnLevel obstacleLevel, SpawnLevel coinLevel);

    /**
     * 
     * @param platformLevel the level on which {@link Platform} should spawn.
     * @param obstacleLevel the level on which {@link Obstacle} should spawn.
     * @param coinLevel the level on which {@link Coin} should spawn. 
     * @return a list containing {@link Platform}, {@link Obstacle} and {@link Coin} combined. 
     */
    List<DynamicEntity> combineAll(SpawnLevel platformLevel, SpawnLevel obstacleLevel, SpawnLevel coinLevel);

    /**
     * Create a new Powerup.
     * @param level the level on which the powerup spawns.
     * @return a new Powerup instance.
     */
    DynamicEntity createPowerup(SpawnLevel level); 

}
