package ovinger.oving10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Ingar S. Asheim
 * 
 * This class is a client for the ArrangementRegister class. It uses showInputDialog
 * windows to get input from the user and then calls the appropriate methods.
 * It has basic error handling for invalid inputs.
 * 
 * It allows a user to add new events, get events by place, date or time interval,
 * and get all events sorted first by place, then type and finally date.
 */
public class ArrangementRegisterClient {

    private ArrangementRegister arrangementRegister;

    ArrangementRegisterClient() {
        arrangementRegister = new ArrangementRegister();
    }

    /**
     * This function runs the client loop.
     */
    public void runClient() {       
        boolean userchooses = true;
        Scanner in = new Scanner(System.in);

        while(userchooses) {
            System.out.println( 
                "1) Add event\n" +
                "2) Get events at place\n" +
                "3) Get events on date\n" +
                "4) Get events in time interval\n" +
                "5) Get all events sorted\n" +
                "6) Quit\n");
             
            String userChoice = in.nextLine();
            System.out.println(userChoice);

            try {
                int choice = Integer.parseInt(userChoice); 

                switch (choice) {
                    case 1:
                        addEvent();
                        break;
                    case 2:
                        getEventsAtPlace();
                        break;
                    case 3:
                        getEventsOnDate();
                        break;
                    case 4:
                        getEventsInTimeInterval();
                        break;
                    case 5:
                        getAllEventsSorted();
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

        in.close();
    }

    private void addEventDebug(Arrangement arrangement) {
        arrangementRegister.addArrangement(arrangement);
    }
    
    private void addEvent() throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id, date, name, place, host and type separated by spaces");
        String eventInfo = in.nextLine();
        in.close();
        String[] eventInfoArray = eventInfo.split(" ");

        if (eventInfoArray.length != 6) {
            System.err.println("Wrong number of arguments");
            throw new IllegalArgumentException();
        }

        try {
            int id = Integer.parseInt(eventInfoArray[0]);
            int date = Integer.parseInt(eventInfoArray[1]);
            String name = eventInfoArray[2];
            String place = eventInfoArray[3];
            String host = eventInfoArray[4];
            String type = eventInfoArray[5];

            arrangementRegister.addArrangement(id, date, name, place, host, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
    
    private void getAllEventsSorted() {
        HashMap<String, HashMap<String, ArrayList<Arrangement>>> sortedEvents = arrangementRegister.getAllArrangementSorted();

        for (String place : sortedEvents.keySet()) {
            System.out.println(place);
            for (String type : sortedEvents.get(place).keySet()) {
                System.out.println("\t" + type);
                for (Arrangement arrangement : sortedEvents.get(place).get(type)) {
                    System.out.println("\t\t" + arrangement);
                }
            }
        }
    }

    private void getEventsInTimeInterval() {
    }

    private void getEventsOnDate() {
    }

    private void getEventsAtPlace() {
    }

    

    public static void main(String[] args) {
        ArrangementRegisterClient client = new ArrangementRegisterClient();
        client.runClient();

        // Add many Arrangement for testing
        client.addEventDebug(new Arrangement(1, 201501011800, "Arrangement1", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(2, 20150101, "Arrangement2", "Oslo", "Ingar", "Konferanse")); 
        client.addEventDebug(new Arrangement(3, 20150101, "Arrangement3", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(4, 20150101, "Arrangement4", "Oslo", "Ingar", "Konferanse"));
        client.addEventDebug(new Arrangement(5, 20150101, "Arrangement5", "Oslo", "Ingar", "Konferanse"));


        System.out.println(arrangement);
    }
    
}
