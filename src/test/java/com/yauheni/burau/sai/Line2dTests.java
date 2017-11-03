package com.yauheni.burau.sai;

import core.element.Line2d;
import core.element.Point2d;
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
                new Line2d( new Point2d(10, 10), new Point2d(20,10) ),
                new Line2d( new Point2d(10, 20), new Point2d(20,20)) ),
                0.01);
        Assert.assertEquals(-0.5,
                Line2d.lengthDiff(
                new Line2d( new Point2d(10, 10), new Point2d(20,10) ),
                new Line2d( new Point2d(5, 20), new Point2d(25,20)) ),
                0.01);

        Assert.assertEquals(-0.5,
                Line2d.distanceDiff(
                        new Line2d( new Point2d(10, 10), new Point2d(20,10) ),
                        new Line2d( new Point2d(5, 20), new Point2d(25,20)) ),
                0.01);

    }
}
