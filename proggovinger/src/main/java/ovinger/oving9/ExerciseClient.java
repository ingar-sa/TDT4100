package ovinger.oving9;

public class ExerciseClient {
    
    public static void main(String[] args) {
        ExerciseOverview overview = new ExerciseOverview();

        overview.addStudent("Per Hansen", 0);
        overview.addStudent("Ole Olsen", 0);
        overview.addStudent("Kari Nordmann", 0);

        overview.increaseNumberExercises("Per Hansen", 5);
        overview.increaseNumberExercises("Ole Olsen", 10);
        overview.increaseNumberExercises("Kari Nordmann", 15);

        System.out.println("Antallet studenter er: " + overview.getNumberOfStudents());

        System.out.println(overview);
        System.out.println("Per har gjort " + overview.findCompletedExercises("Per Hansen") + " øvinger");
        System.out.println("Ole har gjort " + overview.findCompletedExercises("Ole Olsen") + " øvinger");
        System.out.println("Kari har gjort " + overview.findCompletedExercises("Kari Nordmann") + " øvinger");
    }
}
