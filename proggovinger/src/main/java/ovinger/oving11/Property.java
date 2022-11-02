package ovinger.oving11;

/**
 * This class represents a property.
 * A property is described with the name and number 
 * of the municipality it is located in,
 * as well as a lot number and a section number.
 * The property shall also have the name of the owner, 
 * and the area of the property.
 * It can also have the name of the property, if applicable.
 * The class allows for changing the propertys and owners name,
 * since those can change over time.
 * 
 * @author Ingar S. Asheim
 */
public class Property {
    
    private String municipalityName;
    /**
     * The property name is optional
     */
    private String propertyName;
    private String ownerName;
    /**
     * The municipality number must be in the range
     * 101-5054 inclusive
     */
    private int municipalityNumber;
    /**
     * The lot number must be positive
     */
    private int lotNumber;
    /**
     * The section number must be positive
     */
    private int sectionNumber;
    /**
     * The area must be positive
     */
    private double area;
    

    // TODO: Can we just take an empty string for the names,
    // or do we need to check for null?
    // TODO: use new String on the strings?
    /**
     * The constructor initializes the fields
     * @param municipalityName
     * @param propertyName
     * @param ownerName
     * @param municipalityNumber
     * @param lotNumber
     * @param sectionNumber
     * @param area
     */
    public Property(String municipalityName, String propertyName, String ownerName, int municipalityNumber, int lotNumber, int sectionNumber, double area) {
        this.municipalityName = municipalityName;
        this.propertyName = propertyName;
        this.ownerName = ownerName;
        this.municipalityNumber = numIsInRange(municipalityNumber, 101, 5054);
        this.lotNumber = checkConstructorArgPositive(lotNumber, "Lot number");
        this.sectionNumber = checkConstructorArgPositive(sectionNumber, "Section number");
        this.area = checkConstructorArgPositive(area, "Area");
        
    }

    /**
     * Copy constructor for Property
     * @param property 
     */
    public Property(Property property) {
        // TODO: what is this:
        // this(property.getMunicipalityName(), property.getPropertyName(), property.getOwnerName(), property.getMunicipalityNumber(), property.getLotNumber(), property.getSectionNumber(), property.getArea());
        this.municipalityName = new String(property.getMunicipalityName());
        this.propertyName = new String(property.getPropertyName());
        this.ownerName = new String(property.getOwnerName());
        this.municipalityNumber = property.getMunicipalityNumber();
        this.lotNumber = property.getLotNumber();
        this.sectionNumber = property.getSectionNumber();
        this.area = property.getArea();
    }

    /**
     * @return the municipalitys name
     */
    public String getMunicipalityName() {
        return new String(municipalityName);
    }
    
    /**
     * @return the propertys name
     */
    public String getPropertyName() {
        return new String(propertyName);
    }

    /**
     * Set the property name, in case it is changed
     * @param propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = new String(propertyName);
    }

    /**
     * @return the owners name
     */
    public String getOwnerName() {
        return new String(ownerName);
    }

    /**
     * Set the owners name, in case the property changes owner
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = new String(ownerName);
    }

    /**
     * @return the municipality number
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * @return the lot number
     */
    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * @return the section number
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    // TODO: Says "ved utskrift" in the assignment.
    // Should this be toString()?
    /**
     * @return the property id
     */
    public String getId() {
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    /**
     * Check if num is in the range [min, max]
     * @param num
     * @param min
     * @param max
     * @return num, if it is in the range
     * @throws IllegalArgumentException if num is not in the range
     */
    private int numIsInRange(int num, int min, int max) {
        if (num >= min && num <= max) {
            return num;
        }

        throw new IllegalArgumentException("Number " + num + " is not in the range [" + min + ", " + max + "]");
    }

    /**
     * Check if num is positive
     * @param num
     * @return true if num is positive
     */
    private int checkConstructorArgPositive(int num, String argName) {
        if (num <= 0) {
            throw new IllegalArgumentException(argName + " must be positive");
        }

        return num;
    }

    // TODO: Different javadoc since it's an overloaded function?
    /**
     * Check if num is positive
     * @param num
     * @return true if num is positive
     */
    private double checkConstructorArgPositive(double num, String argName) {
        if (num <= 0) {
            throw new IllegalArgumentException(argName + " must be positive");
        }

        return num;
    }

    @Override
    public String toString() {
        return "Property{" + "municipalityName=" + municipalityName + ", propertyName=" + propertyName + ", ownerName=" + ownerName + ", municipalityNumber=" + municipalityNumber + ", lotNumber=" + lotNumber + ", sectionNumber=" + sectionNumber + ", area=" + area + '}';
    }

    public static void main(String[] args) {
        
    }
}
