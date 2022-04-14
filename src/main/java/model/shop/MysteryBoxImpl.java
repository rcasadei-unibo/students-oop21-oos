package model.shop;

import java.util.Random;

import model.Model;
import model.Statistics;

public class MysteryBoxImpl implements MysteryBox {

    private final int price; 
    private final Random rand = new Random(); 

    private static final int BOX_PRICE = 100; 
    private static final int PRIZES_NUM = 3; 
    private static final int MONEY_PRIZE = 200; 

    public MysteryBoxImpl() {
        this.price = BOX_PRICE; 
    }

    public final int getPrice() {
        return this.price; 
    }

    public final String createPrize(final Statistics stats, final Model model) {
        final int random = rand.nextInt(PRIZES_NUM); 
        String message; 
        switch (random) {
            case 0: 
                stats.setTotalCoins(stats.getTotalCoins() + MONEY_PRIZE);
                message = "Congratulation! You won 1000 coins!"; 
                break; 
            case 1: 
                message = "You can't always be lucky, you've just paid for nothing"; 
                break; 
            case 2: 
                model.getGameState().getPlayer().setNumberOfLives(1);
                message = "Yeah! You've just gained an extra life!!!"; 
                break; 
            default: 
                message = "Error: selected prize does not exist"; 
                break; 
        }
        return message; 
    }

}
