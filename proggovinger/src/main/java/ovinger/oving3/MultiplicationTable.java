package ovinger.oving3;

import static javax.swing.JOptionPane.*;

public class MultiplicationTable {
    
    public void printMultiplicationTable(int from, int to) {
        do {
            System.out.println("Table for " + from);
            int factor = 1;
            do {
                System.out.println(from + " X " + factor + " = " + from*factor);
                ++factor;
            } while(factor < 11);

            ++from;
        } while (from <= to);
    }

   
    private boolean checkInputIsInt(String inpuString) {
        return true;
    }

    public static void main(String[] args) {
        MultiplicationTable tableGenerator = new MultiplicationTable();

        do {

            String stringFrom = showInputDialog("Generate multiplication table from: ");
            String stringTo = showInputDialog("To: ");
            
            try {
                int fromInt = Integer.parseInt(stringFrom);
                int toInt = Integer.parseInt(stringTo);
                tableGenerator.printMultiplicationTable(fromInt, toInt);
    
            } catch (NumberFormatException e) {
                System.out.println("Skriv inn paa nytt");
            }   
        } while (true);  //TODO: change
    }
}

// if (from && to) {
            //     int fromInt = Integer.parseInt(stringFrom);
            //     int toInt = Integer.parseInt(stringTo);
                
            //     tableGenerator.printMultiplicationTable(fromInt, toInt);
            // }

                // boolean from = tableGenerator.checkInputIsInt(stringFrom);
            // boolean to = tableGenerator.checkInputIsInt(stringTo);
