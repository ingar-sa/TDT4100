package ovinger.oving10;

public final class Arrangement {
    
    private int id;
    private int date;
    private String name;
    private String place;
    private String host;
    private String type;

    public Arrangement(int id, int date, String name, String place, String host, String type) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.place = place;
        this.host = host;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return new String(name);
    }

    public String getPlace() {
        return new String(place);
    }

    public String getHost() {
        return new String(host);
    }

    public String getType() {
        return new String(type);
    }
}
