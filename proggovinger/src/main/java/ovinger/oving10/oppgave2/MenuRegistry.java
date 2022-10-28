package ovinger.oving10.oppgave2;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class represents a registry of menus and dishes.
 * It allows the user to add and remove menus and dishes.
 * It also allows the user to find a dish by name, all dishes
 * of a certain type, and all dishes in a certain price range.
 * 
 * @author Ingar S. Asheim
 */
public final class MenuRegistry {

    private ArrayList<Menu> menus;
    
    private ArrayList<Dish> dishes;

    /**
     * The constructor initializes the fields.
     */
    public MenuRegistry() {
        menus = new ArrayList<Menu>();
        dishes = new ArrayList<Dish>();
    }

    /**
     * Adds a menu to the registry.
     * @param menu The menu to add
     */
    public void addMenu(Menu menu) {
        //TODO: Should this be a deep copy, i.e. new Menu(menu)?
        menus.add(menu);
    }

    /**
     * Creates a menu from the dishes with the names passed as parameters
     * and adds it to the registry.
     * @param dishNames The list of the names of the dishes to add to the menu
     * @throws IllegalArgumentException if the menu does not contain at least two dishes
     * @throws NoSuchElementException if the menu does not contain a dish with the name passed as a parameter
     */
    public void addMenu(ArrayList<String> dishNames) {
        ArrayList<Dish> menuDishes = new ArrayList<Dish>();

        try {
            menuDishes = dishNames.stream().map(name -> getDishByName(name)).collect(Collectors.toCollection(ArrayList::new));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("One or more of the dishes does not exist");
        }

        try {
            menus.add(new Menu(menuDishes));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }
    }

    /**
     * Adds a dish to the registry.
     * @param dish The dish to add
     */
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    
    /**
     * Gets the dish with the name passed as an argument
     * @param name Name of the dish
     * @return The dish with the name passed as an argument
     * @throws NoSuchElementException if no dish with the name passed as an argument exists
     */
    public Dish getDishByName(String name) {
        try {
            return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException  e) {
            throw new NoSuchElementException("There is no dish with the name " + name);
        }
    }

    /**
     * Gets all dishes of the type passed as an argument
     * @param type The type of dishes to get
     * @return A list of all dishes of the type passed as an argument
     * @throws NoSuchElementException If there are no dishes of the type passed as an argument
     */
    public ArrayList<Dish> getDishesByType(String type) {
        try {
            return dishes.stream().filter(dish -> dish.getType().equals(type)).collect(Collectors.toCollection(ArrayList::new));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There are no dishes of the type " + type);
        }
    
    }

    /**
     * Gets all menus within the price range passed as arguments    
     * @param minPrice The minimum price of the menus to get
     * @param maxPrice The maximum price of the menus to get
     * @return A list of all the menus within the price range
     * @throws IllegalArgumentException if minPrice is greater than maxPrice or if minPrice is negative
     * @throws NoSuchElementException if there are no menus within the price range
     */
    public ArrayList<Menu> getMenusInPriceRange(double min, double max) {
        if (!(min < max) && !(min >= 0)) {
            throw new IllegalArgumentException("The minimum price must be must be greater than or equal to zero and less than the maximum price.");
        }

        try {
            return menus.stream().filter(menu -> menu.getTotalPrice() >= min && menu.getTotalPrice() <= max).collect(Collectors.toCollection(ArrayList::new));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There are no menus within the price range " + min + " - " + max);
        }
        
    }

}
