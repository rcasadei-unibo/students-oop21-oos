package sound;

public interface SoundFactory {

    Sound createGameSoundtrack();

    Sound createJumpSound();

    Sound createCoinCollisionSound();

    Sound createGameOverSound();
}
