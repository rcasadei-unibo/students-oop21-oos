package model.shop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Statistics;
import model.StatisticsImpl;

/**
 * Implements the Shop and its methods, which are needed by the player to buy elements.
 *
 */
public class ShopModelImpl implements ShopModel {

    private static final String SEP = File.separator;
    private static final String FILE_NAME = System.getProperty("user.home") + SEP + "OOS_shopItems.txt";
    private final List<ShopItem> items = new ArrayList<>();
    private List<ShopItem> purchasedItems = new ArrayList<>();

    private final Statistics statistics;

    public ShopModelImpl(final Statistics statistics) {

        this.statistics = statistics;

        Stream.of(Skins.values()).forEach(i -> items.add(new ShopItemImpl(i.name(), i.getPrice())));
        this.readPurchasedItems();
    }

    /**
     * @param selectedItem the item selected by the player. 
     */
    public void shopItemPayment(final ShopItem selectedItem) {
        if (this.checkPayment(selectedItem, this.statistics.getTotalCoins())) {
            this.purchaseSkin(selectedItem);
            //SALVARE MONETE
        }
    }

    /**
     * @param box the mystery box. 
     */
    public void misteryBoxPayment(final MysteryBox box) {
        if (checkMystery(box, this.statistics.getTotalCoins())) {
            purchaseBox(box);
            //SALVARE MONETE
        }
    }

    private boolean checkMystery(final MysteryBox box, final int coins) {
        return box.getPrice() <= coins; 
    }

    private boolean checkPayment(final ShopItem selectedItem, final int coins) {
        return !selectedItem.isPurchased() && selectedItem.getPrice() <= coins;
    }

    private void purchaseSkin(final ShopItem selectedItem) {
        selectedItem.purchase();
        this.statistics.setTotalCoins(this.statistics.getTotalCoins() - selectedItem.getPrice());
        this.purchasedItems.add(selectedItem);
        // Qui salvare su mio file OOS_statistics.txt totalCoins
    }

    private void purchaseBox(final MysteryBox box) {
        this.statistics.setTotalCoins(this.statistics.getTotalCoins() - box.getPrice());
    }

    /**
     *
     */
    public void printItems() {
        items.forEach(i -> System.out.println("Name: " + i.getName() + ", price: " + i.getPrice()));
    }

    /**
     * {@inheritDoc}
     */
    public List<ShopItem> getItems() {
        return items;
    }

    /**
     *{@inheritDoc}
     */
    public List<ShopItem> getPurchasedItems() {
        return purchasedItems;
    }

    /**
     * {@inheritDoc}
     */
    public void saveShopItem() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            items.stream()
            .forEach(elem -> {
                try {
                    if (purchasedItems.contains(elem)) {
                        bw.write("1"); 
                        bw.newLine(); 
                    } else {
                        bw.write("0"); 
                        bw.newLine(); 
                    }
                } catch (IOException e) {
                    System.out.println("Error in saveShopItem");
                }
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    public void readPurchasedItems() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_NAME))) {
            List<String> filesItems = br.lines().collect(Collectors.toList()); 
            Stream.iterate(0, i -> i + 1).limit(items.size()).forEach(i -> {
                if (filesItems.get(i).equals("1")) {
                    purchasedItems.add(items.get(i));
                }
            });
        } catch (IOException e) {
            purchasedItems = new ArrayList<>(); 
        }
    }

    @Override
    public int getTotalCoins() {
        return this.statistics.getTotalCoins();
    }

}
