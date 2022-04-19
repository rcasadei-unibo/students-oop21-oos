package controller;

import input.InputObserver;
import model.Model;
import model.ModelImpl;
import sound.Sound;
import sound.SoundFactoryImpl;
import view.View;

public class ControllerImpl implements Controller {

    private Model model;
    private final View view;
    private final AnimationTimerImpl timer;
    private final InputObserver obs;
    private final SoundFactoryImpl soundFactory;
    private final Sound soundtrack;

    public ControllerImpl(final View view, final InputObserver obs) {
        super();
        this.view = view;
        this.obs = obs;
        this.timer = new AnimationTimerImpl(this);
        this.soundFactory = new SoundFactoryImpl();
        this.soundtrack = this.soundFactory.createGameSoundtrack();
    }

    @Override
    public void setup() {
        this.model = new ModelImpl(this.soundFactory);
        this.view.game();
    }

    @Override
    public void processInput() {
        this.obs.getCommands().forEach(cmd -> {
            cmd.execute();
        });
        this.obs.clear();
    }

    @Override
    public void update() {
        if (!this.model.getGameState().isGameOver()) {
            if (!this.soundtrack.isPlaying()) {
                this.soundtrack.play();
            }
            this.model.update();
        } else {
            this.stop();
        }
    }

    @Override
    public void render() {
        if (!this.model.getGameState().isGameOver()) {
            this.view.render();
        }
    }

    @Override
    public void start() {
        this.soundtrack.play();
        this.setup();
        this.timer.start();
        this.model.getStatisticsUpdater().start();
    }

    @Override
    public void stop() {
        this.soundtrack.stop();
        this.soundFactory.createGameOverSound().play();
        this.timer.stop();
        this.model.getStatisticsUpdater().stop();
        this.view.gameOver();
    }

    @Override
    public Model getModel() {
        return this.model;
    }

}
