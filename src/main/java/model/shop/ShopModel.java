package model.shop;

import java.io.IOException;
import java.util.List;

import model.Statistics;

public interface ShopModel {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item chosen by the player.
     */
    void shopItemPayment(ShopItem selectedItem);

    /**
     * If the player has enough money. 
     * @param box
     */
    void misteryBoxPayment(MysteryBox box); 

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
    void saveShopItem() throws IOException;

    /**
     * 
     * @return the saved purchased items. 
     */
    void readPurchasedItems(); 

    int getTotalCoins();

}
