package com.geolab.utils;

import com.geolab.points.Point;
import com.geolab.points.Point2D;
import com.geolab.vectors.Vector;
import com.geolab.vectors.Vector2D;

/**
 * Utility class for 2D points.
 */
public class Point2DUtils {

    private Point2DUtils() throws IllegalAccessException {
        throw new IllegalAccessException("cannot instantiate Utility class");
    }

    /**
     * Generate a new point out of the subtraction of two points.
     * Formula: P2 - P1
     * @param p1 point to be used in subtraction.
     * @param p2 Point to be subtracted from.
     * @return new point.
     */
    public static Point subtractPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(), p2.getY());
        p3.subtractFrom(p1);
        return p3;
    }

    /**
     * Generate a new point out of the addition of two points.
     * Formula: P1 + P2
     * @param p1 first point.
     * @param p2 second point.
     * @return new point.
     */
    public static Point addPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(), p2.getY());
        p3.addTo(p1);
        return p3;
    }

    /**
     * Generate a new point out of the multiplication of two points.
     * Formula: P1 . P2
     * @param p1 first point.
     * @param p2 second point.
     * @return new point.
     */
    public static Point multiplyPoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(),p2.getY());
        p3.multiply(p1);
        return p3;
    }

    /**
     * Generate a new point out of the division of two points.
     * Formula: P1 / P2
     * @param p1 first point.
     * @param p2 second point.
     * @return new point.
     */
    public static Point dividePoints(Point p1, Point p2) {
        Point p3 = new Point2D(p2.getX(),p2.getY());
        p3.divide(p1);
        return p3;
    }

    /**
     * Swaps the values between two points.
     * @param p1 first point.
     * @param p2 second point.
     */
    public static void swapPoints(Point p1, Point p2) {
        Point temp = new Point2D(p1.getX(), p1.getY());
        p1.setX(p2.getX());
        p1.setY(p2.getY());
        p2.setX(temp.getX());
        p2.setY(temp.getY());
    }

    /**
     * Returns if the distance between the first point and the origin is strictly greater
     * than the distance between the second point and the origin.
     * @param p1 first point.
     * @param p2 second point.
     * @return Boolean to determine if the first distance is strictly greater than the second.
     */
    public static boolean isPointStrictlyGreaterThan(Point p1, Point p2) {
        Point offestPoint = new Point2D(1.0,1.0);
        Vector offsetVector = new Vector2D(new Point2D(0,0), offestPoint);
        Vector v1 = new Vector2D(new Point2D(0,0), addPoints(p1,offestPoint));
        Vector v2 = new Vector2D(new Point2D(0,0), addPoints(p2,offestPoint));
        return (v1.getRComponent() - offsetVector.getRComponent()) >
                (v2.getRComponent() - offsetVector.getRComponent());
    }
}