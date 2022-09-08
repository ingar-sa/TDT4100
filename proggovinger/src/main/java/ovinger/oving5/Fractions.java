package ovinger.oving5;

public class Fractions {
    
    private int numerator;
    private int denominator;

    Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = checkDenominatorNotZero(denominator);
    }

    Fractions(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    private int checkDenominatorNotZero(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
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

    
}
