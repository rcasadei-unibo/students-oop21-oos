package player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.geometry.Rectangle2D;
import model.player.JumpState;
import model.player.Player;
import model.player.PlayerImpl;
import sound.SoundFactoryImpl;

class PlayerTest {

    private final Player player = new PlayerImpl(new SoundFactoryImpl());

    @Test
    void testJump() {
        /*Make the player jump, the fields isJumping must be true, 
         * and the field isGoingDown must be false*/
        player.jump();
        assertEquals(JumpState.UP, player.getJumpState());
    }

    @Test
    void testUpdateJump1() {
        player.jump();
        player.updateJump();
        assertTrue(player.getBounds().getMinY() < PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT);
        assertNotEquals(JumpState.DOWN, player.getJumpState());
    }

    @Test
    void testUpdateJump2() {
        player.updateJump();
        assertEquals(player.getBounds().getMinY(), PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT);
        assertEquals(JumpState.NOT_JUMPING, player.getJumpState());
    }

    @Test
    void testLifes() {
        player.setNumberOfLives(2);
        assertEquals(player.getLives(), 3);
    }

    @Test
    void testJumpCounter() {
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
   void testBounds() {
        assertEquals(player.getBounds(), new Rectangle2D(PlayerImpl.PLAYER_X,
                                                         PlayerImpl.LAND - PlayerImpl.MAIN_CHARACTER_HEIGHT,
                                                         PlayerImpl.MAIN_CHARACTER_WIDTH, 
                                                         PlayerImpl.MAIN_CHARACTER_HEIGHT));
    }

}
