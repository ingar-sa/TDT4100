package ovinger.oving11;

import java.util.ArrayList;

/**
 * This class represents a registry of properties.
 * It has methos for adding and removing properties,
 * returning the number of properties in the registry,
 * and returning a property by its id (municipality number-lot number/section number).
 * 
 * It uses an ArrayList to store the properties. We can then use
 * streams, which allows us to write succinct and readable code.
 * Using a fixed size array would require us to write code for methods
 * that are already implemented in the Java language.
 */
public class PropertyRegistry {
    
    private ArrayList<Property> properties;

    /**
     * The constructor initializes the field
     * @param properties The list of properties in the registry
     */
    public PropertyRegistry() {
        properties = new ArrayList<>();
    }

    /**
     * The constructor initializes the field
     * @param properties The list of properties in the registry
     */
    public PropertyRegistry(ArrayList<Property> properties) {
        this.properties = new ArrayList<>(properties);
        properties.stream().forEach(prop -> properties.add(new Property(prop)));
    }

    /**
     * Adds a property to the registry
     * @param property The property to add
     */
    public void addProperty(Property property) {
        properties.add(new Property(property));
    }

    /**
     * Removes a property from the registry
     * @param property The property to remove
     * @throws NoSuchElementException if the registry does not contain the property
     */
    public void removeProperty(Property property) {
        // TODO: Should we explicitly throw the exception, even if
        // it says it throws the exception in the javadoc?
        properties.remove(property);
    }

    /**
     * Returns the number of properties in the registry
     * @return The number of properties in the registry
     */
    public int getNumberOfProperties() {
        return properties.size();
    }

    /**
     * Returns the property with the given id
     * @param id The id of the property to return
     * @return The property with the given id
     * @throws NoSuchElementException if the registry does not contain a property with the given id
     */
    public Property getProperty(String id) {
        return properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().get();
    }

}
