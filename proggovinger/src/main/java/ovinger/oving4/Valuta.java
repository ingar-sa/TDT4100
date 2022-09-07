package ovinger.oving4;

import static javax.swing.JOptionPane.*;

public class Valuta {

    private double conversionRate;
    
    Valuta(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    private double convertToNok() {
        double amount = stringToDouble();
        return (amount == -1.0) ? amount : amount * conversionRate;
    }

    private double convertFromNok() {
        double amount = stringToDouble();
        return (amount == -1.0) ? amount : amount / conversionRate;
    }

    private double stringToDouble() {
        double convertedAmount = -1.0;
        try {
            convertedAmount = Double.parseDouble(showInputDialog("Amount"));
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number");
            return convertedAmount;
        }

        return convertedAmount;
    }

    public void convert() {
        String fromOrTo = showInputDialog("1: to Nok\n2: from Nok").toLowerCase();

        switch (fromOrTo) {
            case "1":
                System.out.println(convertToNok());
                break;
            case "2":
                System.out.println(convertFromNok());
                break;
            default:
                System.out.println("Choose 1 or 2");
                break;
        }        
    }

    public static void main(String[] args) {
        Valuta euro = new Valuta(10.122);
        Valuta dollar = new Valuta(9.87);
        Valuta sek = new Valuta(0.87);

        boolean loop = true;

        while (loop) {
            String valuta = showInputDialog(("1: dollar \n2: euro \n 3:svenske krone\n4: avslutt")).toLowerCase();
            switch (valuta) {
                case "1":
                    euro.convert();
                    break;
                case "2":
                    dollar.convert();
                    break;
                case "3":
                    sek.convert();
                    break;
                case "4":
                    loop = false;
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }
    }
}
