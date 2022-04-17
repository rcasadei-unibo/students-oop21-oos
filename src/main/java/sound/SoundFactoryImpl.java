package sound;

import javafx.scene.media.AudioClip;

public class SoundFactoryImpl implements SoundFactory {

    @Override
    public Sound createGameSoundtrack() {
        return this.createSound(SoundType.GAME_SOUNDTRACK);
    }

    @Override
    public Sound createJumpSound() {
        return this.createSound(SoundType.JUMP);
    }

    @Override
    public Sound createCoinCollisionSound() {
        return this.createSound(SoundType.COIN);
    }

    @Override
    public Sound createGameOverSound() {
        return this.createSound(SoundType.GAME_OVER);
    }

    private Sound createSound(final SoundType soundType) {
        final AudioClip audioClip = new AudioClip(this.getClass().getResource(soundType.toString()).toExternalForm());
        return new SoundImpl(audioClip);
    }

}
