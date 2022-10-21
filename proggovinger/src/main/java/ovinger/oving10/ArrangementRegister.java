package ovinger.oving10;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a register of events, represented by Arrangement objects.
 * It allows you to add new events, get events by place, date or time interval,
 * and get all events sorted first by place, then type and finally date
 * 
 * @author Ingar S. Asheim
 */
public class ArrangementRegister {
    
    /**
     * The ArrayList containing all the Arrangement object
     */
    private ArrayList<Arrangement> arrangementer;

    /**
     * The constructor takes no arguments and initializes the list of
     * Arrangement objects
     */
    public ArrangementRegister() {
        arrangementer = new ArrayList<Arrangement>();
    }

    /**
     * > This function adds an Arrangement object to arrangementer
     *
     * @param id The id of the event
     * @param date The date of the event
     * @param name The name of the event
     * @param place The place where the event is held
     * @param host The host of the event
     * @param type What type of event it is
     */
    public void addArrangement(int id, int date, String name, String place, String host, String type) {
        arrangementer.add(new Arrangement(id, date, name, place, host, type));
    }

    /**
     * > This function returns an ArrayList of Arrangement objects that are located at the place
     * specified by the parameter
     * 
     * @param place The place you want to get the events from
     * @return A list of all the events at a given place
     */
    public ArrayList<Arrangement> getArrangementerAtPlace(String place) {
        ArrayList<Arrangement> arrangementerAtPlace = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getPlace().equals(place))
                        .forEach(arrangement -> arrangementerAtPlace.add(arrangement));
        
        return new ArrayList<>(arrangementerAtPlace);
    }

    /**
     * > This function returns an ArrayList of Arrangement objects that are on the same date as the
     * date parameter. The list is not sorted
     * 
     * @param date The date you want to get the arrangements for
     * @return An ArrayList of Arrangement objects
     */
    public ArrayList<Arrangement> getArrangementOnDate(int date) {
        int intervalForSameDate = 2359;
        ArrayList<Arrangement> arrangementerOnDate = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getDate() - date >= -intervalForSameDate && arrangement.getDate() - date <= intervalForSameDate)
                        .forEach(arrangement -> arrangementerOnDate.add(arrangement));
        
        return new ArrayList<>(arrangementerOnDate);
    }

   /**
    * > This function returns an ArrayList of Arrangement objects that are between two dates.
    *   The dates do not have to be passed in any particular order. The function finds the
    *   order of the dates
    * 
    * @param date1 The first date to compare
    * @param date2 The other date to compare
    * @return A list of all the arrangements between the two dates.
    */
    public ArrayList<Arrangement> getArrangementBetweenDates(int date1, int date2) {
        int laterDate = (date1 > date2) ? date1 : date2;
        int earlierDate = (date1 < date2) ? date1 : date2;

        ArrayList<Arrangement> arrangementerBetweenDates = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getDate() >= earlierDate && arrangement.getDate() <= laterDate)
                        .forEach(arrangement -> arrangementerBetweenDates.add(arrangement));
        
        arrangementerBetweenDates.sort((arrangement1, arrangement2) -> arrangement1.getDate() - arrangement2.getDate());
        return new ArrayList<>(arrangementerBetweenDates);
    }

    
    /**
     * Sorts the list of Arrangement objects (arrangementer) first by place,
     * then by type, and then by time
     * 
     * @return A HashMap of HashMaps of ArrayLists of Arrangement objects
     */
    public HashMap<String, HashMap<String, ArrayList<Arrangement>>> getAllArrangementSorted() {

        // HashMap<Event place, HashMap<Event type, ArrayList<Events sorted by time>>>
        HashMap<String, HashMap<String, ArrayList<Arrangement>>> mapByPlace = new HashMap<String, HashMap<String, ArrayList<Arrangement>>>();

        arrangementer.stream().forEach(arrangement -> {

            // If mapByPlace contains events at this place, we have to sort by type
            if (mapByPlace.containsKey(arrangement.getPlace())) {

                HashMap<String, ArrayList<Arrangement>> arrangementerAtPlace = mapByPlace.get(arrangement.getPlace());

                // If arrangementerAtPlace contains events of this type, we have to sort by time
                if (arrangementerAtPlace.containsKey(arrangement.getType())) {

                    ArrayList<Arrangement> arrangementerOfType = arrangementerAtPlace.get(arrangement.getType());
                    arrangementerOfType.add(arrangement);
                    arrangementerOfType.sort((arrangement1, arrangement2) -> arrangement1.getDate() - arrangement2.getDate());
                }
                // Else create a new list for events of this type
                else {

                    ArrayList<Arrangement> arrangementerOfType = new ArrayList<Arrangement>();
                    arrangementerOfType.add(arrangement);
                    arrangementerAtPlace.put(arrangement.getType(), arrangementerOfType);
                }
            }
            // Else create a new map for events of this type, and then put a list with *arrangement* in it
            else {
                
                HashMap<String, ArrayList<Arrangement>> mapForEventType = new HashMap<String, ArrayList<Arrangement>>();
                ArrayList<Arrangement> listByEventTime = new ArrayList<Arrangement>(); 

                listByEventTime.add(arrangement);
                mapForEventType.put(arrangement.getType(), listByEventTime);
                mapByPlace.put(arrangement.getPlace(), mapForEventType);
            }
        });

        return new HashMap<>(mapByPlace);
    } 
    
}
