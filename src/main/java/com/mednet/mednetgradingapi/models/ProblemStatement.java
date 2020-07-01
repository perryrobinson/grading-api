package com.mednet.mednetgradingapi.models;

/**
 * ProblemStatement model class
 * Used to represent the problem statement
 * example "84.2 Fahrenheit"
 */
public class ProblemStatement {

    /**
     * inputTemperature is the String numerical value of the temperature
     * inputUnits is the String text of the temperature units
     */
    private String inputTemperature;
    private String inputUnits;

    /**
     * Empty constructor is needed for java to unmarshall data from RestTemplate
     * This is compiled automatically if no constructor is supplied, leaving this here for clarification
     */
    public ProblemStatement() {
    }

    /**
     * Getter method for the inputTemperature instance variable
     * @return inputTemperature
     */
    public String getInputTemperature() {
        return inputTemperature;
    }

    /**
     * Getter method for the inputUnits instance variable
     * @return inputUnits
     */
    public String getInputUnits() {
        return inputUnits;
    }
}
