package ovinger.oving2;

public class BestValue {
    
    
   
    public void calculateBestValue(double[] product1, double[] product2) {
        double product1Value = product1[0] / product1[1];
        double product2Value = product2[0] / product2[1];


        if (product1Value > product2Value) {
            System.out.println("Product 2 is the best value, costing " + product2Value * 1000 + "kr/kg, and product 2 costs " + product1Value * 1000 + "kr/kg");
        } else if (product1Value < product2Value) {
            System.out.println("Product 1 is the best value, costing " + product1Value * 1000 + "kr/kg, and product 2 costs " + product2Value * 1000 + "kr/kg");
        } else {
            System.out.println("The products have equal value");
        }

        //Alternate implementation if the user isn't dumb
        //System.out.println("Product 1 costs " + product1Value * 1000 + "kr/kg, and product 2 costs " + product2Value * 1000 + "kr/kg");

    }

    public static void main(String[] args) {
        double[] product1 = new double[] {35.9, 450.0};
        double[] product2 = new double[] {39.5, 500.0};

        BestValue bestValue = new BestValue();

        bestValue.calculateBestValue(product1, product2);
    }
}
