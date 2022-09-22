package ovinger.oving5;

import java.util.Random;

//The class has two methods, nextInt and nextDouble
//nextInt takes to ints as parameters, and returns a random int between the two, inclusive
//nextDouble takes two doubles as parameters, and returns a random double between the two, upper bound exclusive
//nextInt and nextDouble uses a object of the Random class from java.util to generate random numbers
public class MinRandom {

    private Random rng = new Random();


    public int nextInt(int min, int max) {
        int nextRandom = rng.nextInt(max - min + 1) + min;
        checkIntInRange(min, max, nextRandom);
        return nextRandom;
    }

    public double nextDouble(double min, double max) {
        double nextRandom = rng.nextDouble() * (max - min) + min;
        checkDoubleInRange(min, max, nextRandom);
        return nextRandom;
    }

    private void checkDoubleInRange(double min, double max, double n) {
        if (n < min || n > max) 
            throw new IllegalStateException("Number should not be outside the give range");
    }

    private void checkIntInRange(int min, int max, int n) {
        if (n < min || n > max) 
            throw new IllegalStateException("Number should not be outside the give range");
    }

    public static void main(String[] args) {
        MinRandom rng = new MinRandom();

        for (int i = 0; i < 100; i++) {
            System.out.println(rng.nextInt(1, i + 1));
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(rng.nextDouble(1, i + 1));
        }
    }
}
