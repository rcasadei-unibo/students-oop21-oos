package main.model.shop;

import java.util.List;

public interface Shop {

    /**
     * If the player has enough money, update the player properties.
     * @param selectedItem the item selected by the player
     */
    void payment(ShopItem selectedItem);

    /**
     * 
     * @return the items of the list.
     */
    List<ShopItem> getItems();

    /**
     * 
     * @return the list of the purchased items.
     */
    List<ShopItem> getPurchasedItems(); 

}
