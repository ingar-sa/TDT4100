package ovinger.oving7;

public class TextAnalysis {
    
    private String text;

    // A constructor. It is called when you create a new TextAnalysis object.
    TextAnalysis(String text) {
        this.text = text;
    }

    /**
     * It splits the text into an array of words, and then returns the length of that array
     * 
     * @return The number of words in the text.
     */
    public int numberOfWords() {
        return text.split(" ").length;
    }

    /**
     * It takes a string as input, and returns a string with all special characters removed
     * 
     * @param string The string to be cleaned
     * @return A string with all special characters removed.
     */
    private String removeSpecialCharacters(String string) {
        return string.replaceAll("[^a-zA-Z0-9æøåÆØÅ]", "");
    }

    /**
     * We remove all special characters from the text, then we split the text into words, and then we
     * add up the length of each word and divide by the number of words
     * 
     * @return The average word length in the text.
     */
    public double averageWordLen() {
        String withoutSpecialChars = removeSpecialCharacters(text);
        double totalWords = numberOfWords();
        double totalChars = 0;

        for (String word : withoutSpecialChars.split(" ")) {
            totalChars += word.length();
        }

        return totalChars / totalWords;
    }

    /**
     * The function `averageWordsPerPeriod` returns the average number of words per period in the
     * text, with a periods being broken up by '.', '!', ':' and '?'
     * 
     * @return The average number of words per period.
     */
    public double averageWordsPerPeriod() {
        String[] periods = text.split("[.!:?]");
        double nPeriods = periods.length;
        
        return numberOfWords() / nPeriods;
    }

    /**
     * Replace all instances of the word toReplace with the word replaceWith.
     * 
     * @param toReplace The word to be replaced
     * @param replaceWith The word you want to replace the word with.
     * @return The text with the word toReplace replaced with replaceWith.
     */
    public String replaceWord(String toReplace, String replaceWith) {
        return text.replaceAll(toReplace, replaceWith);
    }

    /**
     * This function returns the text of the current node.
     * 
     * @return The text of the tweet.
     */
    public String getText() {
        return text;
    }

    /**
     * This function returns a new string that is the same as the original string, but with all the
     * letters in upper case.
     * 
     * @return A new string with all the characters in uppercase.
     */
    public String upperCase() {
        return new String(text.toUpperCase());
    }


}
