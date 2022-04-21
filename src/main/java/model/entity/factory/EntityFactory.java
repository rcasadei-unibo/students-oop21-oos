package model.entity.factory;

import java.util.List;
import model.entity.DynamicEntity;
import model.entity.SpawnLevel;

/**
 * 
 * Factory Method for {@link DynamicEntity}.
 *
 */
public interface EntityFactory {

    /**
     * Create a new {@link Obstacle}'s instance.
     * @param level the level on which {@link Obstacle} spawn.
     * @return a new {@link Obstacle} 's instance.
     */
    DynamicEntity createObstacle(SpawnLevel level);

    /**
     * Create a new {@link Platform}'s instance.
     * @param level the level on which {@link Platform} spawn.
     * @return a new {@link Platform} 's instance.
     */
    DynamicEntity createPlatform(SpawnLevel level);

    /**
     * Create a new {@link Coin}'s instance.
     * @param level the level on which {@link Coin} spawn.
     * @return a new {@link Coin} 's instance. 
     */
    DynamicEntity createCoin(SpawnLevel level);

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
     * Create a new PowerUp.
     * @param level the level on which the PowerUp should spawns.
     * @return a new PowerUp's instance.
     */
    DynamicEntity createPowerup(SpawnLevel level); 

}
