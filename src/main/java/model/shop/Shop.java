package model.shop;

import java.util.List;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item chosen by the player.
     */
    void shopItemPayment(ShopItem selectedItem);

    void misteryBoxPayment(MysteryBox box); 

    void printItems(); 

    List<ShopItem> getItems();

}
