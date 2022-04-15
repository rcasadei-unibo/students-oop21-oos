package model.entity;

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

    SpawnLevel(final double spawnX, final double spawnY) {
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
