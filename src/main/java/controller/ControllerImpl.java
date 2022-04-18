package controller;

import input.InputObserver;
import model.Model;
import model.ModelImpl;
import view.View;

/**
 * 
 * Implementation of {@link Controller}.
 *
 */
public class ControllerImpl implements Controller {

    private Model model;
    private final View view;
    private final AnimationTimerImpl timer;
    private final InputObserver obs;

    /**
     * Creates a new ControllerImpl and initializes a new AnimationTimerImpl.
     * @param view the {@link View} where the application starts.
     * @param obs the {@link InputObserver}.
     */
    public ControllerImpl(final View view, final InputObserver obs) {
        super();
        this.view = view;
        this.obs = obs;
        this.timer = new AnimationTimerImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        this.model = new ModelImpl();
        this.view.game();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        this.obs.getCommands().forEach(cmd -> {
            cmd.execute();
        });
        this.obs.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        if (!this.model.getGameState().isGameOver()) {
            this.model.update();
        } else {
            this.stop();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        if (!this.model.getGameState().isGameOver()) {
            this.view.render();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        this.setup();
        this.timer.start();
        this.model.getStatisticsUpdater().start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        this.timer.stop();
        this.model.getStatisticsUpdater().stop();
        this.view.gameOver();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Model getModel() {
        return this.model;
    }

}
