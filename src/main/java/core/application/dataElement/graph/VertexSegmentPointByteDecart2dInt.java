package core.application.dataElement.graph;

import core.application.dataElement.coords.Decart2d;
import core.application.dataElement.points.Point;
import core.application.dataElement.segments.Segment;

import java.util.ArrayList;

/**
 * Created by anonymous on 02.12.2018.
 */
public class VertexSegmentPointByteDecart2dInt extends AbstractVertex{
    private Segment<Point<Byte, Decart2d<Integer>>> Segment = null;
    private VertexSegmentPointByteDecart2dInt parent = null;
    private ArrayList<VertexSegmentPointByteDecart2dInt> childs = null;

    public VertexSegmentPointByteDecart2dInt() {

    }


}
