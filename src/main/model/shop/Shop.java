package main.model.shop;

import java.util.List;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param item the item chosen by the player 
     */
    void payment();

    void printItems(); 
    
    List<ShopItem> getItems();

}
