package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.model.shop.Shop;
import main.model.shop.ShopImpl;

/**
 * Tests all of the function of the shop.
 *
 */
public class ShopTest {

    private final Shop shop = new ShopImpl();

    @Test
    public void testSkinsLength() {
        assertEquals(shop.getItems().size(), 3);
    }

    @Test
    public void testPurchasingItem() {
        
    }

}
