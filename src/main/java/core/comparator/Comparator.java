package core.comparator;

import core.element.Point2dByte;
//import core.element.Image;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by anonymous on 02.03.2018.
 */
public class Comparator {

    public static double comparePoints(Point2dByte p1, Point2dByte p2){
        double dist = Math.sqrt(
                Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
        return dist;
    }

    /**
     * Compare point by distanceEpsilon and valueEpsilon between two points
     * where distanceEpsilon and valueEpsilon are absolute values
     * @param p1
     * @param p2
     * @param distEpsilon
     * @param valueEpsilon
     * @return
     */
    public static boolean comparePoints(Point2dByte p1, Point2dByte p2, int distEpsilon, int valueEpsilon){
        boolean result = false;
        double distE = Math.sqrt(
                Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
        int valueE = Math.abs( p1.value - p2.value );
        if(distE<=distEpsilon && valueE <= valueEpsilon){
            result = true;
        }
        return result;
    }

    /**
     * Compare point by distanceEpsilon and valueEpsilon between two points
     * where distanceEpsilon and valueEpsilon are percent values [0.00..1.00]
     * @param p1
     * @param p2
     * @param distEpsilon
     * @param valueEpsilon
     * @return
     */
    public static boolean comparePoints(Point2dByte p1, Point2dByte p2, double distEpsilon, double valueEpsilon){
        boolean result = false;
        double distE = Math.sqrt(
                Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
        int valueE = Math.abs( p1.value - p2.value );
        if(distE/256<=distEpsilon && valueE/256 <= valueEpsilon){
            result = true;
        }
        return result;
    }


//    // TODO:
//    public static double compareImages(Image base, Image in){
//        double diff = 0;
//        double minDist, dist;
//        HashMap<String, IElement> basePoints = base.elements;
//        HashMap<String, IElement> inPoints = in.elements;
//        int n = basePoints.size();
//        for(Point2dByte basePoint : basePoints.values()){
//            minDist = 127;
//            for(Point2dByte inPoint : inPoints.values()){
//                dist = Comparator.comparePoints(basePoint, inPoint);
//                if(dist<minDist && dist<=127){ minDist = dist; }
//            }
//            diff+=minDist;
//        }
//
//        diff /= n;
//        return diff;
//    }

//    public static double compareImages(Image base, Image in, byte epsilon){
//        double diff = 0;
//        double minDist, dist;
//        double i = 0;
//        double n = 1;
//        HashMap<String, Point2dByte> basePoints = base.getPoints();
//        HashMap<String, Point2dByte> inPoints = in.getPoints();
//        double n = basePoints.size();
//        for(Point2dByte basePoint : basePoints.values()){
//            minDist = 127;
//            for(Point2dByte inPoint : inPoints.values()){
//                dist = Comparator.comparePoints(basePoint, inPoint);
//                if(dist<minDist && dist<=127){ minDist = dist; }
//            }
//            if(minDist<=epsilon) {
//                diff += minDist;
//                i++;
//            }
//        }
//        return i/n;
//    }

    /**
     * compare images by absolute points distance and absolute points value
     * @param base
     * @param in
     * @param distEpsilon
     * @param valueEpsilon
     * @return
     */
//    public static double compareImages(Image base, Image in, int distEpsilon, int valueEpsilon){
//        double i = 0;
//        ArrayList<Point2dByte> basePoints = base.toArrayOfPoint2dByte();
//        ArrayList<Point2dByte> inPoints = in.toArrayOfPoint2dByte();
//        double n = basePoints.size();
//        for(Point2dByte basePoint : basePoints){
//            for(Point2dByte inPoint : inPoints){
//                if( Comparator.comparePoints(basePoint, inPoint, distEpsilon, valueEpsilon)==true){
//                    i++;
//                    break;
//                }
//            }
//        }
//        return i/n;
//    }

}
