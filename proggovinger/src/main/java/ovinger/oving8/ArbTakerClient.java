package ovinger.oving8;

import static javax.swing.JOptionPane.*;

public class ArbTakerClient {
    
    private ArbTaker employee;

    public ArbTakerClient(ArbTaker employee) {
        this.employee = employee;
    }

    /**
     * The function asks the user to choose between three options, and then executes the chosen option
     */
    public void arbTakerClient() {
        boolean userchooses = true;
        
        while(userchooses) {
            String userChoice = showInputDialog("1) Endre månedslønn 2) Endre skatteprosent 3) exit");
            try {
                int choice = Integer.parseInt(userChoice); 

                switch (choice) {
                    case 1:
                        {
                            String userSalary = showInputDialog("Ny månedslønn");
                            double salary = Double.parseDouble(userSalary);
                            employee.setMonthlySalary(salary);
                            System.out.println(employee.salaryAndTaxInfoToString() + '\n');
                        }
                        break;
                    case 2:
                        {
                            String userTax = showInputDialog("Ny skatteprosent");
                            double tax = Double.parseDouble(userTax);
                            employee.setTaxRate(tax);
                            System.out.println(employee.salaryAndTaxInfoToString() + '\n');
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
        
        Person person = new Person("Foo", "Bar", 1972);
        ArbTaker employee = new ArbTaker(person, 
                                        1, 
                                        1989, 
                                        50000.0, 
                                        42.0);


        System.out.println(employee.toString());
        System.out.println("Skal være sant: " + employee.employedLongerThan(20));
        System.out.println("Skal være usant: " + employee.employedLongerThan(100));

        ArbTakerClient client = new ArbTakerClient(employee);
        client.arbTakerClient();

    }

    
}
