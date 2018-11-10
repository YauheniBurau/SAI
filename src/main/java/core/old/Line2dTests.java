package core.old;

import core.application.dataElement.Line2d;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anonymous on 03.11.2017.
 */
public class Line2dTests {

    @Test
    public void line2d() {
        Assert.assertEquals( Line2d.angleDiff(90, 45), 1, 0.01);
        Assert.assertEquals( Line2d.angleDiff(45, 90), -0.50, 0.01);

        Assert.assertEquals(  0,
                Line2d.lengthDiff(
                new Line2d( new Point(10, 10), new Point(20,10) ),
                new Line2d( new Point(10, 20), new Point(20,20)) ),
                0.01);
        Assert.assertEquals(-0.5,
                Line2d.lengthDiff(
                new Line2d( new Point(10, 10), new Point(20,10) ),
                new Line2d( new Point(5, 20), new Point(25,20)) ),
                0.01);

        Assert.assertEquals(-0.5,
                Line2d.distanceDiff(
                        new Line2d( new Point(10, 10), new Point(20,10) ),
                        new Line2d( new Point(5, 20), new Point(25,20)) ),
                0.01);

    }

//    @Test
//    public void checkLineAngleCount(){
//        Assert.assertEquals( true,
//                0 - Line2d.getAngle(new Point2d(100, 100), new Point2d(200, 100)) <1);
//        Assert.assertEquals( true,
//                90  - Line2d.getAngle(new Point2d(100, 100), new Point2d(100, 200)) <1);
//        Assert.assertEquals( true,
//                180  - Line2d.getAngle(new Point2d(100, 100), new Point2d(0, 100)) <1);
//        Assert.assertEquals( true,
//                270  - Line2d.getAngle(new Point2d(100, 100), new Point2d(100, 0)) <1);
//
//        Assert.assertEquals( true,
//                45 - Line2d.getAngle(new Point2d(100, 100), new Point2d(200, 200)) <1);
//
//        Assert.assertEquals( true,
//                135 - Line2d.getAngle(new Point2d(100, 100), new Point2d(0, 200) ) <1);
//
//        Assert.assertEquals( true,
//                225 - Line2d.getAngle(new Point2d(100, 100), new Point2d(0, 0)) <1);
//
//        Assert.assertEquals( true,
//                315 - Line2d.getAngle(new Point2d(100, 100), new Point2d(200, 0)) <1);
//    }

}
