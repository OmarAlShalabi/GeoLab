package com.geolab.generators;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.geolab.points.Point2D;

import org.junit.Test;

public class Point2DGeneratorTest {

    @Test
    public void generatePoints2DUniformTest() {
        Point2D p1 = new Point2D(0.0, 0.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        List<Point2D> ptsList = Point2DGenerator.generatePoints2DUniform(p1, p2);
        assertEquals(4, ptsList.size());
    }

    @Test
    public void generatePoints2DUniformTestSwaped() {
        Point2D p1 = new Point2D(0.0, 0.0);
        Point2D p2 = new Point2D(1.0, 1.0);
        List<Point2D> ptsList = Point2DGenerator.generatePoints2DUniform(p2, p1);
        assertEquals(4, ptsList.size());
    }
}