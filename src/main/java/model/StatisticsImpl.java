package model;

public class StatisticsImpl implements Statistics {

    private static final double DIFFICULTY_FACTOR = 1.010;
    private double difficulty;
    private int gameCoins;
    private int totalCoins;
    private int actualDistance;
    private int lastDeathDistance;
    private int recordDistance;

    public StatisticsImpl() {
        super();
        this.difficulty = 2;
        this.actualDistance = 0;
        this.gameCoins = 0;
        //this.readStatisticsFromFile();
    }

    @Override
    public void update() {
        this.increaseDifficulty();
        this.increaseDistance();
    }

    @Override
    public void increaseCoin(final int value) {
        this.gameCoins += value;
    }

    private void increaseDifficulty() {
        this.difficulty = this.difficulty * DIFFICULTY_FACTOR;
    }

    private void increaseDistance() {
        this.actualDistance += this.difficulty;
    }

    @Override
    public double getDifficulty() {
        return this.difficulty;
    }

    @Override
    public double getDistance() {
        return this.actualDistance;
    }

    @Override
    public int getLastDeathDistance() {
        return this.lastDeathDistance;
    }

    @Override
    public int getRecordDistance() {
        return this.recordDistance;
    }

    @Override
    public int getGameCoins() {
        return this.gameCoins;
    }

    @Override
    public int getTotalCoins() {
        return this.totalCoins;
    }

    @Override
    public void saveStatisticsOnFile() {
        // TODO Auto-generated method stub

    }

    @Override
    public void readStatisticsFromFile() {
        // TODO Auto-generated method stub

    }

}
