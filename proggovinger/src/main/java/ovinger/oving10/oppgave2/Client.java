package ovinger.oving10.oppgave2;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A client program for the MenuRegistry class
 * that allows the user to interact with the registry.
 * 
 * @author Ingar S. Asheim
 */
public final class Client {

    private MenuRegistry registry;

    /**
     * The constructor initializes the field
     */
    public Client() {
        registry = new MenuRegistry();
    }

    /**
     * The main loop of the program.
     * Uses a switch statement to call the appropriate method
     * from the user input
     */
    public void runClient() {       
        boolean userchooses = true;

        while(userchooses) {

            System.out.println("1. Add Dish\n"
                    + "2. Get a dishby name\n"
                    + "3. Get all dishes of type\n"
                    + "4. Add a new menu\n"
                    + "5. Get all menus in a price range\n"
                    + "6. Exit\n");

                    
            try {
                int choice = Integer.parseInt(showInputDialog("Enter choice: "));
            
                switch (choice) {
                    case 1:
                        addDish();
                        break;
                    case 2:
                        printDishByName();
                        break;
                    case 3:
                        printDishesOfType();
                        break;
                    case 4:
                        addMenu();
                        break;
                    case 5:
                        printMenusInPriceRange();
                        break;
                    case 6:
                        userchooses = false;
                        break;
                    default:
                        System.out.println("Illegal choice");
                        break;
                }
    
            } catch (Exception e) {
                System.out.println("Illegal choice");
            }
          
        }

    }

    /**
     * This method adds a new dish to the registry.
     * It uses showInputDialog windows to get input from the user.
     */
    private void addDish() {
        String name = showInputDialog("Enter name: ");
        String type = showInputDialog("Enter type: ");
        double price = Double.parseDouble(showInputDialog("Enter price: "));
        String recipe = showInputDialog("Enter recipe: ");

        registry.addDish(new Dish(name, price, type, recipe));
    }

    /**
     * This method prints a dish with a given name.
     * It uses showInputDialog windows to get input from the user.
     */
    private void printDishByName() {
        String name = showInputDialog("Enter name: ");
        try {
            Dish dish = registry.getDishByName(name);
            System.out.println(dish);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Dish not found");
        }
    }

    /**
     * This method prints all dishes of a given type.
     * It uses showInputDialog windows to get input from the user.
     */
    private void printDishesOfType() {
        String type = showInputDialog("Enter type: ");
        try {
            registry.getDishesByType(type).stream().forEach(System.out::println);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Dishes of type " + type + " not found");
        }
    }

    /**
     * This method adds a new menu to the registry.
     * It uses showInputDialog windows to get input from the user.
     */
    private void addMenu() {
        boolean userchooses = true;
        ArrayList<String> dishNames = new ArrayList<String>();
        System.out.println("At least two dishes must be added to the menu");

        while (userchooses) {
            String name = showInputDialog("Enter the name of the dish, 1 when you are finished entering the dishes or 0 to exit): ");
            if (name.equals("0")) {
                System.out.println("Exiting. No menu created");
                return;
            } else if (name.equals("1")) {
                userchooses = false;
            } else {
                dishNames.add(name);
            }
        }

        try {
            registry.addMenu(dishNames);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("A menu must have at least two dishes");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("One or more of the dishes does not exist");
        }
        //TODO: Handle general exceptions as well?
    }

    /**
     * This method prints all menus in a given price range
     * It uses showInputDialog windows to get input from the user.
     */
    private void printMenusInPriceRange() {
        try {
            double min = Double.parseDouble(showInputDialog("Enter min price: "));
            double max = Double.parseDouble(showInputDialog("Enter max price: "));    
            registry.getMenusInPriceRange(min, max).stream().forEach(menu -> menu.printMenu());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Min price must be greater than or equal to 0 and less than max price");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("No menus in the price range");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Illegal input");
        }
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        client.registry.addDish(new Dish("Pasta", 100, "Main", "Cook pasta"));
        client.registry.addDish(new Dish("Tagliateelle", 120, "Main", "Cook pasta"));
        client.registry.addDish(new Dish("Macaroni", 100, "Main", "Cook pasta"));
        client.registry.addDish(new Dish("Pastrami", 50, "Appetizer", "Cook pasta"));
        client.registry.addDish(new Dish("Salad", 200, "Appetizer", "Cut vegetables"));
        client.registry.addDish(new Dish("Icecream", 25, "Dessert", "Freeze milk"));
        client.runClient();
        
        // Test code
        
    }
}
