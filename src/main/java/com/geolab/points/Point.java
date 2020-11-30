package com.geolab.points;

public interface Point {
    void setX(double x);
    double getX();
    void setY(double y);
    double getY();
    void setZ(double y);
    double getZ();
    void swapCoordinates();
    void addTo(Point p);
    void subtractFrom(Point p);
    void divide(Point p);
    void multiply(Point p);
    void rotateAroundOrigin(double radian);
}
