package model.mission;

public interface Mission {

    boolean isCompleted();

    void updateCounter();

    int getCounter();

    int getReward();

}
