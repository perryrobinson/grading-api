package com.mednet.mednetgradingapi.controllers;

import com.mednet.mednetgradingapi.services.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController is a Spring Boot controller, takes care of mapping request data to the defined request
 * handler method. Once response body is generated from the handler method, it converts it to JSON or XML response.
 * ReportingController handles various GET requests for the mock db queries.
 */
@RestController
public class ReportingController {

    /**
     * Autowire reportingService so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    ReportingService reportingService;

    /**
     * GetMapping annotation maps all GET requests to the specified URI expression
     * Method calls the getQuestionsByProblemStatementUnits method from the reportingService
     * @param inputUnits
     */
    @GetMapping("/reporting/inputUnits/")
    public void getQuestionsByProblemStatementUnits(@RequestParam String inputUnits) {
        reportingService.getQuestionsByProblemStatementUnits(inputUnits.toLowerCase());
    }

    /**
     * GetMapping annotation maps all GET requests to the specified URI expression
     * Method calls the getQuestionsByTargetUnits method from the reportingService
     * @param targetUnits
     */
    @GetMapping("/reporting/targetUnits/")
    public void getQuestionsByTargetUnits(@RequestParam String targetUnits) {
        reportingService.getQuestionsByTargetUnits(targetUnits.toLowerCase());
    }

    /**
     * GetMapping annotation maps all GET requests to the specified URI expression
     * Method calls the getQuestionsByGrade method from the reportingService
     * @param grade
     */
    @GetMapping("/reporting/grade/")
    public void getQuestionsByGrade(@RequestParam String grade) {
        reportingService.getQuestionsByGrade(grade.toLowerCase());
    }
}
