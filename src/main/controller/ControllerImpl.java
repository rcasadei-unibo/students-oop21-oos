package main.controller;

import main.model.Model;
import main.view.View;

public class ControllerImpl implements Controller {

    private Model model;
    private final View view;
    private final AnimationTimerImpl timer;

    public ControllerImpl(final View view) {
        super();
        this.view = view;
        this.timer = new AnimationTimerImpl(this);
    }

    @Override
    public void setup() {
        //this.model = new Model();
        //this.view.game();

    }

    @Override
    public void processInput() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        if (!this.model.getGameState().isGameOver()) {
            this.model.update();
        } else {
            this.stop();
        }
    }

    @Override
    public void render() {
        //this.view.render();
    }

    @Override
    public void start() {
        this.setup();
        this.timer.start();
    }

    @Override
    public void stop() {
        this.timer.stop();
        this.view.gameOver();
    }

}
