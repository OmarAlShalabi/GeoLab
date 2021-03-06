package com.geolab.vectors;

import com.geolab.points.Point2D;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Vector2DTest {

    public static final double EPSILON = 1e-14;

    @Rule
    public ExpectedException testException = ExpectedException.none();

    @Test
    public void consistencyTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        assertEquals(testVector, testVector2);
        testVector.setStartingPoint(new Point2D(0.0, 2.0));
        assertNotEquals(testVector, testVector2);
    }

    @Test
    public void reflexiveTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        boolean check1 = testVector.equals(testVector);
        assertTrue(check1);
    }

    @Test
    public void symmetryTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        boolean check1 = testVector.equals(testVector2);
        boolean check2 = testVector2.equals(testVector);
        assertTrue(check1);
        assertTrue(check2);
    }

    @Test
    public void hashCodeTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        Vector testVector3 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 1.0));
        assertEquals(testVector.hashCode(), testVector2.hashCode());
        assertNotEquals(testVector.hashCode(), testVector3.hashCode());
    }

    @Test
    public void vector2DInstantiationTest_ExpectedException() {
        testException.expect(IllegalArgumentException.class);
        Vector2D testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 0.0));
        testVector.getStartingPoint();
    }

    @Test
    public void vector2DComponentsTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        assertEquals(new Point2D(0.0, 0.0), testVector.getStartingPoint());
        assertEquals(new Point2D(1.0, 1.0), testVector.getEndPoint());
        assertEquals(1.0, testVector.getIComponent(), EPSILON);
        assertEquals(1.0, testVector.getJComponent(), EPSILON);
        assertEquals(Math.sqrt(2.0), testVector.getRComponent(), EPSILON);
        assertEquals(Math.PI / 4, testVector.getAngleComponent(), EPSILON);
        assertEquals(1.0, testVector.getSlope(), EPSILON);
        assertEquals(Double.NaN, testVector2.getSlope(), EPSILON);
    }

    @Test
    public void vector2DTranslationTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        testVector.translateVector(testVector2);
        assertEquals(new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 2.0)), testVector);
    }

    @Test
    public void vector2DScaleTest() {
        Vector testVector = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 1.0));
        Vector scaledVector = new Vector2D(new Point2D(1.0, 0.0), new Point2D(1.0, 2.0));
        testVector.scaleVector(new Point2D(-1.0, 0.0), 2);
        assertEquals(scaledVector, testVector);
    }

    @Test
    public void vector2DRotateTest() {
        Vector testVector = new Vector2D(new Point2D(-1.0, 1.0), new Point2D(1.0, 1.0));
        testVector.rotateVector(new Point2D(0.0, 1.0) , Math.toRadians(90.0));
        assertEquals(0.0, testVector.getStartingPoint().getX(), EPSILON);
        assertEquals(0.0, testVector.getStartingPoint().getY(), EPSILON);
        assertEquals(0.0, testVector.getEndPoint().getX(), EPSILON);
        assertEquals(2.0, testVector.getEndPoint().getY(), EPSILON);
    }
}