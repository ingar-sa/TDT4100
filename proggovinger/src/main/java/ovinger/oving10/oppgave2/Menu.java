package ovinger.oving10.oppgave2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Ingar S. Asheim
 * 
 * This class represents a menu. A menu consists
 * of multiple Dish objects. It allows the user
 * to add and remove dishes, and to get the total 
 * price of the menu
 */

public class Menu {

    /**
     * The list of dishes in the menu
     */
    private ArrayList<Dish> dishes;

    /**
     * The constructor initializes the field
     * @param dishes The list of dishes in the menu
     * @throws IllegalArgumentException if the menu does not contain at least two dishes
     */
    public Menu(ArrayList<Dish> dishes) {
        if (!hasAtLeastTwoDishes(dishes)) {
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }

        this.dishes = new ArrayList<>(dishes);
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
     * @param dish The dish to remove
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
     * Returns a list of all the dishes in the menu
     * @return A list of all the dishes in the menu
     */
    public ArrayList<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }

    /**
     * Gets a dish with the name passed as a parameter
     * @param name name of the dish to get
     * @return The dish with the name passed as a parameter
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
    
}
