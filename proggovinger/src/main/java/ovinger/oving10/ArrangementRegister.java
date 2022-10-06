package ovinger.oving10;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrangementRegister {
    
    private ArrayList<Arrangement> arrangementer;

    public ArrangementRegister() {
        arrangementer = new ArrayList<Arrangement>();
    }

    public void addArrangement(int id, int date, String name, String place, String host, String type) {
        arrangementer.add(new Arrangement(id, date, name, place, host, type));
    }

    public ArrayList<Arrangement> getArrangementerAtPlace(String place) {
        ArrayList<Arrangement> arrangementerAtPlace = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getPlace().equals(place))
                        .forEach(arrangement -> arrangementerAtPlace.add(arrangement));
        
        return new ArrayList<>(arrangementerAtPlace);
    }

    public ArrayList<Arrangement> getArrangementOnDate(int date) {
        int intervalForSameDate = 2359;
        ArrayList<Arrangement> arrangementerOnDate = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getDate() - date >= -intervalForSameDate && arrangement.getDate() - date <= intervalForSameDate)
                        .forEach(arrangement -> arrangementerOnDate.add(arrangement));
        
        return new ArrayList<>(arrangementerOnDate);
    }

    public ArrayList<Arrangement> getArrangementBetweenDates(int date1, int date2) {
        int laterDate = (date1 > date2) ? date1 : date2;
        int earlierDate = (date1 < date2) ? date1 : date2;

        ArrayList<Arrangement> arrangementerBetweenDates = new ArrayList<Arrangement>();
        arrangementer.stream().filter(arrangement -> arrangement.getDate() >= earlierDate && arrangement.getDate() <= laterDate)
                        .forEach(arrangement -> arrangementerBetweenDates.add(arrangement));
        
        arrangementerBetweenDates.sort((arrangement1, arrangement2) -> arrangement1.getDate() - arrangement2.getDate());
        return new ArrayList<>(arrangementerBetweenDates);
    }

    public HashMap<String, HashMap<String, ArrayList<Arrangement>>> getAllArrangementSorted() {
        HashMap<String, HashMap<String, ArrayList<Arrangement>>> arrangementerSorted = new HashMap<String, HashMap<String, ArrayList<Arrangement>>>();
        arrangementer.stream().forEach(arrangement -> {
            if (arrangementerSorted.containsKey(arrangement.getPlace())) {

                HashMap<String, ArrayList<Arrangement>> arrangementerAtPlace = arrangementerSorted.get(arrangement.getPlace());
                if (arrangementerAtPlace.containsKey(arrangement.getType())) {
                    ArrayList<Arrangement> arrangementerOfType = arrangementerAtPlace.get(arrangement.getType());
                    arrangementerOfType.add(arrangement);
                    arrangementerOfType.sort((arrangement1, arrangement2) -> arrangement1.getDate() - arrangement2.getDate());
                }
                else {
                    ArrayList<Arrangement> arrangementerOfType = new ArrayList<Arrangement>();
                    arrangementerOfType.add(arrangement);
                    arrangementerAtPlace.put(arrangement.getType(), arrangementerOfType);
                }
            }
            else {
                arrangementerSorted.put(arrangement.getPlace(), new HashMap<String, ArrayList<Arrangement>>());
            }
        });

        return new HashMap<>(arrangementerSorted);
    } 
    
}
