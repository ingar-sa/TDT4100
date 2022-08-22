package ovinger.oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



public class SecondsToHourMinSecTest {

    SecondsToHourMinSec converter = new SecondsToHourMinSec();
    
    @Test
    public void testConvert() {
        int[] secondsArray = new int[] {3600, 1, 60, 65, 3678, 15782731};

        ArrayList<int[]> expectedValues = new ArrayList<int[]> () {
            {
            add(new int[] {1, 0, 0});
            add(new int[] {0, 0, 1});
            add(new int[] {0, 1, 0});
            add(new int[] {0, 1, 5});
            add(new int[] {1, 1, 18});
            add(new int[] {4384, 5, 31});
            }
        };
        
        List<int[]> calculatedValues = new ArrayList<>();
        for (int seconds : secondsArray) {
            calculatedValues.add(converter.convert(seconds));
        }

        for (int i = 0; i < expectedValues.size(); ++i) {
            for (int j = 0; j < 3; ++j) {
                assertEquals(expectedValues.get(i)[j], calculatedValues.get(i)[j]);
            }
            
        }

        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(-1);
        });

    }
}
