package controller;

import javafx.animation.AnimationTimer;

public class AnimationTimerImpl extends AnimationTimer {

    private final Controller controller;

    public AnimationTimerImpl(final Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(final long time) {
        this.controller.processInput();
        this.controller.update();
        this.controller.render();
    }

}
