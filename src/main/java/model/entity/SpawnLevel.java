package model.entity;


/**
 * 
 * Enumeration identifying the level on which entities could spawn.
 *
 */
public enum SpawnLevel {
    /**
     * Land level.
     */
    ZERO(1.0, 1.0), 

    /**
     * First level.
     */
    ONE(1.0, 0.75),

    /**
     * Second level.
     */
    TWO(1.0, 0.5);

    private final double spawnX;
    private final double spawnY;

    /**
     * 
     * @param spawnX the X coordinate of the level.
     * @param spawnY the Y coordinate of the level.
     */
    SpawnLevel(final double spawnX, final double spawnY) {
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    /**
     * 
     * @return the X coordinate of the level.
     */
    public double getSpawnX() {
        return spawnX;
    }

    /**
     * 
     * @return the Y coordinate of the level.
     */
    public double getSpawnY() {
        return spawnY;
    }

}
