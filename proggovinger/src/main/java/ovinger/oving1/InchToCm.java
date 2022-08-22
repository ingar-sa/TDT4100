public class InchToCm {

    double convertToCm(double inches) {

        return inches * 2.54;
    }

    public static void main(String[] args) {
        Double[] testSet = new Double[] {1.54, 2.0, 3.45, 9.81, 12.0};
        InchToCm converter = new InchToCm();

        for (double dub : testSet) {
            System.out.println(converter.convertToCm(dub));
        }
    }
    
}
