package com.geolab.generators;

import java.util.ArrayList;
import java.util.List;

import com.geolab.points.Point;
import com.geolab.points.Point2D;
import com.geolab.utils.Point2DUtils;

/**
 * Class responsible for generating 2D points.
 */
public class Point2DGenerator {

    private Point2DGenerator() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a Generator Class");
    }

    /**
     * Generates a number of 2D points that are uniformaly distant between each other.
     * @param boundaryPt1 Point represneting the lower-left boundary.
     * @param boundaryPt2 Point represneting the upper-right boundary.
     * Note: Boundary points are not in order, they can be swapped and produce the same result.
     * @return List of points between the two bounary points.
     */
    public static List<Point> generatePoints2DUniform(Point boundaryPt1, Point boundaryPt2) {
        if (Point2DUtils.isPointStrictlyGreaterThan(boundaryPt1,boundaryPt2)){
            Point2DUtils.swapPoints(boundaryPt1,boundaryPt2);
        }
        List<Point> resultList = new ArrayList<>();
        int deltaX = (int) Math.abs(boundaryPt2.getX() - boundaryPt1.getX()) + 1;
        int deltaY = (int) Math.abs(boundaryPt2.getY() - boundaryPt1.getY()) + 1;
        for (int i = 0; i < deltaX; i++) {
            for (int j = 0; j < deltaY; j++) {
                Point temp = new Point2D(boundaryPt1.getX() + i, boundaryPt1.getY() + j);
                resultList.add(temp);
            }
        }
        return resultList;
    }
}