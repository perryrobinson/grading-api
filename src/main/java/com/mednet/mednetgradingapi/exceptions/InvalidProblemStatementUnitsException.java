package com.mednet.mednetgradingapi.exceptions;

/**
 * InvalidProblemStatementUnitsException class that inherits from the RuntimeException class.
 * This is used to explicitly throw exceptions related to commonly anticipated data validation problems.
 */
public class InvalidProblemStatementUnitsException extends RuntimeException{

    public InvalidProblemStatementUnitsException(String message) {
        super(message);
    }

    public InvalidProblemStatementUnitsException(String message, Exception exception) {
        super(message, exception);
    }
}
