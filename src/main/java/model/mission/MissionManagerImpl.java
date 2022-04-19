package model.mission;

import java.util.Optional;

import model.Statistics;

public class MissionManagerImpl implements MissionManager {

    private final Optional<Mission> mission;

    public MissionManagerImpl(final Statistics statistics) {
        super();
        final MissionFactoryImpl missionFactory = new MissionFactoryImpl(statistics);
        this.mission = Optional.of(missionFactory.createMission());
    }

    @Override
    public Optional<Mission> getMission() {
        if (this.mission.isEmpty()) {
            return Optional.empty();
        }
        return this.mission;
    }

    @Override
    public void update() {
        this.mission.get().updateCounter();
    }

    @Override
    public boolean isCompleted() {
        if (this.mission.isEmpty()) {
            return false;
        }
        return this.mission.get().isCompleted();
    }

    @Override
    public int getReward() {
        return this.mission.get().getReward();
    }

}
