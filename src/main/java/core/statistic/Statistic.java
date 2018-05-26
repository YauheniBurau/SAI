package core.statistic;

import core.element.HSV;
import core.element.Point2dGeneric;

import java.util.ArrayList;

/**
 * Created by anonymous on 21.05.2018.
 */
public class Statistic {

    public static int middleValue(ArrayList<Point2dGeneric<HSV>> points){
//        int value;
//        int minValue = 255, maxValue = 0;
//        for (Point2dGeneric<HSV> p: points) {
//            value = p.getValue().v;
//            if( value > maxValue) maxValue = value;
//            if( value < minValue) minValue = value;
//        }
//        return minValue + (maxValue - minValue)/2;

        int value = 0;
        for (Point2dGeneric<HSV> p: points) {
            value += p.getValue().v;
        }
        return value/points.size();
    }
}
