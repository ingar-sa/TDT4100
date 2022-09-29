package ovinger.oving7;

public final class NyString {

    private String string;
    
    NyString(String string) {
        this.string = string;
    }

    public String shorten() {
        String shorten = new String();
        String[] split = string.split(" ");

        for (String s : split) {
            shorten += s.charAt(0);
        }

        return new String(shorten);
    }

    public String removeChar(String charToRemove) {        
        return new String(string.replaceAll(charToRemove, ""));
    }


}
