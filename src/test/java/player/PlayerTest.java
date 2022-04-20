package player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.geometry.Rectangle2D;
import model.Player;
import model.PlayerImpl;
import sound.SoundFactoryImpl;

public class PlayerTest {

    private final Player player = new PlayerImpl(new SoundFactoryImpl());

    @Test
    public void testJump() {
        /*Make the player jump, the fields isJumping must be true, 
         * and the field isGoingDown must be false*/
        player.jump();
        assertTrue(player.isJumping());
        assertFalse(player.isGoingDown());
    }

    @Test
    public void testUpdateJump1() {
        player.jump();
        player.updateJump();
        assertTrue(player.getBounds().getMinY() < PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT);
        assertFalse(player.isGoingDown());
    }

    @Test
    public void testUpdateJump2() {
        player.updateJump();
        assertEquals(player.getBounds().getMinY(), PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT);
        assertFalse(player.isJumping());
    }

    @Test
    public void testLifes() {
        player.setNumberOfLives(2);
        assertEquals(player.getLives(), 3);
    }

    @Test
    public void testJumpCounter() {
        for (int i = 0; i < 4; i++) {
            player.jump();
            player.updateJump();
            while (player.getBounds().getMaxY() < PlayerImpl.LAND) {
                player.updateJump();
            }
        }
        assertEquals(player.getJumpCounter(), 4);
    }

    @Test
    public void testBounds() {
        assertEquals(player.getBounds(), new Rectangle2D(PlayerImpl.INITIAL_X,
                                                         PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT,
                                                         PlayerImpl.MAIN_CHARACTER_WIDTH, 
                                                         PlayerImpl.MAIN_CHARACTER_HEIGHT));
    }

}
