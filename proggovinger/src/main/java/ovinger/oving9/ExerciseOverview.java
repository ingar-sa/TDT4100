package ovinger.oving9;

import java.util.ArrayList;

public class ExerciseOverview {

    private ArrayList<Student> students;
    private int numberOfStudents;
    
    ExerciseOverview(){
        students = new ArrayList<>();
        numberOfStudents = 0;
    }

    /**
     * This function returns the number of students in the class
     * 
     * @return The number of students in the class.
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * This function adds a student to the students arraylist.
     * 
     * @param name The name of the student
     * @param numberExcersises The number of exercises the student has to do.
     */
    public void addStudent(String name, int numberExcersises) {
        //Creating the student in the register class is called composition
        //If it were made in the client program, it would be adjunction
        //since the register and the student object are independent of eachother
        students.add(new Student(name, numberExcersises));
        numberOfStudents++;
    }

    /**
     * For each student in the students list, if the student's name is equal to the name parameter,
     * increase the student's number of exercises by the number parameter.
     * 
     * @param name the name of the student
     * @param number the number of exercises to increase
     */
    public void increaseNumberExercises(String name, int number) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                student.increaseNumberExercises(number);
            }
        }
    }
    
   /**
    * "Find the number of exercises completed by a student with a given name."
    * 
    * The function takes a single parameter, a String called name. It returns an int
    * 
    * @param name the name of the student
    * @return The number of exercises completed by the student.
    */
    public int findCompletedExercises(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getNumberExercises();
            }
        }
        return -1;
    }

    /**
     * For each student in the students array, add the student's toString() to the result string.
     * 
     * @return The toString method is being returned.
     */
    //Change name
    public String toString() {
        String result = "";
        for (Student student : students) {
            result += student.toString() + "\n";
        }

        return result;
    }

    //Add tostring

}
