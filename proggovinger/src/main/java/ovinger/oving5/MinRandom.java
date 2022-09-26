package ovinger.oving5;

import java.util.Random;

//The class has two methods, nesteHeltall and nesteDesimaltall
//nesteHeltall takes to ints as parameters, and returns a random int between the two, inclusive
//nesteDesimaltall takes two doubles as parameters, and returns a random double between the two, upper bound exclusive
//nesteHeltall and nesteDesimaltall uses a object of the Random class from java.util to generate random numbers
public class MinRandom {

    private Random rng = new Random();


    public int nesteHeltall(int min, int max) {
        int nextRandom = rng.nextInt(max - min) + min;
        checkIntInRange(min, max, nextRandom);
        return nextRandom;
    }

    public double nesteDesimaltall(double min, double max) {
        double nextRandom = rng.nextDouble() * (max - min) + min;
        checkDoubleInRange(min, max, nextRandom);
        return nextRandom;
    }

    private void checkDoubleInRange(double min, double max, double n) {
        if (n < min || n > max) 
            throw new IllegalStateException("Number should not be outside the given range");
    }

    private void checkIntInRange(int min, int max, int n) {
        if (n < min || n > max) 
            throw new IllegalStateException("Number should not be outside the given range");
    }

    public static void main(String[] args) {

        MinRandom rng = new MinRandom();

        for (int i = 0; i < 100; i++) {
            System.out.println(rng.nesteHeltall(0, i + 1));
        }

        for (int i = 0; i < 100; i++) {         
            System.out.println(rng.nesteDesimaltall(0, i + 1));
        }
    }
}
