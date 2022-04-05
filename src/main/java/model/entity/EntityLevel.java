package model.entity;

public enum EntityLevel {
    /**
     * Level in which obstacles spawn.
     */
    LEVEL_ZERO(1.0, 1.0), 

    /**
     * Level in which platform of the second level, coin or PowerUps spawn.
     */
    LEVEL_ONE(1.0, 0.75),

    /**
     * Level in which platform of the second level.
     */
    LEVEL_TWO(1.0, 0.5);

    private final double spawnX;
    private final double spawnY;

    EntityLevel(final double spawnX, final double spawnY) {
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    public double getSpawnX() {
        return spawnX;
    }

    public double getSpawnY() {
        return spawnY;
    }

}
