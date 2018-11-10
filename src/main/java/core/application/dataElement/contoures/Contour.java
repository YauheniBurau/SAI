package core.application.dataElement.contoures;

import core.application.dataElement.IDataElement;
import core.application.dataElement.coords.ICoords;

import java.util.LinkedList;


/**
 * Created by anonymous on 09.11.2018.
 */
public class Contour<TCoords extends ICoords> implements IContour, IDataElement {
    public LinkedList<TCoords> coords = new LinkedList<TCoords>();


}
