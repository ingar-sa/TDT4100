package ovinger.oving8;

public class ArbTakerClient {
    
    private ArbTaker employee;

    public ArbTakerClient(ArbTaker employee) {
        this.employee = employee;
    }


    public static void main(String[] args) {
        
        Person person = new Person("Foo", "Bar", 1972);
        ArbTaker employee = new ArbTaker(person, 
                                        1, 
                                        1989, 
                                        50000.0, 
                                        42.0);

        System.out.println(employee.getNameLastFirst() + " har ansatt nr. " +
                            employee.getEmployeeNr() + ", \ner " +
                            employee.getAge() + " år gammel, \nble ansatt i " +
                            employee.getYearEmployed() + ", \nhar vært ansatt i " +
                            employee.getYearsEmployed() + " år, \nhar en månedslønn på " +
                            employee.getMonthlySalary() + "kr \nog skatteprosent på " + 
                            employee.getTaxRate() + "%, \nsom gir en månedlig skatt på " +
                            employee.getMonthlyTax() + "kr \nog en årlig skatt på " +
                            employee.getYearlyTax() + "kr.");
        
        System.out.println("Skal være sant: " + employee.employedLongerThan(20));
        System.out.println("Skal være usant: " + employee.employedLongerThan(100));

    }

    
}
