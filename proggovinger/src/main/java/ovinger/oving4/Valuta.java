package ovinger.oving4;

import static javax.swing.JOptionPane.*;

public class Valuta {

    private double conversionRate;
    
    Valuta(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    private double convertToNok() {
        double amount = stringToDouble(s)
        return amount * conversionRate;
    }

    private double convertFromNok() {
        double amount = stringToDouble(s)
        return amount / conversionRate;
    }

    private double stringToDouble() {
        double convertedAmount = -1.0;
        try {
            convertedAmount = Double.parseDouble(showInputDialog("Amount"));
        } catch (NumberFormatException e) {
            return convertedAmount;
        }

        return convertedAmount;
    }

    public double convert() {
        String fromOrTo = showInputDialog("1: to Nok\n2: from Nok").toLowerCase();

        switch (fromOrTo) {
            case "1":
                convertToNok();
                break;
            case "2":
                convertFromNok();
                break;
            default:
                System.out.println("Choose 1 or 2");
                break;
        }
        if (stringToDouble(fromOrTo)) (Double.parseDouble(fromOrTo) == 1.0 || Double.parseDouble(fromOrTo) == 0.0) {

        }
        String amountString = showInputDialog("Amount: ");
        
        

        
    }

    public static void main(String[] args) {
        Valuta euro = new Valuta(10.122);
        Valuta dollar = new Valuta(9.87);
        Valuta sek = new Valuta(0.87);
        boolean loop = true;
        while (loop) {
        
            String valuta = showInputDialog(("1: dollar \n2: euro \n 3:svenske krone\n4: avslutt")).toLowerCase();
            switch (valuta) {
                case  "euro":
                    
                    break;
            
                default:
                    loop = false;
                    break;
            }
        }
    }
}
