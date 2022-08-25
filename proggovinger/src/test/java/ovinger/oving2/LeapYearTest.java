package ovinger.oving2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeapYearTest {

    @Test
    void testIsLeapYear() {
        LeapYear isLeapYear = new LeapYear();

        int centuryButNotLeapYear = 1000;
        int centuryAndLeapYear = 2000;
        int leapYear = 2004;
        int notLeapYear = 2005;

        assertEquals(false, isLeapYear.isLeapYear(centuryButNotLeapYear));
        assertEquals(true, isLeapYear.isLeapYear(centuryAndLeapYear));
        assertEquals(true, isLeapYear.isLeapYear(leapYear));
        assertEquals(false, isLeapYear.isLeapYear(notLeapYear));
    }
}
