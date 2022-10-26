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

    public Menu() {
        dishes = new ArrayList<Dish>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    
    
}
