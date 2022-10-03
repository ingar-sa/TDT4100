package ovinger.oving7;

public final class NyString {

    private String string;
    
    NyString(String string) {
        this.string = string;
    }

    /**
     * It splits the string into an array of strings, then iterates through the array and adds the
     * first character of each string to a new string
     * 
     * @return A string of the first letter of each word in the string.
     */
    public String shorten() {
        
        String shorten = new String();
        String[] split = string.split(" ");

        for (String s : split) {
            shorten += s.charAt(0);
        }

        return new String(shorten);
    }

    /**
     * It takes a string and returns a new string with all instances of the character to remove removed
     * 
     * @param charToRemove The character to remove from the string.
     * @return A new string with the character removed.
     */
    public String removeChar(String charToRemove) {        
        return new String(string.replaceAll(charToRemove, ""));
    }


}
