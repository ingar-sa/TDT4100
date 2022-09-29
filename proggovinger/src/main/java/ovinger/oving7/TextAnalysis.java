package ovinger.oving7;

public class TextAnalysis {
    
    private String text;

    TextAnalysis(String text) {
        this.text = text;
    }

    public int numberOfWords() {
        return text.split(" ").length;
    }

    private String removeSpecialCharacters(String string) {
        return string.replaceAll("[^a-zA-Z0-9æøåÆØÅ]", "");
    }

    public double averageWordLen() {
        String withoutSpecialChars = removeSpecialCharacters(text);
        double totalWords = numberOfWords();
        double totalChars = 0;

        for (String word : withoutSpecialChars.split(" ")) {
            totalChars += word.length();
        }

        return totalChars / totalWords;
    }

    public double averageWordsPerPeriod() {
        String[] periods = text.split("[.!:?]");
        // for (String string : periods) {
        //     System.out.println("i" + string);
        // }
        double nPeriods = periods.length;
        

        return numberOfWords() / nPeriods;
    }

    public String replaceWord(String toReplace, String replaceWith) {
        return text.replaceAll(toReplace, replaceWith);
    }

    public String getText() {
        return text;
    }

    public String upperCase() {
        return new String(text.toUpperCase());
    }


}
