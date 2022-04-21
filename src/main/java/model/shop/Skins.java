package model.shop;

/**
 * Lists all of the prices.
 *
 */
public enum Skins {

    /**
     * 
     */
    PLAYER("Player.png", 0),
    /**
     * Programmer skin and its price.
     */
    PROGRAMMER("Programmer.png", 50), 

    /**
     * Dinosaur skin and its price. 
     */
    DINOSAUR("DinoSkin.png", 100); 

    private final int price; 
    private final String name; 

    Skins(final String name, final int price) {
        this.price = price; 
        this.name = name; 
    }

    public int getPrice() {
        return price;
    }

    public String getSkinName() {
        return name;
    }
}
