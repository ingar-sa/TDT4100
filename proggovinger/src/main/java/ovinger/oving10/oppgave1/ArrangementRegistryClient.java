package ovinger.oving10.oppgave1;

import java.util.ArrayList;
import java.util.HashMap;
import static javax.swing.JOptionPane.*;

/**
 * This class is a client for the ArrangementRegister class. It uses showInputDialog
 * windows to get input from the user and then calls the appropriate methods.
 * It has basic error handling for invalid inputs.
 * 
 * It allows a user to add new events, get events by place, date or time interval,
 * and get all events sorted first by place, then type and finally date.
 * 
 * @author Ingar S. Asheim
 */
public final class ArrangementRegistryClient {

    private ArrangementRegistry arrangementRegistry;

    /**
     * The constructor takes no argumetns and initializes the fields
     */
    ArrangementRegistryClient() {
        arrangementRegistry = new ArrangementRegistry();
    }

    /**
     * This function is the main loop of the program. It displays a menu and
     * calls the appropriate functions based on the users input.
     */
    public void runClient() {       
        boolean userchooses = true;

        while(userchooses) {

            System.out.println("1. Legg til arrangement\n"
                    + "2. Hent arrangementer på sted\n"
                    + "3. Hent arrangementer på dato\n"
                    + "4. Hent arrangementer i tidsrom\n"
                    + "5. Hent alle arrangementer sortert\n"
                    + "6. Avslutt\n"); 

            try {
                int choice = Integer.parseInt(showInputDialog("Enter choice: "));
            
                switch (choice) {
                    case 1:
                        addEvent();
                        break;
                    case 2:
                        printEventsAtPlace();
                        break;
                    case 3:
                        printEventsOnDate();
                        break;
                    case 4:
                        printEventsInTimeInterval();
                        break;
                    case 5:
                        printAllEventsSorted();
                        break;
                    case 6:
                        userchooses = false;
                        break;
                    default:
                        System.out.println("Ulovlig valg");
                        break;
                }
    
            } catch (Exception e) {
                System.out.println("Ulovlig valg");
            }
        }
    }

    /**
     * This function adds a new event to the register
     */
    private void addEventDebug(Arrangement arrangement) {
        arrangementRegistry.addArrangement(arrangement);
    }
    
    /**
     * This function adds a new event to the register
     */
    private void addEvent() throws IllegalArgumentException {
        String input = showInputDialog("Enter id, date, time, name, place, host and type separated by spaces");
        String[] eventInfoArray = input.split(" ");

        if (eventInfoArray.length != 7) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        try {
            int id = Integer.parseInt(eventInfoArray[0]);
            int date = Integer.parseInt(eventInfoArray[1]);
            int time = Integer.parseInt(eventInfoArray[2]);
            String name = eventInfoArray[3];
            String place = eventInfoArray[4];
            String host = eventInfoArray[5];
            String type = eventInfoArray[6];

            arrangementRegistry.addArrangement(id, date, time, name, place, host, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
    
    /**
     * This function prints events sorted, first by place, then type and finally date and time
     */
    // private void printAllEventsSorted() {
    //     HashMap<String, HashMap<String, ArrayList<Arrangement>>> sortedEvents = arrangementRegistry.getAllArrangementSorted();

    //     for (String place : sortedEvents.keySet()) {
    //         System.out.println(place);
    //         for (String type : sortedEvents.get(place).keySet()) {
    //             System.out.println("\t" + type);
    //             for (Arrangement arrangement : sortedEvents.get(place).get(type)) {
    //                 System.out.println("\t\t" + arrangement);
    //             }
    //         }
    //     }
    // }

    /**
     * This function prints events sorted, first by place, then type and finally date and time
     */
    private void printAllEventsSorted() {
        arrangementRegistry.getAllEventsSorted().stream().forEach(System.out::println);
    }

    /**
     * This function prints all the events in a time interval
     */
    private void printEventsInTimeInterval() {        
        String startInfo = showInputDialog("Enter start date and time separated by space");
        String endInfo = showInputDialog("Enter end date and time separated by space");
        String[] startInfoArray = startInfo.split(" ");
        String[] endInfoArray = endInfo.split(" ");

        if (startInfoArray.length != 2 || endInfoArray.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        try {
            int startDate = Integer.parseInt(startInfoArray[0]);
            int startTime = Integer.parseInt(startInfoArray[1]);
            int endDate = Integer.parseInt(endInfoArray[0]);
            int endTime = Integer.parseInt(endInfoArray[1]);

            arrangementRegistry.getArrangementBetweenTimes(startDate, startTime, endDate, endTime).stream().forEach((arrangement) -> {
                System.out.println(arrangement);
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    /**
     * This function prints all the events on a given date
     */
    private void printEventsOnDate() {
        String date = showInputDialog("Enter date");

        try {
            int dateInt = Integer.parseInt(date);

            arrangementRegistry.getArrangementOnDate(dateInt).stream().forEach(arrangement -> {
                System.out.println(arrangement);
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    /**
     * This function prints all the events at a given place
     */
    private void printEventsAtPlace() {
        String place = showInputDialog("Enter place");

        ArrayList<Arrangement> events = arrangementRegistry.getArrangementerAtPlace(place);

        for (Arrangement arrangement : events) {
            System.out.println(arrangement);
        }
    }

    public static void main(String[] args) {
        ArrangementRegistryClient client = new ArrangementRegistryClient();

        // Add many Arrangement for testing
        client.addEventDebug(new Arrangement(1, 20150101, 1800, "Arrangement1", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(2, 20150101, 2000, "Arrangement2", "Oslo", "Ingar", "Konferanse")); 
        client.addEventDebug(new Arrangement(3, 20150102, 2000, "Arrangement3", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(4, 20150102, 2000, "Arrangement4", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(5, 20150103, 1900, "Arrangement5", "Oslo", "Ingar", "Konferanse"));

        // 6 20221025 1600 Foo Kube95 Ingar Progging
        // 7 20221025 2100 Foo Kube95 Ingar YouTube-seeing
        // 8 20221025 2100 Foo Kube95 Ingar Tidsparadoks
        // 9 20221025 1800 Sabaton Oslo OsloSpektrum Konsert

        client.runClient();
        
    }
    
}
