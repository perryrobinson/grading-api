package com.mednet.mednetgradingapi.exceptions;


/**
 * UnparseableStudentResponseException class that inherits from the RuntimeException class.
 * This is used to explicitly throw exceptions related to commonly anticipated data validation problems.
 */
public class UnparseableStudentResponseException extends RuntimeException {

    public UnparseableStudentResponseException(String message, Exception exception) {
        super(message, exception);
    }
}
