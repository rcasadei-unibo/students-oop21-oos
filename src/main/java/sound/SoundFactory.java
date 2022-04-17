package sound;

/**
 * 
 * Interface of a factory of {@link Sound}.
 *
 */
public interface SoundFactory {

    /**
     * 
     * @return a {@link Sound} that plays the game's soundtrack.
     */
    Sound createGameSoundtrack();

    /**
     * 
     * @return a {@link Sound} that plays the player jump sound.
     */
    Sound createJumpSound();

    /**
     * 
     * @return a {@link Sound} that plays the coin collected.
     */
    Sound createCoinCollisionSound();

    /**
     * 
     * @return a {@link Sound} that plays the game over sound.
     */
    Sound createGameOverSound();
}
