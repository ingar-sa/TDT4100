package ovinger.oving3;

import static javax.swing.JOptionPane.*;


public class CheckIsPrime {
    
    public boolean isPrime(int n) {
        int m = 2;
        int loopTo = (int)Math.ceil(Math.sqrt((double)n));
        
        do {
            if (n % m == 0)
                return false;

            ++m;
        } while (m <= loopTo);

        return true;
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

        CheckIsPrime checkIsPrime = new CheckIsPrime();
        do {
            boolean isPrime = checkIsPrime.isPrime(checkIsPrime.checkInputIsInt(showInputDialog("Enter prime number: ")));
            if (isPrime) {
                System.out.println("It's a prime number");
            } else {
                System.out.println("It is not a prime number");
            }
        } while (true);

        
    }
}
