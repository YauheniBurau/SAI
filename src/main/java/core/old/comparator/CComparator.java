package core.old.comparator;

import core.application.dataElement.Point2dByte;

// TODO: Remove later
/**
 * Created by anonymous on 02.03.2018.
 */
public class CComparator {

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
//    public static double compareImages(ElementImage base, ElementImage in){
//        double diff = 0;
//        double minDist, dist;
//        HashMap<String, IDataElement> basePoints = base.elements;
//        HashMap<String, IDataElement> inPoints = in.elements;
//        int n = basePoints.size();
//        for(Point2dByte basePoint : basePoints.values()){
//            minDist = 127;
//            for(Point2dByte inPoint : inPoints.values()){
//                dist = CComparator.comparePoints(basePoint, inPoint);
//                if(dist<minDist && dist<=127){ minDist = dist; }
//            }
//            diff+=minDist;
//        }
//
//        diff /= n;
//        return diff;
//    }

//    public static double compareImages(ElementImage base, ElementImage in, byte epsilon){
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
//                dist = CComparator.comparePoints(basePoint, inPoint);
//                if(dist<minDist && dist<=127){ minDist = dist; }
//            }
//            if(minDist<=epsilon) {
//                diff += minDist;
//                i++;
//            }
//        }
//        return i/n;
//    }

//    /**
//     * compare images by absolute points distance and absolute points value
//     * @param base
//     * @param in
//     * @param distEpsilon
//     * @param valueEpsilon
//     * @return
//     */
//    public static double compareImages(ElementImage base, ElementImage in, int distEpsilon, int valueEpsilon){
//        double i = 0;
//        ArrayList<Point2dByte> basePoints = base.toArrayOfPoint2dByte();
//        ArrayList<Point2dByte> inPoints = in.toArrayOfPoint2dByte();
//        double n = basePoints.size();
//        for(Point2dByte basePoint : basePoints){
//            for(Point2dByte inPoint : inPoints){
//                if( CComparator.comparePoints(basePoint, inPoint, distEpsilon, valueEpsilon)==true){
//                    i++;
//                    break;
//                }
//            }
//        }
//        return i/n;
//    }



//    private static Segment NormalizeSegmentPoints(Segment s){
//        s.countShiftAndSize();
//        Segment seg = new Segment();
//        int x, y;
//        double stepX = s.width/256.0;
//        double stepY = s.high/256.0;
//        for (Point p: s.points) {
//            x = (int)((p.x-s.width)/stepX);
//            y = (int)((p.y - s.high)/stepY);
//            seg.points.add( new Point( x, y, 0, p.value) );
//        }
//        return seg;
//    }

//    /**
//     *
//     * @param etalon
//     * @param in
//     * @param distEpsilon 0..256
//     * @param valueEpsilon 0..256
//     * @return
//     */
//    public static double compareFormSegments(Segment etalon, Segment in, int distEpsilon, int valueEpsilon){
//        double i = 0;
//        int n = etalon.points.size();
//        ArrayList<Point2dByte> etalonPoints = CComparator.NormalizeSegmentPoints(etalon).points;
//        ArrayList<Point2dByte> inPoints = CComparator.NormalizeSegmentPoints(in).points;
//        for(Point2dByte etalonPoint : etalonPoints){
//            for(Point2dByte inPoint : inPoints){
//                if( CComparator.comparePoints(etalonPoint, inPoint, distEpsilon, valueEpsilon)==true){
//                    i++;
//                    break;
//                }
//            }
//        }
//        return i/n;
//    }




}
