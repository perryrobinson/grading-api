package com.mednet.mednetgradingapi.repository;

import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.models.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Mock repository, this would normally be an interface that would extend to something like JpaRepository
 */
@Repository
public class ReportingRepository {

    Logger LOGGER = LoggerFactory.getLogger(ReportingRepository.class);

    public void saveQuestion(QuestionPayload questionPayload) {
        LOGGER.info("Saving question to database...");
    }

    public void getQuestionsByProblemStatementUnits(String inputUnits) {
        if (inputUnits.toLowerCase().contains(Temperature.FAHRENHEIT) ||
            inputUnits.toLowerCase().contains(Temperature.CELSIUS) ||
            inputUnits.toLowerCase().contains(Temperature.RANKINE) ||
            inputUnits.toLowerCase().contains(Temperature.KELVIN)) {
            LOGGER.info("Getting all records with " + inputUnits + " problem statement units.");
        } else {
            LOGGER.info("Error, please enter a valid temperature unit (fahrenheit, celsius, rankine, or kelvin)");
        }
    }

    public void getQuestionsByTargetUnits(String targetUnits) {
        LOGGER.info("Getting all records with " + targetUnits + " target units.");
        if (targetUnits.toLowerCase().contains(Temperature.FAHRENHEIT) ||
                targetUnits.toLowerCase().contains(Temperature.CELSIUS) ||
                targetUnits.toLowerCase().contains(Temperature.RANKINE) ||
                targetUnits.toLowerCase().contains(Temperature.KELVIN)) {
            LOGGER.info("Getting all records with " + targetUnits + " target units.");
        } else {
            LOGGER.info("Error, please enter a valid temperature unit (fahrenheit, celsius, rankine, or kelvin)");
        }
    }

    public void getQuestionsByGrade(String grade) {
        LOGGER.info("Getting all records with " + grade + " grade.");
        if (grade.toLowerCase().contains("correct") ||
                grade.toLowerCase().contains("incorrect") ||
                grade.toLowerCase().contains("invalid") ) {
            LOGGER.info("Getting all records with " + grade + " grade.");
        } else {
            LOGGER.info("Error, please enter a valid grade(correct, incorrect, or invalid)");
        }
    }

}
