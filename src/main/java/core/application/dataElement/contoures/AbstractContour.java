package core.application.dataElement.contoures;

import core.application.dataElement.coords.ICoords;

import java.util.LinkedList;


/**
 * Created by anonymous on 09.11.2018.
 */
public class AbstractContour<TCoords extends ICoords> implements IContour {
    public LinkedList<TCoords> coords = new LinkedList<TCoords>();

}
