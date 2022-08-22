package ovinger.oving1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InchToCmTest {

    InchToCm converter = new InchToCm();

    @Test
    public void testConvertToCm() {
        Double[] inches = new Double[] {1.54, 2.0, 3.45, 9.81, 12.0};
        Double[] convertedInches = new Double[inches.length];

        for (int i = 0; i < inches.length; ++i) {
            convertedInches[i] = converter.convertToCm(inches[i]);
        }

        Double[] expectedCm = new Double[] {3.91, 5.08, 8.76, 24.92, 30.48};
        
        for (int i = 0; i < inches.length; ++i) {
            assertEquals(expectedCm[i], convertedInches[i]);
        }

        assertThrows(IllegalArgumentException.class, () -> {
            converter.convertToCm(-1);
        });
        
        
    }
}
