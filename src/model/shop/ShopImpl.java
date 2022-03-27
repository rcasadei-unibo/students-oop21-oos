package model.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShopImpl implements Shop {

    private final List<ShopItem> items = new ArrayList<>();

    public ShopImpl() {
        Stream.of(Skins.values()).forEach(i -> items.add(new ShopItemImpl(i.name(), i.getPrice())));
    }

    public void payment() {
        // TODO Auto-generated method stub
    }

    public void printItems() {
        items.forEach(i -> System.out.println("Name: " + i.getName() + ", price: " + i.getPrice()));
    }
    
    public List<ShopItem> getItems() {
        return items;
    }

}
