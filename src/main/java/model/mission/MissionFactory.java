package model.mission;

public interface MissionFactory {

    Mission createMission();

    Mission createCollectedCoinMission();

    Mission createDistanceMission();

}
