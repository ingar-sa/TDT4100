package ovinger.oving5;

//Klassen skal ha to konstruktører, en som tar inn to heltall som parameter, og en som tar inn kun et heltall.
//Den første konstruktøren skal kaste en IllegalArgumentException hvis brøkens denominator er 0.
//Klassen skal ha en metode for å legge til en annen brøk, en metode for å trekke fra en annen brøk, en metode for å gange med en annen brøk og en metode for å dele med en annen brøk.
//Alle disse metodene skal ta inn to heltall som parameter, og bruke disse til å endre brøken.
//Klassen skal ha en metode som returnerer brøken som en streng, og en metode som returnerer brøken som et desimaltall.
//Klassen skal ha en metode som forkorter brøken.

public class Fraction {
    
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = checkDenominatorNotZero(denominator);
    }

    Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    private int checkDenominatorNotZero(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        }

        return denominator;
    }

    public int getnumerator() {
        return numerator;
    }

    public int getdenominator() {
        return denominator;
    }

    public void add(int numerator, int denominator) {
        this.numerator = this.numerator * denominator + numerator * this.denominator;
        this.denominator = this.denominator * denominator;
    }

    public void subtract(int numerator, int denominator) {
        this.numerator = this.numerator * denominator - numerator * this.denominator;
        this.denominator = this.denominator * denominator;
    }

    public void multiply(int numerator, int denominator) {
        this.numerator = this.numerator * numerator;
        this.denominator = this.denominator * denominator;
    }

    public void divide(int numerator, int denominator) {
        this.numerator = this.numerator * denominator;
        this.denominator = this.denominator * numerator;
    }

    private void simplify() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public String toString() {
        simplify();
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public static void main(String[] args) {
        Fraction b1 = new Fraction(1, 2);
        Fraction b2 = new Fraction(1, 3);
        Fraction b3 = new Fraction(1, 4);

        b1.add(b2.getnumerator(), b2.getdenominator());
        b1.subtract(b3.getnumerator(), b3.getdenominator());
        b1.multiply(b2.getnumerator(), b2.getdenominator());
        b1.divide(b3.getnumerator(), b3.getdenominator());

        System.out.println(b1);
        System.out.println(b1.toDouble());
    }
}
