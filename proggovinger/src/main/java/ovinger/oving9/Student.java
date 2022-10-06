package ovinger.oving9;

public class Student {
    
    private String name;
    private int numberExercises;


    //TODO: Add javadoc
    public Student(String name, int numberExercises) {
        this.name = name;
        this.numberExercises = numberExercises;
    }

    /**
     * This function returns the name of the person.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

   /**
    * This function returns the number of exercises in the course
    * 
    * @return The number of exercises in the course.
    */
    public int getNumberExercises() {
        return numberExercises;
    }

    /**
     * This function increases the number of exercises by the number passed in as a parameter.
     * 
     * @param number The number of exercises to increase the number of exercises by.
     */
    public void increaseNumberExercises(int number) {
        numberExercises += number;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", numberExercises=" + numberExercises + "]";
    }

    /**
     * The function `toString()` is a function that is called when you try to print an object
     * 
     * @return The name of the student and the number of exercises they have done.
     */
    // @Override
    // public String toString() {
    //     return "Student: " + name + " har gjort " + numberExercises + " øvinger";
    // }

    
}
