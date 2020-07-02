package com.mednet.mednetgradingapi.services;

import com.mednet.mednetgradingapi.repository.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReportingService is a Spring Boot service that handles the business logic involved with several mock db queries.
 */
@Service
public class ReportingService {

    private ReportingRepository reportingRepository;

    /**
     * Autowire reportingRepository so that one instance if created and reused, instead of creating a new instance
     * every time the API is called.
     */
    @Autowired
    public ReportingService(ReportingRepository reportingRepository) {
        this.reportingRepository = reportingRepository;
    }

    /**
     * Normally, the repository would be an interface and the methods that are implemented currently in the repository
     * would be implemented here in the service. Working with a mock db here so the methods are just in the repo.
     * Method calls the getQuestionsByProblemStatementUnits method from the reportingRepository.
     * @param inputUnits
     */
    public void getQuestionsByProblemStatementUnits(String inputUnits) {
        reportingRepository.getQuestionsByProblemStatementUnits(inputUnits);
    }

    /**
     * Normally, the repository would be an interface and the methods that are implemented currently in the repository
     * would be implemented here in the service. Working with a mock db here so the methods are just in the repo.
     * Method calls the getQuestionsByTargetUnits method from the reportingRepository.
     * @param targetUnits
     */
    public void getQuestionsByTargetUnits(String targetUnits) {
        reportingRepository.getQuestionsByTargetUnits(targetUnits);
    }

    /**
     * Normally, the repository would be an interface and the methods that are implemented currently in the repository
     * would be implemented here in the service. Working with a mock db here so the methods are just in the repo.
     * Method calls the getQuestionsByGrade method from the reportingRepository.
     * @param grade
     */
    public void getQuestionsByGrade(String grade) {
        reportingRepository.getQuestionsByGrade(grade);
    }
}
