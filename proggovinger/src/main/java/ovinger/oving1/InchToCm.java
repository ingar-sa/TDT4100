package ovinger.oving1;

public class InchToCm {

    public double convertToCm(double inches) {

        if (inches < 0) 
            throw new IllegalArgumentException("Value cannot be negative");


        double cm = (Math.round(inches*2.54*100.0)/100.0);

        return cm;
    }



}
