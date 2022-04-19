package model.mission;

import java.util.Optional;

public interface MissionManager {

    Optional<Mission> getMission();

    void update();

    boolean isCompleted();

    int getReward();

}
