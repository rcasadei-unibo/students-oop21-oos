package main.model.shop;

/**
 * Lists all of the prices
 *
 */
public enum Skins {
    PROGRAMMER("Programmer", 500), 
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
