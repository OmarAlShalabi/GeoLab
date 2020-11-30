package com.geolab.utils;

import com.geolab.vectors.Vector;

public class Vector2DUtils {

    private Vector2DUtils() throws IllegalAccessException {
        throw new IllegalAccessException("cannot instantiate Utility class");
    }

    public static double dotProduct(Vector vector1, Vector vector2) {
        return (vector1.getIComponent() * vector2.getIComponent() + vector1.getJComponent() * vector2.getJComponent());
    }

    public static double crossProductKComponent(Vector vector1, Vector vector2) {
        return (vector1.getIComponent() * vector2.getJComponent()) - (vector2.getIComponent() * vector1.getJComponent());
    }
}