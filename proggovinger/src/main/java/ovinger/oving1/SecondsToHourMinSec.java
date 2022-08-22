package ovinger.oving1;

public class SecondsToHourMinSec {
    
    public int[] convert(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
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

}
