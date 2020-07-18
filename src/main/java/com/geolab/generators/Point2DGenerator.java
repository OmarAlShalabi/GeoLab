package com.geolab.generators;

import java.util.ArrayList;
import java.util.List;

import com.geolab.points.Point2D;

public class Point2DGenerator {

    private Point2DGenerator() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a Generator Class");
    }

    public static List<Point2D> generatePoints2DUniform(Point2D boundaryPt1, Point2D boundaryPt2) {
        List<Point2D> resultList = new ArrayList<>();
        int deltaX = (int) Math.abs(boundaryPt2.getX() - boundaryPt1.getX()) + 1;
        int deltaY = (int) Math.abs(boundaryPt2.getY() - boundaryPt1.getY()) + 1;
        for (int i = 1; i <= deltaX; i++) {
            for (int j = 1; j <= deltaY; j++) {
                Point2D temp = new Point2D(boundaryPt1.getX() + i, boundaryPt1.getY() + 1);
                resultList.add(temp);
            }
        }
        return resultList;
    }
}