package com.geolab.vectors;

import java.util.Objects;

import com.geolab.constants.MainConstants;
import com.geolab.points.Point2D;
import com.geolab.utils.Point2DUtils;

public class Vector2D {
    private Point2D p1;
    private Point2D p2;
    private double i;
    private double j;
    private double r;
    private double theta;
    private double slope;

    public Vector2D(Point2D p1, Point2D p2) {
        Point2D tempP1 = new Point2D(p1.getX(), p1.getY());
        Point2D tempP2 = new Point2D(p2.getX(), p2.getY());
        if (tempP1.equals(tempP2)) {
            throw new IllegalArgumentException("Vector2D instantiation requires two different points");
        }
        this.p1 = Objects.requireNonNull(tempP1);
        this.p2 = Objects.requireNonNull(tempP2);
        computeAllComponents();
    }

    private void computeAllComponents() {
        computeVectorComponents();
        computePolarComponents();
        computeSlope();
    }

    private void computePolarComponents() {
        this.r = Math.sqrt(this.i * this.i + this.j * this.j);
        this.theta = Math.atan2(this.j, this.i);
    }

    private void computeVectorComponents() {
        Point2D pSubtraction = Point2DUtils.subtractPoints(this.p1, this.p2);
        this.i = pSubtraction.getX();
        this.j = pSubtraction.getY();
    }

    public double getIComponent() {
        return this.i;
    }

    public double getJComponent() {
        return this.j;
    }

    public double getRComponent() {
        return this.r;
    }

    public double getThetaComponent() {
        return this.theta;
    }

    public void setStartingPoint(Point2D p1) {
        Point2D tempP1 = new Point2D(p1.getX(), p1.getY());
        this.p1 = tempP1;
        computeAllComponents();
    }

    public void setEndPoint(Point2D p2) {
        Point2D tempP2 = new Point2D(p2.getX(), p2.getY());
        this.p2 = tempP2;
        computeAllComponents();
    }

    public Point2D getStartingPoint() {
        return this.p1;
    }

    public Point2D getEndPoint() {
        return this.p2;
    }

    public double getSlope() {
        return slope;
    }

    public void translateVector(Vector2D vector) {
        Vector2D tempVector = new Vector2D(vector.getStartingPoint(), vector.getEndPoint());
        this.p1.addTo(tempVector.getStartingPoint());
        this.p2.addTo(tempVector.getEndPoint());
        setStartingPoint(p1);
        setEndPoint(p2);
    }

    public void scaleVector(Point2D center, double factor) {
        Point2D tempP1 = Point2DUtils.subtractPoints(center, this.p1);
        Point2D tempP2 = Point2DUtils.subtractPoints(center, this.p2);
        tempP1.multiply(factor, factor);
        tempP2.multiply(factor, factor);
        tempP1.addTo(center);
        tempP2.addTo(center);
        setStartingPoint(tempP1);
        setEndPoint(tempP2);
    }

    public void rotateVector(Point2D center, double radian) {
        Point2D tempP1 = Point2DUtils.subtractPoints(center, this.p1);
        Point2D tempP2 = Point2DUtils.subtractPoints(center, this.p2);
        tempP1.rotateAroundOrigin(radian);
        tempP2.rotateAroundOrigin(radian);
        tempP1.addTo(center);
        tempP2.addTo(center);
        setStartingPoint(tempP1);
        setEndPoint(tempP2);
    }

    private void computeSlope() {
        double deltaY = this.p2.getY() - this.p1.getY();
        double deltaX = this.p2.getX() - this.p1.getX();
        if (deltaY <= MainConstants.EPSILON && deltaY >= -1 * MainConstants.EPSILON) {
            this.slope = Double.NaN;
        } else {
            this.slope = deltaY / deltaX;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vector2D)) {
            return false;
        }
        Vector2D objVector2D = (Vector2D) obj;
        return objVector2D.getStartingPoint() == this.p1 && objVector2D.getEndPoint() == this.p2;
    }

    @Override
    public int hashCode() {
        int result = this.p1.hashCode();
        result = MainConstants.ODD_PRIME * result + this.p2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "Vector2D : { Starting Point: %f, Ending Point: %f, real-part: %f, imaginary-part: %f,"
                        + "Vector norm: %f, Vector angle: %f, Slope: %f",
                this.p1.toString(), this.p2.toString(), this.i, this.j, this.r, this.theta, this.slope);
    }
}