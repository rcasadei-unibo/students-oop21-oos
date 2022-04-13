package model.shop;

public interface MysteryBox {

    /**
     * Create the prize of the mistery box, choosing between four different options.
     */
    void createPrize(); 

    /**
     * 
     * @return the price of the box.
     */
    int getPrice(); 

}
