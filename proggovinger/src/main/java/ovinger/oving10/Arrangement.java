package ovinger.oving10;


/**
 * This class represents an event.
 * An event has an id, a date, a name, a place, a host and a type.
 * @author Ingar S. Asheim
 */
public final class Arrangement {
    
    /**
     * The id of the event
     */
    private int id;
    /**
     * The date of the event
     */
    private int date; //The date and time are split up because the int type can't hold the date and time in one variable
    /**
     * The time of the event
     */
    private int time; 
    /**
     * The name of the event
     */
    private String name;
    /**
     * The place where the event is held
     */
    private String place;
    /**
     * The host of the event
     */
    private String host;
    /**
     * What type of event it is
     */
    private String type;

    /**
     * The constructor takes all the parameters and initializes the fields
     * @param id The id of the event
     * @param date The date of the event
     * @param name The time of the event
     * @param name The name of the event
     * @param place The place where the event is held
     * @param host The host of the event
     * @param type What type of event it is
     */
    public Arrangement(int id, int date, int time, String name, String place, String host, String type) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.name = name;
        this.place = place;
        this.host = host;
        this.type = type;
    }

    /**
     * This function returns the id of the event.
     * 
     * @return The id of the object.
     */
    public int getId() {
        return id;
    }

    /**
     * This function returns the time the event is held.
     * 
     * @return The date of the month.
     */
    public int getDate() {
        return date;
    }

    /**
     * This function returns the time of the event
     * 
     * @return The time of the event
     */
    public int getTime() {
        return time;
    }

    /**
     * This function returns a copy of the name string.
     * 
     * @return A new String object is being returned.
     */
    public String getName() {
        return new String(name);
    }

   /**
    * This function returns a copy of the place string.
    * 
    * @return A new String object is being returned.
    */
    public String getPlace() {
        return new String(place);
    }

    /**
     * This function returns a copy of the host string.
     * 
     * @return A new String object is being returned.
     */
    public String getHost() {
        return new String(host);
    }

    /**
     * This function returns a copy of the type string.
     * 
     * @return A new String object is being returned.
     */
    public String getType() {
        return new String(type);
    }

    @Override
    public String toString() {
        return "Arrangement [id=" + id + ", date=" + date + ", time=" + time + ", name=" + name + ", place=" + place
                + ", host=" + host + ", type=" + type + "]";
    }

    
}
