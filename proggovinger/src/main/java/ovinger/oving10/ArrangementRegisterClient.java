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
            int time = Integer.parseInt(eventInfoArray[2]);
            String name = eventInfoArray[3];
            String place = eventInfoArray[4];
            String host = eventInfoArray[5];
            String type = eventInfoArray[6];

            arrangementRegister.addArrangement(id, date, time, name, place, host, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
    
    private void printAllEventsSorted() {
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
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start date and time separated by spaces");
        String startInfo = in.nextLine();
        System.out.println("Enter end date and time separated by spaces");
        String endInfo = in.nextLine();
        in.close();
        String[] startInfoArray = startInfo.split(" ");
        String[] endInfoArray = endInfo.split(" ");

        if (startInfoArray.length != 2 || endInfoArray.length != 2) {
            System.err.println("Wrong number of arguments");
            throw new IllegalArgumentException();
        }

        try {
            int startDate = Integer.parseInt(startInfoArray[0]);
            int startTime = Integer.parseInt(startInfoArray[1]);
            int endDate = Integer.parseInt(endInfoArray[0]);
            int endTime = Integer.parseInt(endInfoArray[1]);

            ArrayList<Arrangement> events = arrangementRegister.getArrangementInTimeInterval(startDate, startTime, endDate, endTime);

            for (Arrangement arrangement : events) {
                System.out.println(arrangement);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }
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
