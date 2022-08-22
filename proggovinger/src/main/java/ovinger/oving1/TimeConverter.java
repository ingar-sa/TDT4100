public class TimeConverter {

    private void validateSecAndMins(int time) {
        if (!(time >= 0 && time <= 60)) {
            throw new IllegalArgumentException();
        }
    }
 
    public int convertToSeconds(int hours, int minutes, int seconds) {
        validateSecAndMins(seconds);
        validateSecAndMins(minutes);
        return hours * 3600 + minutes * 60 + seconds;
    }
}
