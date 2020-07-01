package com.mednet.mednetgradingapi.models;

/**
 * QuestionPayload model class
 * Used to represent the entire question payload that will be sent to the API
 */
public class QuestionPayload {
    /**
     * problemStatement is the object representation of the numerical value and units of the temperature that is to be converted
     * targetUnits is the String value of the desired units for the conversion
     * studentResponse is the String value of the student's answer for the conversion problem
     */
    private ProblemStatement problemStatement;
    private String targetUnits;
    private String studentResponse;

    /**
     * Empty constructor is needed for java to unmarshall data from RestTemplate
     * This is compiled automatically if no constructor is supplied, leaving this here for clarification
     */
    public QuestionPayload() {

    }

    /**
     * Getter method for the problemStatement instance variable
     * @return problemStatement
     */
    public ProblemStatement getProblemStatement() {
        return problemStatement;
    }

    /**
     * Getter method for the targetUnits instance variable
     * @return targetUnits
     */
    public String getTargetUnits() {
        return targetUnits;
    }

    /**
     * Getter method for the studentResponse instance variable
     * @return studentResponse
     */
    public String getStudentResponse() {
        return studentResponse;
    }

}
