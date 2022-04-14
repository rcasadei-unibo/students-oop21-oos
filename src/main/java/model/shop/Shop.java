package model.shop;

import java.util.List;

import model.Statistics;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item chosen by the player.
     */
    void shopItemPayment(ShopItem selectedItem, Statistics stats);

    void misteryBoxPayment(MysteryBox box, Statistics stats); 

    void printItems(); 

    List<ShopItem> getItems();

}
