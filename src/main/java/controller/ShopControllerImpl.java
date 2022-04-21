package controller;

import model.Statistics;
import model.shop.ShopModel;
import model.shop.ShopModelImpl;
import view.ShopView;

public class ShopControllerImpl implements ShopController {

    private final ShopView shopView;
    private final ShopModel shopModel;
    private int imageIndex;

    public ShopControllerImpl(final ShopView shopView, final Statistics statistics) {
        this.shopView = shopView;
        this.shopModel = new ShopModelImpl(statistics);
    }

    @Override
    public void render() {
        this.shopView.render();
    }

    @Override
    public ShopModel getShopModel() {
        return this.shopModel;
    }

    @Override
    public int increaseSkinCounter() {
        imageIndex++; 
        if (imageIndex >= this.shopModel.getItems().size()) {
            imageIndex = 0; 
        }
        return imageIndex;
    }

    @Override
    public int decreaseSkinCounter() {
        imageIndex--; 
        if (imageIndex < 0) {
            imageIndex = this.shopModel.getItems().size() - 1; 
        }
        return imageIndex;
    }

    @Override
    public int getTotalCoins() {
        return this.shopModel.getTotalCoins();
    }

}
