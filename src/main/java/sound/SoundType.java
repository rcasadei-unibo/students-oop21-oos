package sound;

public enum SoundType {

    COIN("/sounds/Coin.mp3"),
    JUMP("/sounds/Jump.mp3"),
    GAME_OVER("/sounds/GameOver.mp3"),
    GAME_SOUNDTRACK("/sounds/GameSoundtrack.mp3");

    private final String string;

    SoundType(final String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }

}
