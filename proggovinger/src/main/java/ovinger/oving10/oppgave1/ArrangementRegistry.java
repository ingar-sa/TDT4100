package ovinger.oving10.oppgave1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a registry of events, represented by Arrangement objects.
 * It allows you to add new events, get events by place, date or time interval,
 * and get all events sorted first by place, then type and finally date
 * 
 * @author Ingar S. Asheim
 */
public final class ArrangementRegistry {
    /**
     * The ArrayList containing all the Arrangement object
     */
    private ArrayList<Arrangement> arrangementer;

    /**
     * The constructor takes no arguments and initializes the list of
     * Arrangement objects
     */
    public ArrangementRegistry() {
        arrangementer = new ArrayList<Arrangement>();
    }

    /**
     * This function adds a new event to the register
     * @param arrangement The event to add
     */
    public void addArrangement(Arrangement arrangement) {
        arrangementer.add(arrangement);
    }

    /**
     * > This function creates a new Arrangement object 
     * and adds it to the register
     *
     * @param id The id of the event
     * @param date The date of the event
     * @param name The name of the event
     * @param place The place where the event is held
     * @param host The host of the event
     * @param type What type of event it is
     */
    public void addArrangement(int id, int date, int time, String name, String place, String host, String type) {
        arrangementer.add(new Arrangement(id, date, time, name, place, host, type));
    }

    /**
     * > This function returns an ArrayList of Arrangement objects that are located at the place
     * specified by the parameter.
     * 
     * @param place The place you want to get the events from
     * @return A list of all the events at a given place
     */
     //TODO: Heller utløse et NoSuchElementException?
    public ArrayList<Arrangement> getArrangementerAtPlace(String place) {
        return arrangementer.stream().filter(arrangement -> arrangement.getPlace().equals(place))
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                        
    }

    /**
     * > This function returns an ArrayList of Arrangement objects that are on the same date as the
     * date parameter. The list is not sorted. 
     * 
     * @param date The date you want to get events for
     * @return A list of the events on that date
     */
    //TODO: Skrive typer for input og returverdi i javadoc?
    public ArrayList<Arrangement> getArrangementOnDate(int date) {
        return arrangementer.stream().filter(arrangement -> arrangement.getDate() == date)
                            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

   /**
    * > This function returns an ArrayList of Arrangement objects that are 
    * between two points in time.
    * @param date1 The start date
    * @param time1 The start time
    * @param date2 The end date
    * @param time2 The end time
    * @return A list of all the arrangements between the two dates sorted by time
    */
    public ArrayList<Arrangement> getArrangementBetweenTimes(int date1, int time1, int date2, int time2) {
        int date1And2 = date2 - date1;
        int time1And2 = time2 - time1;
        ArrayList<Arrangement> arrangementerBetweenTimes = new ArrayList<Arrangement>();
        
        if (date1And2 > 0 || (date1And2 == 0 && time1And2 > 0)) {
            arrangementer.stream().filter(arrangement -> arrangement.getDate() - date1 >= 0 && arrangement.getDate() - date2 <= 0)
                            .filter(arrangement -> arrangement.getTime() - time1 >= 0 && arrangement.getTime() - time2 <= 0)
                            .forEach(arrangement -> arrangementerBetweenTimes.add(arrangement));
        }              
        else {
            throw new IllegalArgumentException("The first date and time must be before the second date and time");
        }

        arrangementerBetweenTimes.stream().sorted((arr1, arr2) -> {
            if (arr1.getDate() - arr2.getDate() == 0) {
                return arr1.getTime() - arr2.getTime();
            }
            else {
                return arr1.getDate() - arr2.getDate();
            }
        });

        return new ArrayList<>(arrangementerBetweenTimes);
    }

    
    /**
     * Returns a HashMap of all events sorted, first by place,
     * then by type, and then by time.
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
                    arrangementerOfType.sort((arrangement1, arrangement2) -> {
                        int compareDates = arrangement1.getDate() - arrangement2.getDate();
                        if (compareDates == 0) {
                            return arrangement1.getTime() - arrangement2.getTime();
                        } else {
                            return compareDates;
                        }
                    });
                }
                // Else create a new list for events of this type
                else {

                    ArrayList<Arrangement> arrangementerOfType = new ArrayList<Arrangement>();
                    arrangementerOfType.add(arrangement);
                    arrangementerAtPlace.put(arrangement.getType(), arrangementerOfType);
                }
            }
            // Else create a new map for events at this place, and then put a list with *arrangement* in the new map
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

    

    //TODO: Be om godkjenning fra Trym
    
}
