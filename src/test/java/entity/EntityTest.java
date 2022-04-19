package entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import model.Model;
import model.ModelImpl;
import model.entity.DynamicEntity;
import model.entity.EntityFactory;
import model.entity.EntityFactoryImpl;
import model.entity.EntityType;
import model.entity.SpawnLevel;
import view.entity.EntityImages;


class EntityTest {

    private static final double WORLD_WIDTH = 854;
    private static final double WORLD_HEIGHT = 480;

    private static final double COIN_WIDTH = 35;
    private static final double COIN_HEIGHT = 40;
    private static final double COIN_EXPECTED_X = 1039.5;
    private static final double COIN_EXPECTED_Y = 290;
    private static final double COIN_EXPECTED_DISTANCE = 668.5;

    private static final double PLATFORM_WIDTH = 417;
    private static final double PLATFORM_HEIGHT = 35;
    private static final double PLATFORM_EXPECTED_X = 854;
    private static final double PLATFORM_EXPECTED_Y = 185;
    private static final double PLATFORM_EXPECTED_DISTANCE = 437;

    private static final double HYDRANT_WIDTH = 43;
    private static final double HYDRANT_HEIGHT = 55;
    private static final double HYDRANT_EXPECTED_X = 1056.1;
    private static final double HYDRANT_EXPECTED_Y = 385;
    private static final double HYDRANT_EXPECTED_DISTANCE = 651.9;

    private static final double CONE_WIDTH = 37;
    private static final double CONE_HEIGHT = 55;
    private static final double CONE_EXPECTED_X = 1027.9;
    private static final double CONE_EXPECTED_Y = 385;
    private static final double CONE_EXPECTED_DISTANCE = 680.1;


    private final EntityFactory factory = new EntityFactoryImpl(new Dimension2D(WORLD_WIDTH, WORLD_HEIGHT));
    private final Model model = new ModelImpl(null); //Model instance used to test entities's effects 
    private final JFXPanel jfxPanel = new JFXPanel(); //Initialize JavaFx environment

    @Test
    void testCoin() {
        /*Test coin's initial state and position*/
        final DynamicEntity coin = factory.createCoin(SpawnLevel.ONE);
        assertEquals(coin.getBounds(), new Rectangle2D(COIN_EXPECTED_X, COIN_EXPECTED_Y, COIN_WIDTH, COIN_HEIGHT));
        assertFalse(coin.isOutofScreen());
        assertEquals(SpawnLevel.ONE, coin.getLevel());
        assertEquals(EntityType.COIN, coin.getType());
        assertEquals(COIN_EXPECTED_DISTANCE, coin.getDistance());
        assertFalse(coin.wasHit());
        /*Modify coin's state*/
        coin.hit(true);
        coin.updatePosition(WORLD_WIDTH * 2);
        /*Check the state modification*/
        assertTrue(coin.wasHit());
        assertTrue(coin.isOutofScreen());
        /*Test coins' effect*/
        final double initialValue = model.getStatistics().getGameCoins();
        coin.activateEffect(model);
        assertTrue(model.getStatistics().getGameCoins() > initialValue);

    }

    @Test
    void testPlatform() {
        /*Test platform's initial state and position*/
        final DynamicEntity platform = factory.createPlatform(SpawnLevel.TWO);
        assertEquals(platform.getBounds(), new Rectangle2D(PLATFORM_EXPECTED_X, PLATFORM_EXPECTED_Y, PLATFORM_WIDTH, PLATFORM_HEIGHT));
        assertFalse(platform.isOutofScreen());
        assertEquals(SpawnLevel.TWO, platform.getLevel());
        assertEquals(EntityType.PLATFORM, platform.getType());
        assertEquals(PLATFORM_EXPECTED_DISTANCE, platform.getDistance());
        assertFalse(platform.wasHit());
        /*Modify platform's state*/
        platform.hit(true);
        platform.updatePosition(WORLD_WIDTH * 2);
        /*Check the state modification*/
        assertTrue(platform.wasHit());
        assertTrue(platform.isOutofScreen());
        /*Platforms don't have effects to test*/
    }

    @Test
    void testObstacle() {
        /*Test obstacle's initial state and position*/
        final DynamicEntity obstacle = factory.createObstacle(SpawnLevel.ZERO);
        if (obstacle.getImage().getUrl().equals(EntityImages.OBSTACLE_ONE.getImage().getUrl())) {
            assertEquals(obstacle.getBounds(), new Rectangle2D(HYDRANT_EXPECTED_X, HYDRANT_EXPECTED_Y, HYDRANT_WIDTH, HYDRANT_HEIGHT));
            assertEquals(obstacle.getDistance(), HYDRANT_EXPECTED_DISTANCE);
        } else if (obstacle.getImage().getUrl().equals(EntityImages.OBSTACLE_TWO.getImage().getUrl())) {
            assertEquals(obstacle.getBounds(), new Rectangle2D(CONE_EXPECTED_X, CONE_EXPECTED_Y, CONE_WIDTH, CONE_HEIGHT));
            assertEquals(obstacle.getDistance(), CONE_EXPECTED_DISTANCE);
        }
        assertFalse(obstacle.isOutofScreen());
        assertEquals(SpawnLevel.ZERO, obstacle.getLevel());
        assertEquals(EntityType.OBSATCLE, obstacle.getType());
        assertFalse(obstacle.wasHit());
        /*Modify obstacle's state*/
        obstacle.hit(true);
        obstacle.updatePosition(WORLD_WIDTH * 2);
        /*Check the state modification*/
        assertTrue(obstacle.wasHit());
        assertTrue(obstacle.isOutofScreen());
        /*Test obstacles effect*/
        final double initialValue = model.getGameState().getPlayer().getLives();
        obstacle.activateEffect(model);
        assertEquals(model.getGameState().getPlayer().getLives(), initialValue - 1);
    }
}
