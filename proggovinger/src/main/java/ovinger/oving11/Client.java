package ovinger.oving11;

import static javax.swing.JOptionPane.*;

import java.util.NoSuchElementException;

/**
 * Client program for the PropertyRegistry class.
 * The client allows the user to interact with the registry.
 * The user can add properties, print all the properties in the registry,
 * search for a property and print the average area of all properties in the registry.
 */
public final class Client {

    private PropertyRegistry registry;

    /**
     * The constructor initializes the field.
     */
    public Client() {
        registry = new PropertyRegistry();
    }

    /**
     * The main loop of the program.
     * It uses showInputDialog to get user input, and
     * a switch statement to call the appropriate method.
     */
    public void runClient() {       
        boolean userchooses = true;

        while(userchooses) {

            System.out.println("1. Add property\n"
                    + "2. Print all properties\n"
                    + "3. Search for propertye\n"
                    + "4. Print average area of all properties\n"
                    + "5. Exit\n");

                    
            try {
                int choice = Integer.parseInt(showInputDialog("Enter choice: "));
            
                switch (choice) {
                    case 1:
                        addPropperty();
                        break;
                    case 2:
                        printAllProperties();
                        break;
                    case 3:
                        searchForProperty();
                        break;
                    case 4:
                        printAverageArea();
                        break;
                    case 5:
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
     * Adds a property to the registry from user input.
     * 
     */
    private void addPropperty() {
        String municipalityName = showInputDialog("Enter municipality name: ");
        String propertyName = showInputDialog("Enter property name (can be blank): ");
        String ownerName = showInputDialog("Enter owner name: ");
        int municipalityNumber = Integer.parseInt(showInputDialog("Enter municipality number: "));
        int lotNumber = Integer.parseInt(showInputDialog("Enter lot number: "));
        int sectionNumber = Integer.parseInt(showInputDialog("Enter section number: "));
        double area = Double.parseDouble(showInputDialog("Enter area: "));
        try {
            Property property = new Property(municipalityName, propertyName, ownerName, municipalityNumber, lotNumber, sectionNumber, area);
            registry.addProperty(property);
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        
    }

    /**
     * Prints all the properties in the registry.
     */
    private void printAllProperties() {
        // TODO: Use the print id method instead?
        registry.getAllProperties().stream().forEach(System.out::println);
    }

    /**
     * Searches for a property in the registry from user input.
     */
    private void searchForProperty() {
        int municipalityNumber = Integer.parseInt(showInputDialog("Enter municipality number: "));
        int lotNumber = Integer.parseInt(showInputDialog("Enter lot number: "));
        int sectionNumber = Integer.parseInt(showInputDialog("Enter section number: "));
        
        try {
            Property property = registry.getProperty(municipalityNumber, lotNumber, sectionNumber);
            System.out.println(property);
        } catch (NoSuchElementException e) {
            System.out.println("Property not found");
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        
    }

    /**
     * Prints the average area of all properties in the registry.
     */
    private void printAverageArea() {
        System.out.println(registry.getAverageAreaOfAllPropperties());
    }

    public static void main(String[] args) {
        Property prop1 = new Property("Gloppen", "", "Jens Olsen", 1445, 77, 631, 1017.6);
        Property prop2 = new Property("Gloppen", "Syningom", "Nicolay Madsen", 1445, 77, 131, 661.3);
        Property prop3 = new Property("Gloppen", "Fugletun", "Evilyn Jensen", 1445, 75, 19, 650.6);
        Property prop4 = new Property("Gloppen", "", "Karl Ove Braaten", 1445, 74, 188, 1457.2);
        Property prop5 = new Property("Gloppen", "Hoiberg", "Elsa Indregaard", 1445, 69, 47, 1339.4);

        Client client = new Client();
        client.registry.addProperty(prop1);
        client.registry.addProperty(prop2);
        client.registry.addProperty(prop3);
        client.registry.addProperty(prop4);
        client.registry.addProperty(prop5);

        client.runClient();
    }

}
