package ovinger.oving10.oppgave1;

import java.util.Comparator;

/**
 * This class is used to compare two Arrangement objects by place, then type, then date, then time.
 * 
 * @author Ingar S. Asheim
 */
public class ArrangementComparator implements Comparator<Arrangement> {

    @Override
    public int compare(Arrangement o1, Arrangement o2) {
        int placeCompare = o1.getPlace().compareTo(o2.getPlace());
        if (placeCompare != 0) {
            return placeCompare;
        }
        int typeCompare = o1.getType().compareTo(o2.getType());
        if (typeCompare != 0) {
            return typeCompare;
        }
        int dateCompare = o1.getDate() - o2.getDate();
        if (dateCompare != 0) {
            return dateCompare;
        }
        return o1.getTime() - o2.getTime();
    }

}
