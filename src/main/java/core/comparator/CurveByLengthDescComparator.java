package core.comparator;

import core.element.Curve;

import java.util.Comparator;

/**
 * Created by anonymous on 15.06.2018.
 */

public class CurveByLengthDescComparator implements Comparator<Curve> {
    public int compare(Curve o1, Curve o2) {
        return o2.getLength().compareTo(o1.getLength());
    }
}
