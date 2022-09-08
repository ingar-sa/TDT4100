package ovinger.oving5;

import java.util.Random;

//The class has two methods, nextInt and nextDouble
//nextInt takes to ints as parameters, and returns a random int between the two, inclusive
//nextDouble takes two doubles as parameters, and returns a random double between the two, upper bound exclusive
//nextInt and nextDouble uses a object of the Random class from java.util to generate random numbers
public class MinRandom {

    private Random rng = new Random();


    public int nextInt(int min, int max) {
        return rng.nextInt(max - min + 1) + min;
    }

    public double nextDouble(double min, double max) {
        return rng.nextDouble() * (max - min) + min;
    }

    public static void main(String[] args) {
        MinRandom rng = new MinRandom();

        for (int i = 0; i < 10; i++) {
            System.out.println(rng.nextInt(1, 6));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(rng.nextDouble(1, 6));
        }
    }
}
