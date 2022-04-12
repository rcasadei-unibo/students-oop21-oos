package model.shop;

/**
 * Lists all of the prices.
 *
 */
public enum Skins {
    /**
     * Programmer skin and its price.
     */
    PROGRAMMER("Programmer", 500), 

    /**
     * Dinosaur skin and its price. 
     */
    DINOSAUR("Dinosaur", 1000),
    FREDDIE("Freddie", 2000); 

    private final int price; 
    private final String name; 

    Skins(final String name, final int price) {
        this.price = price; 
        this.name = name; 
    }

    public int getPrice() {
        return price;
    }
}
