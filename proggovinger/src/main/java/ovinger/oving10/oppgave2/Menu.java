package ovinger.oving10.oppgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a menu. A menu consists
 * of multiple Dish objects. It allows the user
 * to add and remove dishes, and to get the total 
 * price of the menu
 * @author Ingar S. Asheim
 */
public class Menu {

    private List<Dish> dishes;

    /**
     * The constructor initializes the field
     * @param dishes The list of dishes in the menu
     * @throws IllegalArgumentException if the menu does not contain at least two dishes
     */
    public Menu(ArrayList<Dish> dishes) {
        if (!hasAtLeastTwoDishes(dishes)) {
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }

        // TODO: Is the bottom impl. better, since it ensures deep copies
        // of the dish objects, or is it overkill?

        // this.dishes = new ArrayList<>(dishes);
        this.dishes = copyDishes(dishes);
    }

    public Menu(Menu menu) {
        this.dishes = menu.getDishes();
    }

    /**
     * Adds a dish to the menu
     * @param dish The dish to add
     */
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    /**
     * Removes a dish from the menu
     * @param dish Name of the dish to remove
     * @throws NoSuchElementException if the menu does not contain the dish
     * @throws NoSuchElementException if the menu contains only two dishes
     */
    public void removeDish(String name) {
        if (!(dishes.size() > 2)) {
            //TODO: IllegalStateException?
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }

        if (!containsDish(name)) {
            throw new NoSuchElementException("The menu does not contain a dish with the name " + name);
        }

        dishes.remove(getDish(name));
    }

    
    /**
     * Returns a deep copy of the dishes in the menu
     * @return A list of all the dishes in in the menu
     */
    public ArrayList<Dish> getDishes() {
        // TODO: Better to change the copyDishes method
        // to use List instead of ArrayList?
        return copyDishes(new ArrayList<>(dishes));
    }

    /**
     * Gets a dish with the name passed as a parameter
     * @param name name of the dish to get
     * @return The dish with the name passed as an argument
     * @throws NoSuchElementException if the menu does not contain the dish
     */
    public Dish getDish(String name) {
        //TODO: Is this the correct way of handling this?
        // We don't necessarily want to crash the program if the dish is not found
        try {
            return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The menu does not contain a dish with the name " + name);
        }
    }
    
    /**
     * Returns the total price of the menu
     * @return The total price of the menu
     */
    public double getTotalPrice() {
        return dishes.stream().mapToDouble(dish -> dish.getPrice()).sum();
    }

    /**
     * Checks if the list has at least two dishes
     * @param dishes List of dishes to check
     * @return True if the list has at least two dishes, false otherwise
     */
    private boolean hasAtLeastTwoDishes(ArrayList<Dish> dishes) {
        return dishes.size() >= 2;
    }

    /**
     * Checks if the menu contains a dish with the name passed as a parameter
     * @param name The name of the dish to check
     * @return True if the menu contains a dish with the name passed as a parameter, false otherwise
     */
    private boolean containsDish(String name) {
        return dishes.stream().anyMatch(dish -> dish.getName().equals(name));
    }
    
    /**
     * Creates a deep copy of the list of dishes passed as a parameter
     * @param dishes The list of dishes to copy
     * @return A deep copy of the list of dishes passed as a parameter
     */
    private ArrayList<Dish> copyDishes(ArrayList<Dish> dishes) {
        ArrayList<Dish> newDishList = new ArrayList<>();
        dishes.stream().forEach(dish -> newDishList.add(new Dish(dish)));
        return newDishList;
    }
}
