package ovinger.oving10.oppgave2;


/**
 * This class represents a dish.
 * A dish has a name, a price and a type (starter, main course or dessert)
 * and a recipe.
 * 
 * @author Ingar S. Asheim
 */
public class Dish {
    
    private final String name;
    private final double price;
    private final String type;
    private final String recipe;
    
    /**
     * The constructor takes all the parameters and initializes the fields
     * @param name 
     * @param price
     * @param type 
     * @param recipe
     */
    public Dish(String name, double price, String type, String recipe) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.recipe = recipe;
    }

    /**
     * Copy constructor for Dish
     * 
     * @param dish
     */
    public Dish(Dish dish) {
        this.name = dish.name;
        this.price = dish.price;
        this.type = dish.type;
        this.recipe = dish.recipe;
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
