package ovinger.oving6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.security.auth.login.CredentialException;

//The class 

public class IntCounter {

    private Random rng = new Random();

    private HashMap<Integer, Integer> numberTable = new HashMap<>();

    IntCounter() {
        setup();
    }

    private void setup() {
        for (int i = 0; i < 10; ++i) {
            numberTable.put(i, 0);
        }
    }

    private void addRandomNumber() {
        int newRandom = rng.nextInt(10);
        int updatedNumber = numberTable.get(newRandom) + 1;
        numberTable.put(newRandom, updatedNumber);
    }

    public void createTable(int iterations) {
        for (int i = 0; i < iterations; ++i) {
            addRandomNumber();
        }
    }

    public void printTable() {
        for (int i = 0; i < 10; i++) {
            int count = numberTable.get(i);
            System.out.println(i + " occurred " + count + " times.");
        }
    }
    
}
