package core.comparator;

import core.element.Curve;

import java.util.Comparator;

/**
 * Created by anonymous on 15.08.2018.
 */

public class CurveByStraightLengthDescComparator implements Comparator<Curve> {
    public int compare(Curve o1, Curve o2) {
        return o2.getStraightLength().compareTo(o1.getStraightLength());
    }
}
