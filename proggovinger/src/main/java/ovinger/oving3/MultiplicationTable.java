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

   
    private int checkInputIsInt(String inpuString) {
        
        try {
            int parsedInt = Integer.parseInt(inpuString);
            if (parsedInt < 1) 
            throw new IllegalArgumentException("Number must be > 0");
            
            return parsedInt;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be an integer > 0");
        }
    }

    public static void main(String[] args) {
        MultiplicationTable tableGenerator = new MultiplicationTable();

        do {
            int from = tableGenerator.checkInputIsInt(showInputDialog("Generate multiplication table from: "));
            int to = tableGenerator.checkInputIsInt(showInputDialog("To: "));
            tableGenerator.printMultiplicationTable(from, to);
        } while (true);  //TODO: change

    
    }
}
