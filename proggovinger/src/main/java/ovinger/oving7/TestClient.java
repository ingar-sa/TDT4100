package ovinger.oving7;

public class TestClient {

    NyString nyString;
    TextAnalysis textAnalysis;

    public void testNyString(String string, String charToRemove) {
        this.nyString = new NyString(string);

        System.out.println("Forkortelsen av " + string + "er: " + nyString.shorten() + '\n');
        System.out.println(string + " uten " + charToRemove + " er: " + nyString.removeChar(charToRemove) + '\n');
    }

    public void testTextAnalysis(String string) {
        this.textAnalysis = new TextAnalysis(string);
        System.out.println("Antall ord er: " + textAnalysis.numberOfWords() + '\n');
        System.out.println("Gjennomsnittlig ordlengde er: " + textAnalysis.averageWordLen() + '\n');
        System.out.println("Gjennomsnittlig mengde ord per periode er: " + textAnalysis.averageWordsPerPeriod() + '\n');
        System.out.println(string + "med bu i stedet for og er: " + textAnalysis.replaceWord("er", "bu") + '\n');
        System.out.println(string + " uendret er: " + textAnalysis.getText() + '\n');
        System.out.println(string + " i uppercase er: " + textAnalysis.upperCase() + '\n');

    }
    
    public static void main(String[] args) {
        String nyString = "Dette er en tekst med æøå og STORE BOKSTAVER OG .ord";
        String charToRemove = "ø";
        String textAnalysis = "Periode en er fem ord. Periode to er også fem! To til";

        TestClient client = new TestClient();
        // client.testNyString(nyString, charToRemove);
        client.testTextAnalysis(textAnalysis);
    }   
}
