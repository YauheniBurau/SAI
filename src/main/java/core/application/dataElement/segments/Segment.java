package core.application.dataElement.segments;

import core.application.dataElement.AbstractElement;
import core.application.dataElement.IDataElement;
import core.application.dataElement.coords.ICoords;
import core.application.dataElement.points.Point;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Segment<TValue extends IDataElement, TCoords extends ICoords>  extends AbstractElement {

    public ArrayList<Point<TValue,TCoords>> points = new ArrayList<Point<TValue, TCoords>>();

}
