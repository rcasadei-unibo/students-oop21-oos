package model;

public interface Statistics {

    void update();

    void increaseCoin(int value);

    double getDifficulty();

    double getDistance();

    int getLastDeathDistance();

    int getRecordDistance();

    int getGameCoins();

    int getTotalCoins();

    void saveStatisticsOnFile();

    void readStatisticsFromFile();

}
