package com.mednet.mednetgradingapi.utils;

/**
 * RoundingUtil class is a simple utility for rounding
 */
public final class RoundingUtil {

    private RoundingUtil() {
    }

    /**
     * Method for rounding a double to the ones place.
     * @param value
     * @return double that is rounded to the ones place
     */
    public static double toOnesPlace(double value) {
        return (Math.round(value));
    }
}
