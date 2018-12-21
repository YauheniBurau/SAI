package core.application.VertexValue.contour;

import core.application.VertexValue.coords.ICoords;

import java.util.LinkedList;

/**
 * Created by anonymous on 09.11.2018.
 */
public abstract class AbstractContour<TCoords extends ICoords> implements IContour {
    public LinkedList<TCoords> elements = new LinkedList<TCoords>();

}
