package model.shop;

import model.Model;
import model.Statistics;

public interface MysteryBox {

    /**
     * Create the prize of the mystery box, choosing between four different options.
     * @param stats the game statistics. 
     * @param model the game model. 
     * @return the string with the prize message. 
     */
    String createPrize(Statistics stats, Model model); 

    /**
     * 
     * @return the price of the box.
     */
    int getPrice(); 

}
