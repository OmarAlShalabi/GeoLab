package com.geolab.constants;

public class MainConstants {
    
    public static final int ODD_PRIME = 31;
    public static final double EPSILON = 1e-14;

    private MainConstants() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot insantiate a constants class");
    }
}