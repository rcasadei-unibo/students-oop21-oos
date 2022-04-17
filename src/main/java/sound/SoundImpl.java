package sound;

import javafx.scene.media.AudioClip;

public class SoundImpl implements Sound {

    private final AudioClip audioClip;

    public SoundImpl(final AudioClip audioClip) {
        super();
        this.audioClip = audioClip;
    }

    @Override
    public void play() {
        this.audioClip.play();
    }

    @Override
    public void stop() {
        this.audioClip.stop();
    }

    @Override
    public boolean isPlaying() {
        return this.audioClip.isPlaying();
    }

}
