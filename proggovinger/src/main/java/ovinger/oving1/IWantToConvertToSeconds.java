

public class IWantToConvertToSeconds {
    

    public static void main(String[] args) {
        TimeConverter converter = new TimeConverter();

        int hours1 = 1;
        int min1 = 35;
        int sec1 = 55;

        System.out.println(converter.convertToSeconds(hours1, min1, sec1));

        int hours2 = 1;
        int min2 = 78;
        int sec2 = 35;
        
        System.out.println(converter.convertToSeconds(hours2, min2, sec2));

        int hours3 = 1;
        int min3 = 45;
        int sec3 = 75;

        System.out.println(converter.convertToSeconds(hours3, min3, sec3));
    }
}
