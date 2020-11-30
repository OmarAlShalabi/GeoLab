package com.geolab.points;

import com.geolab.constants.MainConstants;

public class Point2D implements Point {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setZ(double y) {
        throw new IllegalArgumentException("2D points don't have Z component.");
    }

    @Override
    public double getZ() {
        return 0;
    }

    @Override
    public void swapCoordinates() {
        double temp = x;
        this.x = y;
        this.y = temp;
    }

    @Override
    public void addTo(Point p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    @Override
    public void subtractFrom(Point p) {
        this.x -= p.getX();
        this.y -= p.getY();
    }

    @Override
    public void multiply(Point p) {
        this.x *= p.getX();
        this.y *= p.getY();
    }

    public void divide(Point p) {
        this.x /= p.getX();
        this.y /= p.getY();
    }

    public void rotateAroundOrigin(double radian) {
        double tempX;
        double tempY;
        tempX = this.x * Math.cos(radian) - this.y * Math.sin(radian);
        tempY = this.x * Math.sin(radian) + this.y * Math.cos(radian);
        this.x = tempX;
        this.y = tempY;
    }

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

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = MainConstants.ODD_PRIME * result + Double.hashCode(y);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Point2D : {X : %f, Y : %f",this.x, this.y);
    }
}