package com.mednet.mednetgradingapi.services;

import com.mednet.mednetgradingapi.repository.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReportingService is a Spring Boot service that handles the business logic involved with several mock db queries.
 */
@Service
public class ReportingService {

    /**
     * Autowire reportingRepository so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    ReportingRepository reportingRepository;

    public void getQuestionsByProblemStatementUnits(String inputUnits) {
        reportingRepository.getQuestionsByProblemStatementUnits(inputUnits);
    }

    public void getQuestionsByTargetUnits(String targetUnits) {
        reportingRepository.getQuestionsByTargetUnits(targetUnits);
    }

    public void getQuestionsByGrade(String grade) {
        reportingRepository.getQuestionsByGrade(grade);
    }
}
