package com.geolab.utils;

import com.geolab.points.Point;
import com.geolab.points.Point2D;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Point2DUtilsTest {

    private Point p1;
    private Point p2;
    private Point p3;

    @Before
    public void init() {
        p1 = new Point2D(1.0, 1.0);
        p2 = new Point2D(1.0, 1.0);
        p3 = new Point2D(2.0, 2.0);
    }

    @Test
    public void subtractPoints() {
        Point pSub = Point2DUtils.subtractPoints(p1, p2);
        assertEquals(pSub, new Point2D(0.0, 0.0));
    }

    @Test
    public void addPoints() {
        Point pAdd = Point2DUtils.addPoints(p1, p2);
        assertEquals(pAdd, new Point2D(2.0, 2.0));
    }

    @Test
    public void dividePoints() {
        Point pDiv = Point2DUtils.dividePoints(p3, p3);
        assertEquals(pDiv, new Point2D(1.0, 1.0));
    }

    @Test
    public void multiplyPoints() {
        Point pMul = Point2DUtils.multiplyPoints(p3, p3);
        assertEquals(pMul, new Point2D(4.0, 4.0));
    }

    @Test
    public void testSwapPoints() {
        Point2DUtils.swapPoints(p1, p3);
        assertEquals(new Point2D(1.0, 1.0), p3);
        assertEquals(new Point2D(2.0, 2.0), p1);
    }

    @Test
    public void testIsPointStrictlyGreaterThan() {
        assertTrue(Point2DUtils.isPointStrictlyGreaterThan(p3, p1));
        assertFalse(Point2DUtils.isPointStrictlyGreaterThan(p1, p3));
        assertFalse(Point2DUtils.isPointStrictlyGreaterThan(p1, p2));

    }
}