package com.geolab.vectors;

import com.geolab.points.Point;

public interface Vector {
    double getIComponent();
    double getJComponent();
    double getKComponent();
    double getRComponent();
    double getAngleComponent();
    void setStartingPoint(Point p1);
    void setEndPoint(Point p2);
    Point getStartingPoint();
    Point getEndPoint();
    double getSlope();
    void translateVector(Vector vector);
    void scaleVector(Point center, double factor);
    void rotateVector(Point center, double radian);
}
