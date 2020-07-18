package com.geolab.utils;

import com.geolab.vectors.Vector2D;

public class Vector2DUtils {

    private Vector2DUtils() throws IllegalAccessException {
        throw new IllegalAccessException("cannot instantiate Utility class");
    }

    public double dotProduct(Vector2D vector1, Vector2D vector2) {
        return (vector1.getIComponent() * vector2.getIComponent() + vector1.getJComponent() * vector2.getJComponent());
    }
}