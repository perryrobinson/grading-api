package com.mednet.mednetgradingapi.services;

import com.mednet.mednetgradingapi.exceptions.InvalidProblemStatementUnitsException;
import com.mednet.mednetgradingapi.exceptions.InvalidTargetUnitsException;
import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.models.Temperature;
import com.mednet.mednetgradingapi.repository.ReportingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class GradingServiceTest {

    @Mock
    private TemperatureService temperatureService;

    @Mock
    private ReportingRepository reportingRepository;

    private GradingService gradingService;

    @BeforeEach
    void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        gradingService = new GradingService(temperatureService, reportingRepository);
    }

    @Test
    void determineGradeIncorrectGradeComparisonResult() {
        Temperature temperature = Temperature.fromKelvin(50);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits(Temperature.CELSIUS);
        questionPayload.setStudentResponse("78.88");

        String grade = gradingService.determineGrade(questionPayload);

        assertEquals(grade, "incorrect");
    }

    @Test
    void determineGradeCorrectGradeComparisonResult() {
        Temperature temperature = Temperature.fromFahrenheit(84.2);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits(Temperature.RANKINE);
        questionPayload.setStudentResponse("543.5");

        String grade = gradingService.determineGrade(questionPayload);

        assertEquals(grade, "correct");
    }

    @Test
    void determineGradeInvalidProblemStatementUnitsResult() {
        Temperature temperature = Temperature.fromFahrenheit(102);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenThrow(InvalidProblemStatementUnitsException.class);

        assertThrows(InvalidProblemStatementUnitsException.class,
                () -> gradingService.determineGrade(questionPayload));
    }

    @Test
    void determineGradeIncorrectTargetUnitsResult() {
        Temperature temperature = Temperature.fromFahrenheit(84.2);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits("garbage");

        assertThrows(InvalidTargetUnitsException.class,
                () -> gradingService.determineGrade(questionPayload));
    }

    @Test
    void determineGradeIncorrectStudentResponseResult() {
        Temperature temperature = Temperature.fromKelvin(50);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits(Temperature.CELSIUS);
        questionPayload.setStudentResponse("cat");

        assertThrows(NumberFormatException.class,
                () -> gradingService.determineGrade(questionPayload));
    }

    @Test
    void determineGradeIncorrectStudentResponseEmptyStringResult() {
        Temperature temperature = Temperature.fromKelvin(50);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits(Temperature.CELSIUS);
        questionPayload.setStudentResponse("");

        assertThrows(NumberFormatException.class,
                () -> gradingService.determineGrade(questionPayload));
    }

    /**
     * This should never happen, Spring will return a 400 error if you pass in a null value for studentResponse
     */
    @Test
    void determineGradeIncorrectStudentResponseNullResult() {
        Temperature temperature = Temperature.fromKelvin(50);
        QuestionPayload questionPayload = new QuestionPayload();

        when(temperatureService.convert(questionPayload)).thenReturn(temperature);

        questionPayload.setTargetUnits(Temperature.CELSIUS);
        questionPayload.setStudentResponse(null);

        assertThrows(NullPointerException.class,
                () -> gradingService.determineGrade(questionPayload));
    }
}