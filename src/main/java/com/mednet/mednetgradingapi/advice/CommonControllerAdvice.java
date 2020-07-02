package com.mednet.mednetgradingapi.advice;

import com.mednet.mednetgradingapi.exceptions.InvalidProblemStatementUnitsException;
import com.mednet.mednetgradingapi.exceptions.InvalidTargetUnitsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ControllerAdvice is a Spring Boot component that handles exceptions across the whole application in one global
 * handling component.
 * If any of the exceptions listed below are thrown and not caught during the request, the API will terminate the current
 * request and return whatever is specified here for that specific exception.
 */
@ControllerAdvice
public class CommonControllerAdvice {

    /**
     * Logger for outputting helpful messages in the terminal/console in the event that one of these exceptions is thrown.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonControllerAdvice.class);

    /**
     * InvalidProblemStatementUnitsException is handled by the CommonControllerAdvice and cancels the current request
     * and returns "invalid" to the caller.
     * This exception occurs if an invalid problem statement has been sent to the API.
     * @param exception
     * @return String "invalid"
     */
    @ExceptionHandler(InvalidProblemStatementUnitsException.class)
    ResponseEntity<String> generalError(Exception exception) {
        LOGGER.error("Invalid problem statement", exception);
        return ResponseEntity.ok("invalid");
    }

    /**
     * InvalidTargetUnitsException is handled by the CommonControllerAdvice and cancels the current request
     * and returns "invalid" to the caller.
     * This exception occurs if invalid target units are sent to the API.
     * @param exception
     * @return String "invalid"
     */
    @ExceptionHandler(InvalidTargetUnitsException.class)
    ResponseEntity<String> invalidTargetUnitsError(Exception exception) {
        LOGGER.error("Invalid target units", exception);
        return ResponseEntity.ok("invalid");
    }

    /**
     * NumberFormatException or NullPointerException is handled by the CommonControllerAdvice and cancels the current request
     * and returns "incorrect" to the caller.
     * This exception occurs if an unparseable student response is supplied to the API.
     * @param exception
     * @return String "incorrect"
     */
    @ExceptionHandler({NumberFormatException.class, NullPointerException.class})
    ResponseEntity<String> incorrectError(Exception exception) {
        LOGGER.error("Unparseable student response", exception);
        return ResponseEntity.ok("incorrect");
    }
}
