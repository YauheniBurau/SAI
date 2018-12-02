package core.application.dataElement.segments;

import core.application.dataElement.AbstractElement;
import core.application.dataElement.points.IPoint;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Segment<TPoint>  extends AbstractElement {

    public ArrayList<TPoint> points = new ArrayList<TPoint>();

    public void add(TPoint value){
        this.points.add(value);
    }

    public TPoint get(int index){
        return this.points.get(index);
    }

}
