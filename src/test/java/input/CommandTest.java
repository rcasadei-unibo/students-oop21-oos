package input;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Model;
import model.ModelImpl;
import model.Player;
import sound.SoundFactoryImpl;

class CommandTest {

    private static final double SCREEN_WIDTH = 854.0;
    private static final double SCREEN_HEIGHT = 480.0;

    private Model model;
    private Player player;

    @BeforeEach
    void init() {
        this.model = new ModelImpl(SCREEN_WIDTH, SCREEN_HEIGHT, new SoundFactoryImpl());
        this.player = this.model.getGameState().getPlayer();
    }

    @Test
    void testJump() {
        final Command space = new Space(this.model.getGameState());
        assertFalse(this.player.isJumping());
        space.execute();
        assertTrue(this.player.isJumping());
    }
}
