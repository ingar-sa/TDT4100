package ovinger.oving5;

//Klassen skal ha to konstruktører, en som tar inn to heltall som parameter, og en som tar inn kun et heltall.
//Den første konstruktøren skal kaste en IllegalArgumentException hvis brøkens nevner er 0.
//Klassen skal ha en metode for å legge til en annen brøk, en metode for å trekke fra en annen brøk, en metode for å gange med en annen brøk og en metode for å dele med en annen brøk.
//Alle disse metodene skal ta inn to heltall som parameter, og bruke disse til å endre brøken.
//Klassen skal ha en metode som returnerer brøken som en streng, og en metode som returnerer brøken som et desimaltall.
//Klassen skal ha en metode som forkorter brøken.

public class Brok {
    
    private int teller;
    private int nevner;

    Brok(int teller, int nevner) {
        this.teller = teller;
        this.nevner = checkNevnerNotZero(nevner);
    }

    Brok(int teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    private int checkNevnerNotZero(int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner cannot be zero");
        }

        return nevner;
    }

    public int getTeller() {
        return teller;
    }

    public int getNevner() {
        return nevner;
    }

    public void add(int teller, int nevner) {
        this.teller = this.teller * nevner + teller * this.nevner;
        this.nevner = this.nevner * nevner;
    }

    public void subtract(int teller, int nevner) {
        this.teller = this.teller * nevner - teller * this.nevner;
        this.nevner = this.nevner * nevner;
    }

    public void multiply(int teller, int nevner) {
        this.teller = this.teller * teller;
        this.nevner = this.nevner * nevner;
    }

    public void divide(int teller, int nevner) {
        this.teller = this.teller * nevner;
        this.nevner = this.nevner * teller;
    }

    private void simplify() {
        int gcd = gcd(this.teller, this.nevner);
        this.teller /= gcd;
        this.nevner /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public String toString() {
        simplify();
        return teller + "/" + nevner;
    }

    public double toDouble() {
        return (double) teller / nevner;
    }

    public static void main(String[] args) {
        Brok b1 = new Brok(1, 2);
        Brok b2 = new Brok(1, 3);
        Brok b3 = new Brok(1, 4);

        b1.add(b2.getTeller(), b2.getNevner());
        b1.subtract(b3.getTeller(), b3.getNevner());
        b1.multiply(b2.getTeller(), b2.getNevner());
        b1.divide(b3.getTeller(), b3.getNevner());

        System.out.println(b1);
        System.out.println(b1.toDouble());
    }
}
