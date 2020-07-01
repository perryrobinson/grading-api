package com.mednet.mednetgradingapi.exceptions;

/**
 * InvalidTargetUnitsException class that inherits from the RuntimeException class.
 * This is used to explicitly throw exceptions related to commonly anticipated data validation problems.
 */
public class InvalidTargetUnitsException extends RuntimeException {

    public InvalidTargetUnitsException(String message) {
        super(message);
    }
}
