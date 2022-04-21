package controller;

import model.shop.ShopModel;

public interface ShopController {

    void render();

    ShopModel getShopModel();

    int getTotalCoins();

    int increaseSkinCounter();

    int decreaseSkinCounter();

}
