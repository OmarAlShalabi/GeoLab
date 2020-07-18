package com.geolab.utils;

import com.geolab.points.Point2D;

public class Point2DUtils {

    private Point2DUtils() throws IllegalAccessException {
        throw new IllegalAccessException("cannot instantiate Utility class");
    }

    public static Point2D subtractPoints(Point2D p1,Point2D p2) {
        Point2D p3 = new Point2D(p2.getX(), p2.getY());
        p3.subtractFrom(p1);
        return p3;
    }

    public static Point2D addPoints(Point2D p1, Point2D p2) {
        Point2D p3 = new Point2D(p2.getX(), p2.getY());
        p3.addTo(p1);
        return p3;
    }

    public static Point2D multiplyPoints(Point2D p1, Point2D p2) {
        Point2D p3 = new Point2D(p2.getX(),p2.getY());
        p3.multiply(p1);
        return p3;
    }

    public static Point2D dividePoints(Point2D p1, Point2D p2) {
        Point2D p3 = new Point2D(p2.getX(),p2.getY());
        p3.divide(p1);
        return p3;
    }
}