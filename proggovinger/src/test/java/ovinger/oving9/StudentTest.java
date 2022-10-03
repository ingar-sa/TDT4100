package ovinger.oving9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentTest {

    private static Student student;

    @BeforeAll
    public static void setup(){
        student = new Student("Per Hansen", 0);
    }

    @Test
    void testGetName() {
        assertEquals("Per Hansen", student.getName());
    }

    @Test
    void testGetNumberExercises() {
        assertEquals(0, student.getNumberExercises());
        student.increaseNumberExercises(5);
        assertEquals(5, student.getNumberExercises());
    }

    @Test
    void testToString() {
        assertEquals("Student: Per Hansen har gjort 0 øvinger", student.toString());
        student.increaseNumberExercises(5);
        assertEquals("Student: Per Hansen har gjort 5 øvinger", student.toString());
    }
}
