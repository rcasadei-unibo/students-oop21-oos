package model.shop;

import java.io.IOException;
import java.util.List;

public interface ShopModel {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item chosen by the player.
     */
    void shopItemPayment(ShopItem selectedItem);

    /**
     * If the player has enough money. 
     * @return the result string.
     */
    String misteryBoxPayment(); 

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
     */
    //void readPurchasedItems(); 

    /**
     * 
     * @return the total coins.
     */
    int getTotalCoins();

    boolean checkMystery(MysteryBox box, int coins);

    boolean checkPayment(ShopItem selectedItem, int coins);

    void writeSkinOnFile() throws IOException;


    boolean isSelected(String name);

    void setSelected(String name);


}
