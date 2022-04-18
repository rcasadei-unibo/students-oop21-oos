package controller;

import javafx.animation.AnimationTimer;

/**
 * 
 * Class operating as a game loop.
 * Extends {@link AnimationTimer}.
 *
 */
public class AnimationTimerImpl extends AnimationTimer {

    private final Controller controller;

    /**
     * Creates a new AnimationTimerImpl.
     * @param controller the application controller.
     */
    public AnimationTimerImpl(final Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(final long time) {
        this.controller.processInput();
        this.controller.update();
        this.controller.render();
    }

}
