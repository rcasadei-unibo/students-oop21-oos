package sound;

/**
 * 
 * Enumeration of sounds.
 *
 */
public enum SoundType {

    /**
     * The sound when player collects a coin.
     * 
     */
    COIN("/sounds/Coin.mp3"),
    /**
     * The sound when player jumps.
     * 
     */
    JUMP("/sounds/Jump.mp3"),
    /**
     * The sound when is game over.
     * 
     */
    GAME_OVER("/sounds/GameOver.mp3"),
    /**
     * The game's soundtrack.
     */
    GAME_SOUNDTRACK("/sounds/GameSoundtrack.mp3");

    private final String string;

    /**
     * 
     * @param string the path of the sound.
     */
    SoundType(final String string) {
        this.string = string;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.string;
    }

}
