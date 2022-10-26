package ovinger.oving10.oppgave2;

import java.util.ArrayList;

/**
 * @author Ingar S. Asheim
 * 
 * This class represents a menu. A menu consists
 * of multiple Dish objects.
 */

public class Menu {

    private ArrayList<Dish> dishes;

    //TODO: Check that the arraylist contains at least two dishes
    public Menu(ArrayList<Dish> dishes) {
        if (!hasAtLeastTwoDishes(dishes)) {
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }

        this.dishes = new ArrayList<>(dishes);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }


    public void removeDish(String name) {
        if (!(dishes.size() > 2)) {
            //TODO: IllegalStateException?
            throw new IllegalArgumentException("A menu must have at least two dishes");
        }

        if (!containsDish(name)) {
            throw new IllegalArgumentException("The menu does not contain a dish with the name " + name);
        }

        dishes.remove(getDish(name));
    }

    public ArrayList<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }

    public Dish getDish(String name) {
        //TODO: Is this the correct way of handling this?
        // We don't necessarily want to crash the program if the dish is not found
        if (!containsDish(name)) {
            throw new IllegalArgumentException("The menu does not contain a dish with the name " + name);
        }

        return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
    }
    
    public double getTotalPrice() {
        return dishes.stream().mapToDouble(dish -> dish.getPrice()).sum();
    }

    private boolean hasAtLeastTwoDishes(ArrayList<Dish> dishes) {
        return dishes.size() >= 2;
    }

    private boolean containsDish(String name) {
        return dishes.stream().anyMatch(dish -> dish.getName().equals(name));
    }
}
