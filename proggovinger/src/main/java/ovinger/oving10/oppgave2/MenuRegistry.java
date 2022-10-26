package ovinger.oving10.oppgave2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MenuRegistry {
    
    private ArrayList<Menu> menus;
    
    private ArrayList<Dish> dishes;

    public MenuRegistry() {
        menus = new ArrayList<Menu>();
        dishes = new ArrayList<Dish>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void addMenu(ArrayList<String> dishNames) {
        ArrayList<Dish> menuDishes = dishNames.stream().map(name -> getDishFromName(name)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        menus.add(new Menu(menuDishes));
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    
    public Dish getDishFromName(String name) {
        try {
            return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException  e) {
            throw new IllegalArgumentException("There is no dish with the name " + name);
        }
    }

    public ArrayList<Dish> getDishesFromType(String type) {
        try {
            return dishes.stream().filter(dish -> dish.getType().equals(type)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("There are no dishes of the type " + type);
        }
    
    }

    public ArrayList<Menu> getMenusInPriceRange(double min, double max) {
        try {
            return menus.stream().filter(menu -> menu.getTotalPrice() >= min && menu.getTotalPrice() <= max).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("There are no menus within the price range " + min + " - " + max);
        }
        
    }

}
