package model.shop;

import java.io.IOException;
import java.util.List;

import model.Statistics;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item chosen by the player.
     * @param stats the game statistics. 
     */
    void shopItemPayment(ShopItem selectedItem, Statistics stats);

    /**
     * If the player has enough money, 
     * @param box
     * @param stats
     */
    void misteryBoxPayment(MysteryBox box, Statistics stats); 

    void printItems(); 

    /**
     * 
     * @return the items of the shop.
     */
    List<ShopItem> getItems();

    /**
     * 
     * @return the purchased items. 
     */
    List<ShopItem> getPurchasedItems(); 

    /**
     * 
     */
    void saveShopItem() throws IOException ; 

    /**
     * 
     * @return the saved purchased items. 
     */
    void readPurchasedItems(); 

}
