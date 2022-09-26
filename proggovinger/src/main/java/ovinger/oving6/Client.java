package ovinger.oving6;

import static javax.swing.JOptionPane.*;

import java.util.ArrayList;

public class Client {
    
    public void intCounter() {
        IntCounter counter = new IntCounter();
        counter.createTable(5000);
        counter.printTable();
    }

    public void tekstAnalyse() {

        while (true) {

            String userString = showInputDialog("Tekst (RET to exit)");
            if (userString.equals(""))
                break;
                
            TekstAnalyse analyse = new TekstAnalyse(userString);
            boolean userchooses = true;

            while(userchooses) {
                String userChoice = showInputDialog("1) Antall forskjellige bokstaver 2) Totalt antall bokstaver 3) Prosent ikke bokstaver 4) Antall bestemt bokstav 5) Forekommer mest 6) exit");
                int choice = Integer.parseInt(userChoice); //Could add error handling
                switch (choice) {
                    case 1:
                        analyse.differentLetterCount();
                        break;
                    case 2:
                        analyse.getTotalLetterCount();
                        break;
                    case 3:
                        analyse.getPercentageNonLetter();
                        break;
                    case 4:
                        {
                            String userChar = showInputDialog("Letter");
                            analyse.getLetterCount(userChar.charAt(0));
                        }
                        break;
                    case 5:
                        analyse.occursMostOften();
                        break;
                    case 6:
                        userchooses = false;    
                        break;
                    default:
                        System.out.println("invalid choice");
                        break;
                }
            }
        }
    }

    public void matrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> column4 = new ArrayList<>();
        ArrayList<Integer> column5 = new ArrayList<>();

        column4.add(6); column4.add(5);  column4.add(4); 
        column5.add(3); column5.add(2); column5.add(1); 
        matrix.add(column4); matrix.add(column5);

        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();
        ArrayList<Integer> column3 = new ArrayList<>();

        column1.add(1); column1.add(2);
        column2.add(3); column2.add(4);
        column3.add(5); column3.add(6);
        matrix1.add(column1); matrix1.add(column2); matrix1.add(column3);

        Matrise matrise = new Matrise(matrix);
        // matrise.printMatrix(matrix);
        // matrise.printMatrix(matrix1);
        matrise.multiply(matrix1);
    }

    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.intCounter();
            client.tekstAnalyse();
            client.matrix(); 
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e + "\n An error occurred while running a program");
        }
    }

}
