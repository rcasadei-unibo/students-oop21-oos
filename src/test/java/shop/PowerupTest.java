package shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Model;
import model.ModelImpl;
import model.entity.DynamicEntity;
import model.entity.EntityType;
import model.entity.SpawnLevel;
import model.entity.powerup.ExtraLife;
import model.entity.powerup.Mushroom;
import model.entity.powerup.Shield;
import model.entity.powerup.Spraybomb;
import model.entity.powerup.Superjump;
import model.player.PlayerImpl;
import sound.SoundFactoryImpl;
import view.entity.EntityImages;

public class PowerupTest {

    private static final int X = 854; 
    private static final int Y = 440; 

    private DynamicEntity extralife;
    private DynamicEntity superjump; 
    private DynamicEntity mushroom; 
    private DynamicEntity shield; 
    private DynamicEntity spraybomb; 
    private PlayerImpl player; 
    private Model model = new ModelImpl(new SoundFactoryImpl()); 
    private Point2D.Double coordinates = new Point2D.Double(X, Y); 

    @BeforeAll
    public final void prepare() {
        extralife = new ExtraLife(coordinates, EntityImages.EXTRALIFE.getImage(), SpawnLevel.ONE, EntityType.POWERUP); 
        superjump = new Superjump(coordinates, EntityImages.SUPERJUMP.getImage(), SpawnLevel.ONE, EntityType.POWERUP); 
        mushroom = new Mushroom(coordinates, EntityImages.MUSHROOM.getImage(), SpawnLevel.ONE, EntityType.POWERUP); 
        shield = new Shield(coordinates, EntityImages.SHIELD.getImage(), SpawnLevel.ONE, EntityType.POWERUP); 
        spraybomb = new Spraybomb(coordinates, EntityImages.SPRAYBOMB.getImage(), SpawnLevel.ONE, EntityType.POWERUP);
        player = new PlayerImpl(); 
    }

    @Test
    public final void testExtraLife() {
    }

    @Test
    public final void testSuperjump() {
        superjump.activateEffect(null);
        //assertTrue(superjump.isSuperJumping());
    }

    @Test
    public final void testMushroom() {
    }

    @Test
    public final void testShield() {
        shield.activateEffect(model);
        assertTrue(player.isShieldActive());
    }

    @Test
    public final void testSpraybomb() {
        spraybomb.activateEffect(model);
        assertEquals(model.getGameState().getEntities().size(), 0); 
    }

}
