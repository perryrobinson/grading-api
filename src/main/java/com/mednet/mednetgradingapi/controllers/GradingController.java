package com.mednet.mednetgradingapi.controllers;

import com.mednet.mednetgradingapi.exceptions.InvalidProblemStatementUnitsException;
import com.mednet.mednetgradingapi.exceptions.InvalidTargetUnitsException;
import com.mednet.mednetgradingapi.exceptions.UnparseableStudentResponseException;
import com.mednet.mednetgradingapi.models.GradedWorksheet;
import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.services.GradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @PostMapping("/grade-question")
    public String gradeQuestion(@RequestBody QuestionPayload questionPayload) {
        return gradingService.determineGrade(questionPayload);
    }

//    /**
//     * PostMapping annotation maps all POST requests to the specified URI expression
//     * @param worksheet, list of questionPayloads
//     * @return GradedWorksheet, object that contains a list of gradedWorksheets
//     */
//    @PostMapping("/grade-worksheet")
//    public List<GradedWorksheet> gradeWorksheet(@RequestBody ArrayList<QuestionPayload> worksheet) {
//        List<GradedWorksheet> gradedWorksheets = new ArrayList<>();
//
//        for(int i=0; i<worksheet.size(); i++) {
//            String grade;
//            grade = gradingService.determineGrade(worksheet.get(i));
//
//            GradedWorksheet gradedWorksheet = new GradedWorksheet(worksheet.get(i), grade);
//            gradedWorksheets.add(gradedWorksheet);
//        }
//
//        return gradedWorksheets;
//    }

    /**
     * PostMapping annotation maps all POST requests to the specified URI expression
     * @param worksheet, list of questionPayloads
     * @return GradedWorksheet, object that contains a list of gradedWorksheets
     */
    @PostMapping("/grade-worksheet")
    public List<GradedWorksheet> gradeWorksheet(@RequestBody ArrayList<QuestionPayload> worksheet) {
        List<GradedWorksheet> gradedWorksheets = new ArrayList<>();

        for (QuestionPayload questionPayload : worksheet) {
            String grade;
            try {
                grade = gradingService.determineGrade(questionPayload);
            } catch (InvalidProblemStatementUnitsException ex) {
                grade = "invalid";
            } catch (InvalidTargetUnitsException | UnparseableStudentResponseException ex) {
                grade = "incorrect";
            }

            GradedWorksheet gradedWorksheet = new GradedWorksheet(questionPayload, grade);
            gradedWorksheets.add(gradedWorksheet);
        }

        return gradedWorksheets;
    }

}
