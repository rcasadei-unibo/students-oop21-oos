package model.mission;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

import model.Statistics;

public class MissionFactoryImpl implements MissionFactory {

    private static final int REWARD_AMOUNT = 20;
    private static final int MAX_DISTANCE_MISSION = 1000;
    private static final int MAX_COINS_TO_COLLECT_MISSION = 50;
    private final Statistics statistics;
    private final Random random;

    public MissionFactoryImpl(final Statistics statistics) {
        super();
        this.statistics = statistics;
        this.random = new Random();
    }

    @Override
    public Mission createMission() {
        final List<Mission> missions = List.of(this.createCollectedCoinMission(), this.createDistanceMission());
        return missions.stream().skip(random.nextInt(missions.size())).findFirst().get();
    }

    @Override
    public Mission createCollectedCoinMission() {
        final int goal = this.getGoal(MAX_COINS_TO_COLLECT_MISSION);
        return this.createGeneralised(x -> x >= goal, () -> this.statistics.getGameCoins(), "Collect " + goal + " coins: ");
    }

    @Override
    public Mission createDistanceMission() {
        final int goal = this.getGoal(MAX_DISTANCE_MISSION);
        return this.createGeneralised(x -> x >= goal, () -> this.statistics.getDistance(), "Reach distance " + goal + ": ");
    }

    private Mission createGeneralised(final Predicate<Integer> goal, final Supplier<Integer> supplier, final String quest) {
        return new Mission() {

            private final Predicate<Integer> predicate = goal;
            private int counter;

            @Override
            public boolean isCompleted() {
                return this.predicate.test(this.counter);
            }

            @Override
            public void updateCounter() {
                this.counter = supplier.get();
            }

            @Override
            public int getCounter() {
                return this.counter;
            }

            @Override
            public int getReward() {
                return REWARD_AMOUNT;
            }

            @Override
            public String toString() {
                return quest + (this.isCompleted() ? " COMPLETED" : " Not completed yet");
            }

        };
    }

    private int getGoal(final int limit) {
        final int goal = random.nextInt(limit);
        return goal - goal % 10;
    }

}
