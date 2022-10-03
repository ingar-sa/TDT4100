package ovinger.oving8;

import java.util.GregorianCalendar;

public class ArbTaker {
    
    private GregorianCalendar calendar;
    private Person person;
    private int employeeNr;
    private int yearEmployed;
    private double monthlySalary;
    private double taxRate;

    public ArbTaker(Person person, int employeeNr, int yearEmployed, double monthlySalary, double taxRate) {
        this.calendar = new GregorianCalendar();
        this.person = person;
        this.employeeNr = employeeNr;
        this.yearEmployed = yearEmployed;
        this.monthlySalary = monthlySalary;
        this.taxRate = taxRate;
    }

    public Person getPerson() {
        return person;
    }

    public int getEmployeeNr() {
        return employeeNr;
    }

    public int getYearEmployed() {
        return yearEmployed;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getMonthlyTax() {
        return getMonthlySalary() * (getTaxRate() / 100);
    }

    public double getGrossSalaryPerYear() {
        return getMonthlySalary() * 12;
    }

    public double getYearlyTax() {
        double decemberTax = getMonthlyTax() / 2;
        return getMonthlyTax() * 10 + decemberTax;
    }

    public String getNameLastFirst() {
        return new String(person.getSurname() + "," + person.getFirstname());
    }

    public int getAge() {
        return calendar.get(java.util.Calendar.YEAR) - person.getBirthYear();
    }

    public int getYearsEmployed() {
        return calendar.get(java.util.Calendar.YEAR) - yearEmployed;
    }

    public boolean employedLongerThan(int years) {
        return (getYearsEmployed() > years);
    }

}
