package com.geolab.points;

import com.geolab.constants.MainConstants;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public void swapCoordinates() {
        double temp = x;
        this.x = y;
        this.y = temp;
    }

    public void addTo(double x2, double y2) {
        this.x += x2;
        this.y += y2;
    }

    public void addTo(Point2D p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void subtractFrom(double x2, double y2) {
        this.x -= x2;
        this.y -= y2;
    }

    public void subtractFrom(Point2D p) {
        this.x -= p.getX();
        this.y -= p.getY();
    }

    public void multiply(double x2, double y2) {
        this.x *= x2;
        this.y *= y2;
    }

    public void multiply(Point2D p) {
        this.x *= p.getX();
        this.y *= p.getY();
    }

    public void divide(double x2, double y2) {
        this.x /= x2;
        this.y /= y2;
    }

    public void divide(Point2D p) {
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