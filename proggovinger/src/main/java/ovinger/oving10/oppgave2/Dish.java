package ovinger.oving10.oppgave2;


/**
 * @author Ingar S. Asheim
 * This class represents a dish.
 * A dish has a name, a price and a type (starter, main course or dessert)
 * and a recipe.
 */
public final class Dish {
    
    /**
     * The name of the dish
     */
    private final String name;
    /**
     * The price of the dish
     */
    private final double price;
    /**
     * The type of the dish
     */
    private final String type;
    /**
     * The recipe of the dish
     */
    private final String recipe;
    
    /**
     * The constructor takes all the parameters and initializes the fields
     * @param name The name of the dish
     * @param price The price of the dish
     * @param type The type of the dish
     * @param recipe The recipe of the dish
     */
    public Dish(String name, double price, String type, String recipe) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.recipe = recipe;
    }

    /**
     * @return the name
     */
    public String getName() {
        return new String(name);
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return new String(type);
    }

    /**
     * @return the recipe
     */
    public String getRecipe() {
        return new String(recipe);
    }

    @Override
    public String toString() {
        return "Dish [name=" + name + ", price=" + price + ", type=" + type + ", recipe=" + recipe + "]";
    }

    
}
