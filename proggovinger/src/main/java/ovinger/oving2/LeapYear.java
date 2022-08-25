package ovinger.oving2;

import java.util.Scanner;

public class LeapYear {

    public boolean isLeapYear(int year) {
        //TODO: get input from user i

        boolean isCentury = false;

        if (year % 100 == 0) {
            if (year % 400 == 0) {
            return true;
            }
            isCentury = true;
        }
        else if (!isCentury && year % 4 == 0) {
            return true;
        }

        return false;
    }

    public int getUserInput() {

        Scanner in = new Scanner(System.in);
        int userinput = in.nextInt();
        in.close();

        return userinput;
    }

    public static void main(String[] args) {
        LeapYear leapYear = new LeapYear();

        System.out.println(leapYear.isLeapYear(leapYear.getUserInput()));
    }
}

