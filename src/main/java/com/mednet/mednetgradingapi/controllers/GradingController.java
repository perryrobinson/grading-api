package com.mednet.mednetgradingapi.controllers;

import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.services.GradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController is a Spring Boot controller, takes care of mapping request data to the defined request
 * handler method. Once response body is generated from the handler method, it converts it to JSON or XML response.
 * GradingController handles a POST request to return a grade when given a questionPayload.
 */
@RestController
public class GradingController {

    /**
     * Autowire gradingService so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    GradingService gradingService;

    /**
     * PostMapping annotation maps all POST requests to the specified URI expression
     * @param questionPayload
     * @return String grade, ("correct", "incorrect", "invalid")
     */
    @PostMapping("/")
    public String grade(@RequestBody QuestionPayload questionPayload) {
        return gradingService.determineGrade(questionPayload);
    }

}
