package controller;

import java.io.IOException;

import model.shop.ShopModel;

public interface ShopController {

    void render();

    ShopModel getShopModel();

    int getTotalCoins();

    int increaseSkinCounter();

    int decreaseSkinCounter();

    void close() throws IOException;

}
