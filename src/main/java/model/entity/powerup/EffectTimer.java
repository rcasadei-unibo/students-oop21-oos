package model.entity.powerup;

import java.util.Timer;
import java.util.TimerTask;

public class EffectTimer {

    private final Timer time; 
    private static final long DELAY = 10_000L; 

    public EffectTimer() {
        time = new Timer(); 
    }

    public final void scheduleTask(final TimerTask powerupTask) {

        time.schedule(powerupTask, DELAY);

    }

}
