package com.geolab.generators;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.geolab.points.Point;
import com.geolab.points.Point2D;

import org.junit.Test;

public class Point2DGeneratorTest {

    @Test
    public void generatePoints2DUniformTest() {
        Point p1 = new Point2D(0.0, 0.0);
        Point p2 = new Point2D(1.0, 1.0);
        List<Point> ptsList = Point2DGenerator.generatePoints2DUniform(p1, p2);
        assertEquals(4, ptsList.size());
        assertEquals(p1, ptsList.get(0));
        assertEquals(new Point2D(0, 1), ptsList.get(1));
        assertEquals(new Point2D(1, 0), ptsList.get(2));
        assertEquals(p2, ptsList.get(3));
    }

    @Test
    public void generatePoints2DUniformTestSwapped() {
        Point ExpectedP1 = new Point2D(0.0, 0.0);
        Point ExpectedP2 = new Point2D(1.0, 1.0);
        Point p1 = new Point2D(0.0, 0.0);
        Point p2 = new Point2D(1.0, 1.0);
        List<Point> ptsList = Point2DGenerator.generatePoints2DUniform(p2, p1);
        assertEquals(4, ptsList.size());
        assertEquals(ExpectedP1, ptsList.get(0));
        assertEquals(new Point2D(0, 1), ptsList.get(1));
        assertEquals(new Point2D(1, 0), ptsList.get(2));
        assertEquals(ExpectedP2, ptsList.get(3));
    }
}