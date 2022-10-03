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

    /**
     * This function returns the monthly tax of the employee.
     * 
     * @return The monthly tax is being returned.
     */
    public double getMonthlyTax() {
        return getMonthlySalary() * (getTaxRate() / 100);
    }

    /**
     * This function returns the gross salary per year.
     * 
     * @return The gross salary per year.
     */
    public double getGrossSalaryPerYear() {
        return getMonthlySalary() * 12;
    }

    /**
     * June is tax free and December has half tax, so the yearly tax becomes 10 times the monthly
     * tax plus half a months tax
     * 
     * @return The yearly tax for the employee.
     */
    public double getYearlyTax() {
        double decemberTax = getMonthlyTax() / 2;
        return getMonthlyTax() * 10 + decemberTax;
    }

    /**
     * This function returns a string containing the person's last name, followed by a comma, followed
     * by the person's first name.
     * 
     * @return A string with the person's last name, followed by a comma, followed by the person's
     * first name.
     */
    public String getNameLastFirst() {
        return new String(person.getSurname() + ", " + person.getFirstname());
    }

    /**
     * Get the age of a person by subtracting the birth year from the current year.
     * 
     * @return The age of the person.
     */
    public int getAge() {
        return calendar.get(java.util.Calendar.YEAR) - person.getBirthYear();
    }

    /**
     * Get the number of years employed by subtracting the year employed from the current year.
     * 
     * @return The number of years the employee has been employed.
     */
    public int getYearsEmployed() {
        return calendar.get(java.util.Calendar.YEAR) - yearEmployed;
    }

    /**
     * This function returns true if the employee has been employed longer than the number of years
     * passed in as a parameter.
     * 
     * @param years the number of years to compare against
     * @return The method is returning a boolean value.
     */
    public boolean employedLongerThan(int years) {
        return (getYearsEmployed() > years);
    }

    public String salaryAndTaxInfoToString() {
        return new String("Monthly salary: " + getMonthlySalary() + "\nYearly salary:" + getGrossSalaryPerYear() + "\nMonthly tax: " + getMonthlyTax() + "\nYearly tax: " + getYearlyTax());
    }

    @Override
    public String toString() {
        return getNameLastFirst() + " har ansatt nr. " +
        getEmployeeNr() + ", \ner " +
        getAge() + " år gammel, \nble ansatt i " +
        getYearEmployed() + ", \nhar vært ansatt i " +
        getYearsEmployed() + " år, \nhar en månedslønn på " +
        getMonthlySalary() + "kr \nog skatteprosent på " + 
        getTaxRate() + "%, \nsom gir en månedlig skatt på " +
        getMonthlyTax() + "kr \nog en årlig skatt på " +
        getYearlyTax() + "kr.";
    }

    

}
