package com.geolab.utils;

import com.geolab.points.Point;
import com.geolab.points.Point2D;

public class Point2DUtils {

    private Point2DUtils() throws IllegalAccessException {
        throw new IllegalAccessException("cannot instantiate Utility class");
    }

    public static Point subtractPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(), p2.getY());
        p3.subtractFrom(p1);
        return p3;
    }

    public static Point addPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(), p2.getY());
        p3.addTo(p1);
        return p3;
    }

    public static Point multiplyPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(),p2.getY());
        p3.multiply(p1);
        return p3;
    }

    public static Point dividePoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(),p2.getY());
        p3.divide(p1);
        return p3;
    }
}