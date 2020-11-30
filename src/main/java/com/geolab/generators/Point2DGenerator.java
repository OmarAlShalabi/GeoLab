package com.geolab.generators;

import java.util.ArrayList;
import java.util.List;

import com.geolab.points.Point;
import com.geolab.points.Point2D;

public class Point2DGenerator {

    private Point2DGenerator() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a Generator Class");
    }

    public static List<Point> generatePoints2DUniform(Point boundaryPt1, Point boundaryPt2) {
        List<Point> resultList = new ArrayList<>();
        int deltaX = (int) Math.abs(boundaryPt2.getX() - boundaryPt1.getX()) + 1;
        int deltaY = (int) Math.abs(boundaryPt2.getY() - boundaryPt1.getY()) + 1;
        for (int i = 1; i <= deltaX; i++) {
            for (int j = 1; j <= deltaY; j++) {
                Point temp = new Point2D(boundaryPt1.getX() + i, boundaryPt1.getY() + 1);
                resultList.add(temp);
            }
        }
        return resultList;
    }
}