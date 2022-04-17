package model;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.marker.MarkerManager;
import model.marker.MarkerManagerImpl;

public class StatisticsUpdater implements Runnable {

    private static final int TIME_RATE_IN_SECONDS = 1;
    private final ScheduledExecutorService executor;
    private final Statistics statistics;
    private final MarkerManager markerManager;

    public StatisticsUpdater(final Statistics statistics, final MarkerManager markerManager) {
        super();
        this.executor = Executors.newScheduledThreadPool(1);
        this.executor.scheduleAtFixedRate(this, 0, TIME_RATE_IN_SECONDS, TimeUnit.SECONDS);
        this.statistics = statistics;
        this.markerManager = markerManager;
    }

    @Override
    public void run() {
        this.statistics.update();
        //System.out.println("Distance: " + this.statistics.getDistance());
        this.markerManager.check(this.statistics.getDistance());
    }

    public void start() {
        this.run();
    }

    public void stop() {
        this.executor.shutdown();
        try {
            this.statistics.saveStatisticsOnFile();
        } catch (IOException e) {
            System.out.println("Statistics unsaved");
        }
        //ripulire optional dei marker
    }

}
