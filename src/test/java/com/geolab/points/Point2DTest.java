package com.geolab.points;

import org.junit.Test;

import static org.junit.Assert.*;

public class Point2DTest {

    public static final double EPSILON = 1e-14;

    @Test
    public void consistencyTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(1.0, 1.0);
        assertEquals(p1, p2);
        p2.setX(1.2);
        assertNotEquals(p1, p2);
    }

    @Test
    public void symmetryTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(1.0, 1.0);
        boolean check1 = p1.equals(p2);
        boolean check2 = p2.equals(p1);
        assertTrue(check1);
        assertTrue(check2);
    }

    @Test
    public void reflexiveTest() {
        Point p1 = new Point2D(1.0, 1.0);
        boolean check1 = p1.equals(p1);
        assertTrue(check1);
    }

    @Test
    public void hashCodeEqualTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(1.0, 1.0);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void hashCodeNotEqualTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(2.0, 1.0);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void addPointTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(1.0, 1.0);
        Point pAddition = new Point2D(2.0, 2.0);
        p1.addTo(p2);
        assertEquals(pAddition, p1);

    }

    @Test
    public void subPointTest() {
        Point p1 = new Point2D(1.0, 1.0);
        Point p2 = new Point2D(1.0, 1.0);
        Point pSubtraction = new Point2D(0.0, 0.0);
        p1.subtractFrom(p2);
        assertEquals(pSubtraction, p1);
    }

    @Test
    public void mulPointTest() {
        Point p1 = new Point2D(2.0, 2.0);
        Point p2 = new Point2D(2.0, 2.0);
        Point pMul = new Point2D(4.0, 4.0);
        p1.multiply(p2);
        assertEquals(pMul, p1);
    }

    @Test
    public void divPointTest() {
        Point p1 = new Point2D(2.0, 2.0);
        Point p2 = new Point2D(2.0, 2.0);
        Point pDiv = new Point2D(1.0, 1.0);
        p1.divide(p2);
        assertEquals(pDiv, p1);
    }

    @Test
    public void swapCoordinatesTest() {
        Point p1 = new Point2D(-1.0, 1.0);
        Point swapped = new Point2D(1.0, -1.0);
        p1.swapCoordinates();
        assertEquals(swapped, p1);
    }

    @Test
    public void point2DRotationTest() {
        Point p1 = new Point2D(0.0, 1.0);
        p1.rotateAroundOrigin(Math.toRadians(90.0));
        assertEquals(-1.0, p1.getX(), EPSILON);
        assertEquals(0.0, p1.getY(), EPSILON);
    }
}