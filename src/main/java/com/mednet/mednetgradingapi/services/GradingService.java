package com.mednet.mednetgradingapi.services;

import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.models.Temperature;
import com.mednet.mednetgradingapi.repository.ReportingRepository;
import com.mednet.mednetgradingapi.utils.RoundingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GradingService is a Spring Boot service that handles the business logic involved with calling the
 * temperatureService.convert() method, normalizing both the calculated converted temperature and the student's response,
 * and then finally comparing the two to determine the grade.
 */
@Service
public class GradingService {

    /**
     * Autowire temperatureService so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    TemperatureService temperatureService;

    /**
     * Autowire gradingRepository so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    ReportingRepository reportingRepository;

    /**
     * Method used to determine the grade and return grade.
     * Compares the calculated converted temperature to the student's response and returns grade.
     * @param questionPayload
     * @return String "correct" or String "incorrect" depending on the result of the comparison
     */
    public String determineGrade(QuestionPayload questionPayload) {
        Temperature temperature = temperatureService.convert(questionPayload);
        String grade;

        double normalizedTemperatureConversion = RoundingUtil.toOnesPlace(temperature.getTempInTargetUnits(questionPayload.getTargetUnits()));
        double normalizedStudentResponse = RoundingUtil.toOnesPlace(Double.parseDouble(questionPayload.getStudentResponse()));

        // Ternary being used here.
        // Example syntax: booleanExpression ? expression1 : expression2
        grade = (normalizedTemperatureConversion == normalizedStudentResponse) ? "correct" : "incorrect";
        reportingRepository.saveQuestion(questionPayload, grade);

        return grade;
    }
}
