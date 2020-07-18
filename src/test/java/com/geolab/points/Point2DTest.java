package com.geolab.points;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class Point2DTest {

    @Test
    public void consistencyTest() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        assertEquals(p1, p2);
        p2.setX(1.2);
        assertNotEquals(p1, p2);
    }

    @Test
    public void symmetryTest() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        boolean check1 = p1.equals(p2);
        boolean check2 = p2.equals(p1);
        assertEquals(true, check1);
        assertEquals(true, check2);
    }

    @Test
    public void reflexiveTest() {
        Point2D p1 = new Point2D(1.0, 1.0);
        boolean check1 = p1.equals(p1);
        assertEquals(true, check1);
    }

    @Test
    public void hashCodeEqualTest() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void hashCodeNotEqualTest() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(2.0, 1.0);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void additionTest_addPoint() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        Point2D pAddition = new Point2D(2.0, 2.0);
        p1.addTo(p2);
        assertEquals(pAddition, p1);

    }

    @Test
    public void additionTest_addCoordiantes() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D pAddition = new Point2D(2.0, 2.0);
        p1.addTo(1.0, 1.0);
        assertEquals(pAddition, p1);
    }

    @Test
    public void additionTest_subPoint() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        Point2D pSubtraction = new Point2D(0.0, 0.0);
        p1.subtractFrom(p2);
        assertEquals(pSubtraction, p1);
    }

    @Test
    public void additionTest_subCoordiantes() {
        Point2D p1 = new Point2D(1.0, 1.0);
        Point2D pSubtraction = new Point2D(0.0, 0.0);
        p1.subtractFrom(1.0, 1.0);
        assertEquals(pSubtraction, p1);
    }

    @Test
    public void additionTest_mulPoint() {
        Point2D p1 = new Point2D(2.0, 2.0);
        Point2D p2 = new Point2D(2.0, 2.0);
        Point2D pMul = new Point2D(4.0, 4.0);
        p1.multiply(p2);
        assertEquals(pMul, p1);
    }

    @Test
    public void additionTest_mulCoordiantes() {
        Point2D p1 = new Point2D(2.0, 2.0);
        Point2D pMul = new Point2D(4.0, 4.0);
        p1.multiply(2.0, 2.0);
        assertEquals(pMul, p1);
    }

    @Test
    public void additionTest_divPoint() {
        Point2D p1 = new Point2D(2.0, 2.0);
        Point2D p2 = new Point2D(2.0, 2.0);
        Point2D pDiv = new Point2D(1.0, 1.0);
        p1.divide(p2);
        assertEquals(pDiv, p1);
    }

    @Test
    public void additionTest_divCoordiantes() {
        Point2D p1 = new Point2D(2.0, 2.0);
        Point2D pDiv = new Point2D(1.0, 1.0);
        p1.divide(2.0, 2.0);
        assertEquals(pDiv, p1);
    }

    @Test
    public void swapCoordiantes() {
        Point2D p1 = new Point2D(-1.0, 1.0);
        Point2D swaped = new Point2D(1.0, -1.0);
        p1.swapCoordiantes();
        assertEquals(swaped, p1);
    }
}