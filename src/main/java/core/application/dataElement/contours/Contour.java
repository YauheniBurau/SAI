package core.application.dataElement.contours;

import core.application.dataElement.coords.ICoords;

import java.util.LinkedList;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Contour<TCoords extends ICoords> implements IContour {
    public LinkedList<TCoords> coords = new LinkedList<TCoords>();

}
