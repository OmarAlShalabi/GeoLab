package com.geolab.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.geolab.points.Point2D;
import com.geolab.vectors.Vector;
import com.geolab.vectors.Vector2D;

import org.junit.Test;

public class Vector2DUtilsTest {

    public static final double EPSILON = 1e-14;

    @Test
    public void dotProductTest() {
        Vector testVector1 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(2.0, 2.0));
        assertEquals(4.0, Vector2DUtils.dotProduct(testVector1, testVector2), EPSILON);
    }

    @Test
    public void orientationTest() {
        Vector testVector1 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(1.0, 1.0));
        Vector testVector2 = new Vector2D(new Point2D(0.0, 0.0), new Point2D(0.0, 2.0));
        boolean check = Vector2DUtils.crossProductKComponent(testVector1, testVector2) > 0.0;
        assertTrue(check);
    }
    
}