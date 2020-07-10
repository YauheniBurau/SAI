package core.old;

// TODO: refactor all class
/**
 * Created by anonymous on 03.02.2018.
 */
public class MatrixConverter {


//    public static ElementImage matrix2dBooleanToImage(Matrix2dBoolean m2d){
//        ElementImage img = new ElementImage();
//        ArrayList<Point2d> points = new ArrayList<Point2d>();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        byte value = 127;
//        int size = m2d.size;
//        int sizeY = m2d.sizeY;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < size; i++) {
//                if(m2d.getValue(i, j)==true) points.add( new Point2d(i,j) );
//            }
//        }
//        // здесь должно быть преобразование точек и поворот их, чтобы выровнять ось симметрии вертикеально
//
//        Point2d c = m2d.countCenterOfSymmetry();
//        int a = m2d.countAngleAxisOfSymmetry(c);
//        int l = c.x;
//        int r = c.x;
//        int u = c.y;
//        int d = c.y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        double wStep = width/256;
//        double hStep = high/256;
//        Point2dByte pb;
//        byte x, y;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }
//
//    public static ElementImage ArrayListPoint2dToImage(ArrayList<Point2d> points){
//        byte value = 127;
//        ElementImage img = new ElementImage();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        int l = points.get(0).x;
//        int r = points.get(0).x;
//        int u = points.get(0).y;
//        int d = points.get(0).y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        Point2dByte pb;
//        byte x, y;
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }


//    public int[] countGistogramByValue(){
//        int v;
//        int gist[] = new int[256];
//        for(int l = 0; l<256; l++){
//            gist[l] = 0;
//        }
//        for(int j = 0; j<this.sizeY; j++){
//            for(int i = 0; i<this.sizeX; i++) {
//                v = this.getValue(i,j).v;
//                if(v>255) System.out.println("v=" + v);
//                gist[v]+=1;
//            }
//        }
//        return gist;
//    }


}
