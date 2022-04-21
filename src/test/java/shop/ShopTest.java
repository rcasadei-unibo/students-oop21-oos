package shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.shop.ShopModel;
import model.shop.ShopModelImpl;
import model.statistic.Statistics;
import model.statistic.StatisticsImpl;

public class ShopTest {

    private ShopModel shop; 
    private Statistics stats; 

    @BeforeAll
    public final void prepare() {
        shop = new ShopModelImpl(stats); 
        stats = new StatisticsImpl(); 
    }

    @Test
    public void testSkinsLength() {
        assertEquals(shop.getItems().size(), 3);
    }

    @Test
    public final void testEnoughMoney() {
        Integer moneyGained = 10000; 
        shop.shopItemPayment(shop.getItems().get(0));
    }
}
