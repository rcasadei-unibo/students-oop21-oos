package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.shop.Shop;
import model.shop.ShopImpl;

public class ShopTest {

    private final Shop shop = new ShopImpl();

    @Before
    public void populate() {
        shop.printItems();
    }

    @Test
    public void testSkinsLength() {
        assertEquals(shop.getItems().size(), 3);
    }

}
