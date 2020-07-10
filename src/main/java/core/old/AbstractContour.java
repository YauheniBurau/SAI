package core.old;

import java.util.LinkedList;

/**
 * Created by anonymous on 09.11.2018.
 */
public abstract class AbstractContour<TCoords extends ICoords>{
    public LinkedList<TCoords> elements = new LinkedList<TCoords>();

}
