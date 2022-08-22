public class SecondsToHourMinSec {
    
    public int[] convert(int seconds) {
        if (seconds < 0) {
            // throw new IllegalArgumentException("Values cannot be negative");
            System.err.println("Value cannot be negative");
        }
        int hours = seconds / 3600;
        int remainingSeconds = seconds % 3600;

        int minutes = remainingSeconds / 60;
        remainingSeconds = (minutes != 0) ? remainingSeconds % 60 : remainingSeconds;
        
        return new int[]{hours, minutes, remainingSeconds};
    }

    public void printValues(int[] values) {
        System.out.println(values[0] + " " + values[1] + " " + values[2]);
    }

    private void testValues(SecondsToHourMinSec converter, int[] valuesArray) {

        for (int value : valuesArray) {
            printValues(converter.convert(value));
        }
    }

    public static void main(String[] args) {
        SecondsToHourMinSec converter = new SecondsToHourMinSec();
        int[] secondsArray = new int[] {-1, 3600, 1, 60, 65, 3678, 15782731};
        
        converter.testValues(converter, secondsArray);
    }
}
