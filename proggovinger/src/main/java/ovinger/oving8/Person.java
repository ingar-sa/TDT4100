package ovinger.oving8;

public final class Person {
    
    private String firstname;
    private String surname;
    private int birthYear;

    public Person(String firstname, String surname, int birthYear) {
        this.firstname = firstname;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    

}
