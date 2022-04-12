package model.shop;

import java.util.List;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param ShopItem the item chosen by the player 
     */
    void shopItemPayment(ShopItem selectedItem);

    void printItems(); 

    List<ShopItem> getItems();

}
