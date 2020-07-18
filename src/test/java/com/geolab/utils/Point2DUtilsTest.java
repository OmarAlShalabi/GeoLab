package com.geolab.utils;

import static org.junit.Assert.assertEquals;

import com.geolab.points.Point2D;

import org.junit.Before;
import org.junit.Test;

public class Point2DUtilsTest {

    private Point2D p1;
    private Point2D p2;
    private Point2D p3;

    @Before
    public void init() {
        p1 = new Point2D(1.0, 1.0);
        p2 = new Point2D(1.0, 1.0);
        p3 = new Point2D(2.0, 2.0);
    }

    @Test
    public void subtractPoints() {
        Point2D pSub = Point2DUtils.subtractPoints(p1, p2);
        assertEquals(pSub, new Point2D(0.0, 0.0));
    }

    @Test
    public void addPoints() {
        Point2D pAdd = Point2DUtils.addPoints(p1, p2);
        assertEquals(pAdd, new Point2D(2.0, 2.0));
    }

    @Test
    public void dividePoints() {
        Point2D pDiv = Point2DUtils.dividePoints(p3, p3);
        assertEquals(pDiv, new Point2D(1.0, 1.0));
    }

    @Test
    public void multiplyPoints() {
        Point2D pMul = Point2DUtils.multiplyPoints(p3, p3);
        assertEquals(pMul, new Point2D(4.0, 4.0));
    }
}