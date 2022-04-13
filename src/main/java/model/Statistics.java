package model;

import java.io.IOException;
import java.util.List;

public interface Statistics {

    void update();

    void increaseCoin(int value);

    double getDifficulty();

    double getDistance();

    int getLastDeathDistance();

    int getRecordDistance();

    int getGameCoins();

    int getTotalCoins();

    void setTotalCoins(int value);

    void saveStatisticsOnFile() throws IOException;

    List<String> readStatisticsFromFile();


}
