package sound;

import javafx.scene.media.AudioClip;

/**
 * 
 * A normal sound.
 * An Implementation of {@link Sound} interface.
 *
 */
public class SoundImpl implements Sound {

    private final AudioClip audioClip;

    /**
     * Creates a new SoundImpl.
     * @param audioClip the {@link AudioClip} to play.
     */
    public SoundImpl(final AudioClip audioClip) {
        super();
        this.audioClip = audioClip;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void play() {
        this.audioClip.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        this.audioClip.stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPlaying() {
        return this.audioClip.isPlaying();
    }

}
