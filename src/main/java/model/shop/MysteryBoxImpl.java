package model.shop;

import java.util.Random;

import model.Model;
import model.Statistics;
import model.entity.DynamicEntity;

public class MysteryBoxImpl implements MysteryBox {

    private final int price; 
    private final Random rand = new Random(); 

    private static final int BOX_PRICE = 500; 
    private static final int PRIZES_NUM = 4; 
    private static final int MONEY_PRIZE = 1000; 

    public MysteryBoxImpl() {
        this.price = BOX_PRICE; 
    }

    public final int getPrice() {
        return this.price; 
    }

    public final void createPrize(final Statistics stats, final Model model) {
        final int random = rand.nextInt(PRIZES_NUM); 
        final DynamicEntity shield; 
        switch (random) {
            case 0: 
                stats.setTotalCoins(stats.getTotalCoins() + MONEY_PRIZE);
                break; 
            case 1: 
                break; 
            case 2: 
                model.getGameState().getPlayer().setNumberOfLives(1);
                break; 
            case 3: 
                //Parti già con lo scudo
                //RIVEDI BENE
                //shield.activateEffect(model);
                break; 
            default: 
                break; 
        }
    }

}
