package ovinger.oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TimeConverterTest {

    TimeConverter converter = new TimeConverter();

    @Test
    public void testConvertToSeconds() {

        int hours1 = 1;
        int min1 = 35;
        int sec1 = 55;

        assertEquals(5755, converter.convertToSeconds(hours1, min1, sec1));

        int hours2 = 1;
        int min2 = 78;
        int sec2 = 35;
        
        assertThrows(IllegalArgumentException.class, 
                    () -> {converter.convertToSeconds(hours2, min2, sec2);});

        int hours3 = 1;
        int min3 = 45;
        int sec3 = 75;

        assertThrows(IllegalArgumentException.class, 
        () -> {converter.convertToSeconds(hours3, min3, sec3);});


    }
}
