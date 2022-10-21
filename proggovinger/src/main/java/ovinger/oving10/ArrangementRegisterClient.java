package ovinger.oving10;

import static javax.swing.JOptionPane.*;

/**
 * This class is a client for the ArrangementRegister class. It uses showInputDialog
 * windows to get input from the user and then calls the appropriate methods.
 * It has basic error handling for invalid inputs.
 * 
 * It allows a user to add new events, get events by place, date or time interval,
 * and get all events sorted first by place, then type and finally date.
 * @author Ingar S. Asheim
 */
public class ArrangementRegisterClient {

    /**
     * This function runs the client loop.
     */
    public void runClient() {       
        boolean userchooses = true;
        
        while(userchooses) {
            String userChoice = showInputDialog("1) Add event " +
                                                "2) Get events at place " +
                                                "3) Get events on date " +
                                                "4) Get events in time interval " +
                                                "5) Get all events sorted ");

            try {
                int choice = Integer.parseInt(userChoice); 

                switch (choice) {
                    case 1:
                        {
                            String userSalary = showInputDialog("Ny månedslønn");
                            double salary = Double.parseDouble(userSalary);
                            // employee.setMonthlySalary(salary);
                            // System.out.println(employee.salaryAndTaxInfoToString() + '\n');
                        }
                        break;
                    case 2:
                        {
                            String userTax = showInputDialog("Ny skatteprosent");
                            double tax = Double.parseDouble(userTax);
                            // employee.setTaxRate(tax);
                            // System.out.println(employee.salaryAndTaxInfoToString() + '\n');
                        }
                        break;
                    case 3:
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
    
    
    public static void main(String[] args) {
        ArrangementRegisterClient client = new ArrangementRegisterClient();
        client.runClient();

        Arrangement arrangement = new Arrangement(1, 20201010, "Arrangement", "Oslo", "Per Hansen", "Konferanse");

        System.out.println(arrangement);
    }
    
}
