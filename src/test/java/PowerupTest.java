

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.entity.DynamicEntity;
import model.entity.EntityType;
import model.entity.SpawnLevel;
import model.entity.powerup.ExtraLife;
import model.entity.powerup.Mushroom;
import model.entity.powerup.Shield;
import model.entity.powerup.Spraybomb;
import model.entity.powerup.Superjump;

public class PowerupTest {
    //854 x 440
    private DynamicEntity extralife;
    private DynamicEntity superjump; 
    private DynamicEntity mushroom; 
    private DynamicEntity shield; 
    private DynamicEntity spraybomb; 

    @BeforeAll
    public final void prepare() {
        extralife = new ExtraLife(null, null, SpawnLevel.ONE, EntityType.POWERUP); 
        superjump = new Superjump(null, null, SpawnLevel.ONE, EntityType.POWERUP); 
        mushroom = new Mushroom(null, null, SpawnLevel.ONE, EntityType.POWERUP); 
        shield = new Shield(null, null, SpawnLevel.ONE, EntityType.POWERUP); 
        spraybomb = new Spraybomb(null, null, SpawnLevel.ONE, EntityType.POWERUP); 
    }

    @Test
    public final void testExtraLife() {
        
    }

    @Test
    public final void testSuperjump() {
        
    }

    @Test
    public final void testMushroom() {
        
    }

    @Test
    public final void testShield() {
        
    }

    @Test
    public final void testSpraybomb() {
        
    }

}
