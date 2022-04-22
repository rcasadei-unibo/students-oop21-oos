package model.shop;

import java.util.Random;

import model.statistic.Statistics;

public class MysteryBoxImpl implements MysteryBox {

    private final int price; 
    private final Random rand = new Random(); 

    private static final int BOX_PRICE = 200; 
    private static final int PRIZES_NUM = 3; 
    private static final int MONEY_PRIZE1 = 300; 
    private static final int MONEY_PRIZE2 = 150; 

    public MysteryBoxImpl() {
        this.price = BOX_PRICE; 
    }

    /**
     * {@inheritDoc}
     */
    public final int getPrice() {
        return this.price; 
    }

    /**
     * {@inheritDoc}
     */
    public final String createPrize(final Statistics stats) {
        final int random = rand.nextInt(PRIZES_NUM); 
        String message; 
        switch (random) {
            case 0: 
                stats.setTotalCoins(stats.getTotalCoins() + MONEY_PRIZE1);
                message = "Congratulation! You won 500 coins!"; 
                break; 
            case 1: 
                message = "You can't always be lucky, you've just paid for nothing"; 
                break; 
            case 2: 
                stats.setTotalCoins(stats.getTotalCoins() + MONEY_PRIZE2);
                message = "Yeah! You've just gained 1000 coins!!!"; 
                break; 
            default: 
                message = "Error: selected prize does not exist"; 
                break; 
        }
        return message; 
    }

}
