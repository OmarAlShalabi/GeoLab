package com.geolab.points;

import com.geolab.constants.MainConstants;

/**
 * Class that represents Two-dimensional points in the XY plane.
 */
public class Point2D implements Point {

    private double x;
    private double y;

    /**
     * Point2D Constructor
     *
     * @param x X component
     * @param y Y component
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the value for the X component.
     * @param x X component
     */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Get the value for the X component.
     * @return X component
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Set the value for the Y component
     * @param y Y component
     */
    @Override
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the value for the Y component
     * @return Y component
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Set the value for the Z component,
     * this will throw an exception, Z compoennt
     * don't exist for two-dimensional points in the
     * XY plane
     * @param y Z component
     * @throws IllegalArgumentException 2D points don't have Z component.
     */
    @Override
    public void setZ(double y) {
        throw new IllegalArgumentException("2D points don't have Z component.");
    }

    /**
     * Get the Z component.
     * Will return zero as a defualt value.
     * @return zero value as a Z component
     */
    @Override
    public double getZ() {
        return 0;
    }

    /**
     * Swaps the X, and Y components.
     */
    @Override
    public void swapCoordinates() {
        double temp = x;
        this.x = y;
        this.y = temp;
    }

    /**
     * Adds a point to the current object.
     * Note: Adding a Point3D object will add
     * the X, and Y components only
     * @param p Point to be added to the current object.
     */
    @Override
    public void addTo(Point p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    /**
     * Subtracts a point to the current object.
     * Note: subtracting a Point3D object will subtract
     * the X, and Y components only
     * @param p Point to be subtracted to the current object.
     */
    @Override
    public void subtractFrom(Point p) {
        this.x -= p.getX();
        this.y -= p.getY();
    }

    /**
     * Multiplys a point to the current object.
     * Note: multiplying a Point3D object will multiply
     * the X, and Y components only
     * @param p Point to be multiplied to the current object.
     */
    @Override
    public void multiply(Point p) {
        this.x *= p.getX();
        this.y *= p.getY();
    }

    /**
     * Divides a point to the current object.
     * Note: dividing a Point3D object will divide
     * the X, and Y components only
     * @param p Point to be divideed to the current object.
     */
    @Override
    public void divide(Point p) {
        this.x /= p.getX();
        this.y /= p.getY();
    }

    /**
     * Rotates the current point around the origin point.
     * @param radian Angle of rotation in radian.
     */
    public void rotateAroundOrigin(double radian) {
        double tempX;
        double tempY;
        tempX = this.x * Math.cos(radian) - this.y * Math.sin(radian);
        tempY = this.x * Math.sin(radian) + this.y * Math.cos(radian);
        this.x = tempX;
        this.y = tempY;
    }

    /**
     * Compares the X, and Y components with another Object to determine if they are equal.
     * @param obj Object to be compared with
     * @return boolean indicating wether the objects are equal to each other.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point2D)) {
            return false;
        }
        Point2D point = (Point2D) obj;
        return point.getX() == this.x && point.getY() == this.y;

    }

    /**
     * Computes the hash of the object using this formula:
     *  X + P.Y where:
     *  X: X component.
     *  Y: Y component.
     *  P: Prime, taken form MainConstants class.
     * @return int value representing the hash.
     */
    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = MainConstants.ODD_PRIME * result + Double.hashCode(y);
        return result;
    }

    /**
     * Prints the object components.
     * Sample Format:
     * Point2D : {X : 1.0, Y : 1.0}
     * @return String represneting the object components.
     */
    @Override
    public String toString() {
        return String.format("Point2D : {X : %f, Y : %f}",this.x, this.y);
    }
}