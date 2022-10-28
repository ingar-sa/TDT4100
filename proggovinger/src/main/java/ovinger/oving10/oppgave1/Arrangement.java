package ovinger.oving10.oppgave1;


/**
 * @author Ingar S. Asheim
 * 
 * This class represents an event.
 * An event has an id, a date, a time, a name, a place, a host and a type.
 */
public class Arrangement {
    
    private int id;
    private int date; //The date and time are split up because the int type can't hold the date and time in one variable
    private int time; 
    private String name;
    private String place;
    private String host;
    private String type;

    //TODO: Should you add types to this params?
    /**
     * The constructor takes all the parameters and initializes the fields
     * @param id 
     * @param date
     * @param name
     * @param name
     * @param place
     * @param host
     * @param type
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
     * This constructor makes a deep copy of the 
     * Arrangement object passed as an argument
     * @param arrangement
     */
    public Arrangement(Arrangement arrangement) {
        this.id = arrangement.id;
        this.date = arrangement.date;
        this.time = arrangement.time;
        this.name = new String(arrangement.name);
        this.place = new String(arrangement.place);
        this.host = new String(arrangement.host);
        this.type = new String(arrangement.type);
    }

    //TODO: How should javadoc for getters and setters be written
    /**
     * @return The id of the object.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The date of of the event
     */
    public int getDate() {
        return date;
    }

    /**
     * @return The time of the event
     */
    public int getTime() {
        return time;
    }

    /**
     * @return A new String object is being returned.
     */
    public String getName() {
        return new String(name);
    }

   /**
    * @return A new String object is being returned.
    */
    public String getPlace() {
        return new String(place);
    }

    /** 
     * @return A new String object is being returned.
     */
    public String getHost() {
        return new String(host);
    }

    /**
     * @return A new String object is being returned.
     */
    
     //TODO: Change to enum
    public String getType() {
        return new String(type);
    }

    /**
     * @return A String representation of the object.
     */
    @Override
    public String toString() {
        return "Arrangement [id=" + id + ", date=" + date + ", time=" + time + ", name=" + name + ", place=" + place
                + ", host=" + host + ", type=" + type + "]";
    }
}
