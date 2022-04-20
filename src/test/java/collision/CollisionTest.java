package collision;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Dimension2D;
import model.CollisionManager;
import model.CollisionManagerImpl;
import model.Model;
import model.ModelImpl;
import model.entity.DynamicEntity;
import model.entity.EntityFactory;
import model.entity.EntityFactoryImpl;
import model.entity.SpawnLevel;
import model.player.Player;
import model.player.PlayerImpl;
import sound.SoundFactoryImpl;

public class CollisionTest {

    private final int distance = 1000;
    private final CollisionManager manager = new CollisionManagerImpl();
    private final Player player = new PlayerImpl(new SoundFactoryImpl());
    private final EntityFactory factory = new EntityFactoryImpl(new Dimension2D(854, 480));
    private final List<DynamicEntity> objects = new ArrayList<>();
    private final Model model = new ModelImpl(new SoundFactoryImpl());
    private final JFXPanel jfxPanel = new JFXPanel(); //Initialize JavaFx environment

    @Test
    public void testCollisionWithPlatform() {
        objects.add(factory.createPlatform(SpawnLevel.ONE));
    }

    @Test
    public void testCollisionWithCoin() {
        objects.clear();
        objects.add(factory.createCoin(SpawnLevel.ZERO));
        assertEquals(model.getStatistics().getGameCoins(), 0);
        objects.get(0).updatePosition(distance);
        manager.playerCollidesWidth(player, objects, model);
        assertEquals(model.getStatistics().getGameCoins(), 1);
    }

}
