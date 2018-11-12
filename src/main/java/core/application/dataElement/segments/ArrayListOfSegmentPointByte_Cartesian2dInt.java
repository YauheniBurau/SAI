package core.application.dataElement.segments;

import java.util.ArrayList;

/**
 * Created by anonymous on 12.11.2018.
 */
public class ArrayListOfSegmentPointByte_Cartesian2dInt {
    public ArrayList<SegmentPointByte_Cartesian2dInt> segments = new ArrayList<SegmentPointByte_Cartesian2dInt>();

    public void add(SegmentPointByte_Cartesian2dInt value){
        this.segments.add(value);
    }


}
