package ovinger.oving11;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// TODO: Does it make sense to use aggregation here instead of composition?
// The properties are going to be there even though the registry does not exist.
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
     * The constructor initializes the field.
     */
    public PropertyRegistry() {
        properties = new ArrayList<>();
    }

    /**
     * The constructor initializes the field.
     * @param properties The list of properties to initialize the registry with.
     */
    public PropertyRegistry(ArrayList<Property> properties) {
        this.properties = new ArrayList<>(properties);
        properties.stream().forEach(prop -> properties.add(new Property(prop)));
    }

    // TODO: Is the description unnecessary, could we just have the param?
    /**
     * Adds a property to the registry.
     * @param property The property to add.
     */
    public void addProperty(Property property) {
        properties.add(new Property(property));
    }

    // TODO: Is the description unnecessary, could we just have the param?
    /**
     * Removes a property from the registry.
     * @param property Id of the property to remove
     * @throws NoSuchElementException if the registry does not contain the property.
     */
    public void removeProperty(String id) {
        if (!properties.remove(getProperty(id))) {
            throw new NoSuchElementException("The property does not exist");
        }
    }

    /**
     * @return The number of properties in the registry.
     */
    public int getNumberOfProperties() {
        return properties.size();
    }

    /**
     * Returns the property with the given id.
     * @param id The id of the property.
     * @return The property with the given id.
     * @throws NoSuchElementException if the registry does not contain a property with the given id.
     */
    public Property getProperty(String id) {
        // Property property = properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().get();
        // return new Property(property);
        // TODO: throw exception explicitly?
        return new Property(properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().get());
    }

    /**
     * Returns the property with the id made from the parameters.
     * @param municipalityNumber
     * @param lotNumber
     * @param sectionNumber
     * @return the property with the given id.
     * @throws NoSuchElementException if the registry does not contain a property with the given id.
     */
    public Property getProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
        // TODO: throw exception explicitly?
        String id = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        return getProperty(id);
    }
    
    /**
     * Returns the average area of all the registered properties.
     * @return the average area.
     */
    public double getAverageAreaOfAllPropperties() {
        return properties.stream().mapToDouble(prop -> prop.getArea()).average().getAsDouble();
    }

    /**
     * Returns all properties on the given lot.
     * @param lotNumber
     * @return all properties on the given lot.
     * @throws NoSuchElementException if the registry does not contain any properties on the given lot.
     */
    // TODO: Throw exception explicitly?
    public ArrayList<Property> getPropertiesOnLot(int lotNumber) {
        ArrayList<Property> propertiesOnLot = new ArrayList<>();
        properties.stream().filter(prop -> prop.getLotNumber() == lotNumber).forEach(prop -> propertiesOnLot.add(new Property(prop)));
        return propertiesOnLot;
    }

    /**
     * @return list with all the properties in the registry.
     */
    public ArrayList<Property> getAllProperties() {
        ArrayList<Property> allProperties = new ArrayList<>();
        properties.stream().forEach(prop -> allProperties.add(new Property(prop)));
        return allProperties;
    }
}
