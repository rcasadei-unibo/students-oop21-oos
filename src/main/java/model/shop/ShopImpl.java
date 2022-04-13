package model.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implements the Shop and its methods, which are needed by the player to buy elements.
 *
 */
public class ShopImpl implements Shop {

    private final List<ShopItem> items = new ArrayList<>();
    private final List<ShopItem> purchasedItems = new ArrayList<>();

    public ShopImpl() {
        Stream.of(Skins.values()).forEach(i -> items.add(new ShopItemImpl(i.name(), i.getPrice())));
    }

    /**
     * @param selectedItem item
     */
    public void shopItemPayment(final ShopItem selectedItem) {
        int coins = 10000;
        if (this.checkPayment(selectedItem, coins)) {
            this.purchaseSkin(selectedItem, coins);
        }
    }

    /**
     * @param box the mistery box. 
     */
    public void misteryBoxPayment(final MysteryBox box) {
        // TODO Auto-generated method stub
        int coins = 1000; 
        if (checkMystery(box, coins)) {
            purchaseBox(box, coins);
        }
    }

    private boolean checkMystery(final MysteryBox box, final int coins) {
        return box.getPrice() <= coins; 
    }

    private boolean checkPayment(final ShopItem selectedItem, final int coins) {
        return !selectedItem.isPurchased() && selectedItem.getPrice() <= coins;
    }

    private void purchaseSkin(final ShopItem selectedItem, int coins) {
        selectedItem.purchase();
        coins -= selectedItem.getPrice();
        this.purchasedItems.add(selectedItem);
    }

    private void purchaseBox(final MysteryBox box, int coins) {
        coins -= box.getPrice(); 
    }

    /**
     *
     */
    public void printItems() {
        items.forEach(i -> System.out.println("Name: " + i.getName() + ", price: " + i.getPrice()));
    }

    /**
     * @return the items
     */
    public List<ShopItem> getItems() {
        return items;
    }

    /**
     *
     * @return the list of the purchased items
     */
    public List<ShopItem> getPurchasedItems() {
        return purchasedItems;
    }

}
