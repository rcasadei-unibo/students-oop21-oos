package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * An implementation of {@link Statistics}.
 *
 */
public class StatisticsImpl implements Statistics {

    private static final String SEP = File.separator;
    private static final String FILE_NAME = System.getProperty("user.home") + SEP + "OOS_statistics.txt";
    private static final double DIFFICULTY_FACTOR = 1.010;

    private double difficulty;
    private int gameCoins;
    private int totalCoins;
    private int actualDistance;
    private int lastDeathDistance;
    private int recordDistance;

    /**
     * Creates a new StatisticsImpl initially with statistics read from file.
     * 
     */
    public StatisticsImpl() {
        super();
        this.difficulty = 2;
        this.actualDistance = 0;
        this.gameCoins = 0;

        final List<Integer> list = this.readStatisticsFromFile().stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        this.recordDistance = list.get(0);
        this.lastDeathDistance = list.get(1);
        this.totalCoins = list.get(2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.increaseDifficulty();
        this.increaseDistance();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseCoin(final int value) {
        this.gameCoins += value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDifficulty() {
        return this.difficulty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDistance() {
        return this.actualDistance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLastDeathDistance() {
        return this.lastDeathDistance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRecordDistance() {
        return this.recordDistance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getGameCoins() {
        return this.gameCoins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTotalCoins() {
        return this.totalCoins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTotalCoins(final int value) {
        this.totalCoins = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveStatisticsOnFile() throws IOException {
        if (this.actualDistance > this.recordDistance) {
            this.recordDistance = this.actualDistance;
        }
        this.lastDeathDistance = this.actualDistance;
        this.totalCoins += this.gameCoins;

        final List<Integer> list = List.of(this.recordDistance, this.lastDeathDistance, this.totalCoins);
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            list.stream().map(e -> Integer.toString(e)).forEach(s -> {
                try {
                    bw.write(s);
                    bw.newLine();
                } catch (IOException e) {
                    System.out.println("Error in saveStatisticsOnFile");
                }
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> readStatisticsFromFile() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_NAME))) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            return List.of("0", "0", "0");
        }
    }

    /**
     * Increases the difficulty.
     * 
     */
    private void increaseDifficulty() {
        this.difficulty = this.difficulty * DIFFICULTY_FACTOR;
    }

    /**
     * Increases the distance.
     * 
     */
    private void increaseDistance() {
        this.actualDistance += this.difficulty;
    }

}
