package model.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import model.Statistics;
import model.StatisticsImpl;

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
     * @param selectedItem the item selected by the player. 
     * @param stats the game statistics. 
     */
    public void shopItemPayment(final ShopItem selectedItem, final Statistics stats) {
        if (this.checkPayment(selectedItem, stats.getTotalCoins())) {
            this.purchaseSkin(selectedItem, stats);
        }
    }

    /**
     * @param box the mystery box. 
     * @param stats the game statistics.
     */
    public void misteryBoxPayment(final MysteryBox box, final Statistics stats) {
        if (checkMystery(box, stats.getTotalCoins())) {
            purchaseBox(box, stats);
        }
    }

    private boolean checkMystery(final MysteryBox box, final int coins) {
        return box.getPrice() <= coins; 
    }

    private boolean checkPayment(final ShopItem selectedItem, final int coins) {
        return !selectedItem.isPurchased() && selectedItem.getPrice() <= coins;
    }

    private void purchaseSkin(final ShopItem selectedItem, final Statistics stats) {
        selectedItem.purchase();
        stats.setTotalCoins(stats.getTotalCoins() - selectedItem.getPrice());
        this.purchasedItems.add(selectedItem);
    }

    private void purchaseBox(final MysteryBox box, final Statistics stats) {
        stats.setTotalCoins(stats.getTotalCoins() - box.getPrice());
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
