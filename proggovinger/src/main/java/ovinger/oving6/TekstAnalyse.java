package ovinger.oving6;

import java.util.ArrayList;
import java.util.HashMap;


public class TekstAnalyse {
    
    private ArrayList<Integer> charCounter = new ArrayList<>();
    private HashMap<Character, Integer> norwegianChars = new HashMap<Character, Integer>(){
        {
            put('Æ', 26);
            put('Ø', 27);
            put('Å', 28);
        }
    };

    private String userString;

    TekstAnalyse(String userString) {
        setup();
        this.userString = userString.toUpperCase();
        createTable();
    }

    private void setup() {
        for (int i = 0; i < 30; i++) {
            charCounter.add(i, 0);
        }
    }

    private void createTable() {
        for (int i = 0; i < userString.length(); i++) {
            Character currentChar = userString.charAt(i);
            int index = getCharIndex(currentChar);
            charCounter.set(index, charCounter.get(index) + 1);
        }

    }

    private int getCharIndex(char currentChar) {

        if (!Character.isLetter(currentChar)) {
            return 29;
        } 
        else if (norwegianChars.keySet().contains(currentChar)) {
            return norwegianChars.get(currentChar);
        }
        else {
            return (int)(currentChar - 'A');
        }
    }

    private char getLetterFromIndex(int index) {
        if (index < 26) {
            return (char)(index + (int)'A');
        } 
        else if (index == 26) {
            return 'Æ';
        }
        else if (index == 27) {
            return 'Ø';
        }
        else if (index == 28) {
            return 'Å';
        }
        else {
            throw new IllegalArgumentException("Not a letter");
        }
    }

    //Get's the count of how many letters appeared in the text
    //e.g. the strings "ABC" and "AAAABBBC" would both return 3
    //since three different letters occurred in the text 
    public void differentLetterCount() {
        int count = 0;
        for (int i = 0; i < 29; i++) {
            if (charCounter.get(i) != 0)
                count += 1;
        }

        System.out.println("Amount of different letters: " + count);
    }

    //Get's the total amount of letters that appeared in the text
    //e.g. "Hello World" would return 10
    public void getTotalLetterCount() {
        int count = 0;
        for (int i = 0; i < 29; i++) {
            count += charCounter.get(i);
        }

        System.out.println("Total letter count: " + count);
    }

    public void getPercentageNonLetter() {
        System.out.println("Percentage of non letter characters: " + ((double)charCounter.get(29) / (double)userString.length()) * 100);
    }
    
    // public void printTable() {
    //     for (int count : charCounter) {
    //         System.out.println(count);
    //     }
    // }

    //Gets the count of how many times the letter passed
    //as an argument appeared in the text
    //e.g. if the text is "Hello World", and you pass 'l'
    //it would return 3
    public void getLetterCount(Character letter) {
        letter = Character.toUpperCase(letter);
        int index = getCharIndex(letter);
        System.out.println(letter + " occurs " + charCounter.get(index) + " times");
    }

    public void occursMostOften() {
        int most_occurences = 0;
        // int index = 0;
        for (int i = 0; i < 29; i++) {
            int occurrences = charCounter.get(i);
            if (occurrences > most_occurences) {
                most_occurences = occurrences;
                // index = i;
            }  
        }

        ArrayList<Character> charsThatOccurMost = new ArrayList<>();

        for (int i = 0; i < 29; i++) {
            if (charCounter.get(i) == most_occurences) {
                charsThatOccurMost.add(getLetterFromIndex(i));
            }
        }

        for (Character character : charsThatOccurMost) {
            System.out.println(character + " occurs the most: " + most_occurences);
        }
    }
}
