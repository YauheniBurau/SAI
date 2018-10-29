package core.old.comparator;

import core.application.dataElement.Curve;
import java.util.Comparator;

/**
 * Created by anonymous on 15.08.2018.
 */

// TODO: Remove later
public class CurveByStraightLengthDescComparator implements Comparator<Curve> {
    public int compare(Curve o1, Curve o2) {
        return o2.getStraightLength().compareTo(o1.getStraightLength());
    }
}
