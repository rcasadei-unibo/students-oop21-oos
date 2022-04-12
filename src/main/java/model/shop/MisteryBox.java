package model.shop;

import java.util.Random;

public class MisteryBox {

    private final String name; 
    private final int price; 
    private final Random rand = new Random(); 

    private static final int PRIZES_NUM = 4; 

    public MisteryBox(final String name, final int price) {
        this.name = name; 
        this.price = price; 
    }

    public void createPrize() {
        final int random = rand.nextInt(PRIZES_NUM); 
        switch (random) {
            case 0: 
                //Vinci 1000 monete
                break; 
            case 1: 
                //Non vinci nulla
                break; 
            case 2: 
                //Vita extra
                break; 
            case 3: 
                //Parti già con lo scudo
                break; 
            default: 
                break; 
        }
    }

}
