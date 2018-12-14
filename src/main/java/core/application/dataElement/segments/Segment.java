package core.application.dataElement.segments;


import java.util.ArrayList;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Segment<TValue, TPoint, TContour> implements ISegment {
    public TValue value = null;
    public TContour outerContour = null;
    public ArrayList<TContour> innerContours = new ArrayList<>();
    public ArrayList<TPoint> points = new ArrayList<>();

    public Segment() {

    }

    public Segment(TValue value, ArrayList<TPoint> points) {
        this.value = value;
        this.points = points;
    }


}
