package ovinger.oving4;

//Spiller A og B alternerer paa aa kaste en d6, ved aa bruke Java.util.Random
//Verdien paa terningen legges til summen til en spiller
//Hvis en spiller triller en 1er, blir summen deres nullstilt
//Rundenummer og poengsum skrives ut for hver tur
//Foerste til 100 poeng vinner

public class Spiller {

    private int poengsum;
    private int rundenummer;
    private String navn;

    public Spiller(String navn) {
        this.navn = navn;
        poengsum = 0;
        rundenummer = 0;
    }

    public int getPoengsum() {
        return poengsum;
    }

    public int getRundenummer() {
        return rundenummer;
    }

    public String getNavn() {
        return navn;
    }

    public void spill() {
        rundenummer++;
        int terningkast = (int) (Math.random() * 6) + 1;
        if (terningkast == 1) {
            poengsum = 0;
        } else {
            poengsum += terningkast;
        }
        System.out.println("Runde " + rundenummer + ": " + navn + " fikk " + terningkast + " poeng. Sum: " + poengsum);
    }

    public static void main(String[] args) {
        Spiller spillerA = new Spiller("Spiller A");
        Spiller spillerB = new Spiller("Spiller B");

        while (spillerA.getPoengsum() < 100 && spillerB.getPoengsum() < 100) {
            spillerA.spill();
            spillerB.spill();
        }

        if (spillerA.getPoengsum() > spillerB.getPoengsum()) {
            System.out.println(spillerA.getNavn() + " vant!");
        } else {
            System.out.println(spillerB.getNavn() + " vant!");
        }
    }
}