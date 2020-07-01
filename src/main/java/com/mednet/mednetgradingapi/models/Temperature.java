package com.mednet.mednetgradingapi.models;

import com.mednet.mednetgradingapi.exceptions.InvalidTargetUnitsException;

/**
 * Temperature converter class
 * Takes in a temperature and converts it to kelvin
 * Once the temperature is in kelvin, it can be converted to any other temperature units
 */
public class Temperature {
    /**
     * public static final String variables used here so they can be referenced easily by other classes and methods
     * but easily updated from the Temperature class.
     * degreesKelvin is how the temperature is stored in kelvin, to later be converted to the target units
     */
    public static final String FAHRENHEIT = "fahrenheit";
    public static final String CELSIUS = "celsius";
    public static final String RANKINE = "rankine";
    public static final String KELVIN = "kelvin";

    private double degreesKelvin;

    /**
     * Private constructor used by the other static methods
     * @param degrees Kelvin
     */
    private Temperature(double degrees) {
        this.degreesKelvin = degrees;
    }

    /**
     * Create a temperature object
     * @param degrees Fahrenheit
     * @return Temperature object, converted from Fahrenheit
     */
    public static Temperature fromFahrenheit(double degrees) {
        return new Temperature((5.0/9.0) * (degrees - 32) + 273.15);
    }

    /**
     * Create a temperature object
     * @param degrees Celsius
     * @return Temperature object, converted from Celsius
     */
    public static Temperature fromCelsius(double degrees) {
        return new Temperature(degrees + 273.15);
    }

    /**
     * Create a temperature object
     * @param degrees Rankine
     * @return Temperature object, converted from Rankine
     */
    public static Temperature fromRankine(double degrees) {
        return new Temperature((5.0/9.0) * degrees);
    }

    /**
     * Create a temperature object
     * @param degrees Kelvin
     * @return Temperature object, converted from Kelvin
     */
    public static Temperature fromKelvin(double degrees) {
        return new Temperature(degrees);
    }

    /**
     * Converts the current Kelvin temperature to Fahrenheit
     * @return double degrees, Fahrenheit
     */
    public double toFahrenheit() {
        return ((5.0/9.0) * (this.degreesKelvin - 459.67));
    }

    /**
     * Converts the current Kelvin temperature to Celsius
     * @return double degrees, Celsius
     */
    public double toCelsius() {
        return (this.degreesKelvin - 273.15);
    }


    /**
     * Converts the current Kelvin temperature to Rankine
     * @return double degrees, Rankine
     */
    public double toRankine() {
        return ((9.0/5.0) * this.degreesKelvin);
    }

    /**
     * Converts the current Kelvin temperature to Kelvin
     * @return double degrees, Kelvin
     */
    public double toKelvin() {
        return this.degreesKelvin;
    }

    /**
     * Method used to convert the current instance of the Temperature object to the desired target units.
     * Throws an InvalidTargetUnitsException if invalid targetUnits are passed to the method.
     * @param targetUnits
     * @return double degrees in targetUnits, or returns "invalid" if invalid targetUnits are passed.
     */
    public double getTempInTargetUnits(String targetUnits) {

        switch(targetUnits.toLowerCase()) {

            case FAHRENHEIT:
                return this.toFahrenheit();
            case CELSIUS:
                return this.toCelsius();
            case RANKINE:
                return this.toRankine();
            case KELVIN:
                return this.toKelvin();
            default:
                // return invalid grade
                throw new InvalidTargetUnitsException("Invalid target units defined!");
        }
    }
}
