package model;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.marker.MarkerManager;

/**
 * 
 * Updater of {@link Statistics} every given seconds.
 * Implements {@link Runnable}.
 *
 */
public class StatisticsUpdater implements Runnable {

    private static final int TIME_RATE_IN_SECONDS = 1;
    private final ScheduledExecutorService executor;
    private final Statistics statistics;
    private final MarkerManager markerManager;

    /**
     * Creates a new StatisticsUpdater with given {@link Statistics} and {@link MarkerManager}.
     * @param statistics the {@link Statistics} to update.
     * @param markerManager the {@link MarkerManager}.
     */
    public StatisticsUpdater(final Statistics statistics, final MarkerManager markerManager) {
        super();
        this.executor = Executors.newScheduledThreadPool(1);
        this.executor.scheduleAtFixedRate(this, 0, TIME_RATE_IN_SECONDS, TimeUnit.SECONDS);
        this.statistics = statistics;
        this.markerManager = markerManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        this.statistics.update();
        //System.out.println("Distance: " + this.statistics.getDistance());
        this.markerManager.check(this.statistics.getDistance());
    }

    /**
     * Starts execution of run method every given time rate.
     *
     */
    public void start() {
        this.run();
    }

    /**
     * Stops run execution.
     * 
     */
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
