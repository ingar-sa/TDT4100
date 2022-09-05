package ovinger.oving3;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;


public class CheckIsPrime {
    
    /**
     * If the number is divisible by 2, it's not prime. If it's not divisible by 2, then it's not
     * divisible by any odd number less than or equal to the square root of the number
     * 
     * @param n the number to check if it's prime
     * @return The return value is a boolean.
     */
    public boolean isPrime(long n) {
        long m = 2;
        long loopTo = (int)Math.ceil(Math.sqrt((double)n));
        System.out.println((double)loopTo / 2);
        

        if (n % m == 0)
                return false;

            ++m;
        
        do {
            if (n % m == 0)
                return false;

            m += 2;

            // if ((m+1) % 10000000 == 0) {
            //     System.out.println(m / 2);
            // }

        } while (m <= loopTo);

        return true;
    }

    private long checkInputIsInt(String inpuString) {
        
        try {
            long parsedInt = Long.parseLong(inpuString);
            System.out.println(parsedInt);
            if (parsedInt < 1) 
            throw new IllegalArgumentException("Number must be > 0");
            
            return parsedInt;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be an integer > 0");
        }
    }

    public static void main(String[] args) {

        int[] navn = new int[] { 1, 2 };
        ArrayList<Integer> arraylist = new ArrayList<Integer>() { {
            add(5);
            add(4);
        }};

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
