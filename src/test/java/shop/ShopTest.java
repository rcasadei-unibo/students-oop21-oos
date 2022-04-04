package shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.shop.Shop;
import model.shop.ShopImpl;

public class ShopTest {

    private final Shop shop = new ShopImpl();

    /*@BeforeAll
    public void populate() {
        shop.printItems();
    }*/

    @Test
    public void testSkinsLength() {
        assertEquals(shop.getItems().size(), 3);
    }

}
