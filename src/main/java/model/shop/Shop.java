package model.shop;

import java.io.IOException;
import java.util.List;

import model.Statistics;

/**
 * 
 * Interface that identifies the game shop. 
 *
 */
public interface Shop {

    /**
     * If the player has enough money, update the total coins and purchase the shop item.
     * @param selectedItem the item chosen by the player.
     * @param stats the game statistics. 
     */
    void shopItemPayment(ShopItem selectedItem, Statistics stats);

    /**
     * If the player has enough money, update the total coins and purchase the mystery box.
     * @param box the mystery box the player is buying.
     * @param stats the game statistics.
     */
    void misteryBoxPayment(MysteryBox box, Statistics stats); 

    //DA TOGLIERE
    void printItems(); 

    /**
     * Returns all of the items in the shop.
     * @return a list of all the items of the shop.
     */
    List<ShopItem> getItems();

    /**
     * Returns all of the items purchased by the player.
     * @return a list of the purchased items. 
     */
    List<ShopItem> getPurchasedItems(); 

    /**
     * Saves on file the purchased shop items.
     */
    void saveShopItem() throws IOException; 

    /**
     * Read from file the purchased shop items.
     */
    void readPurchasedItems(); 

}
