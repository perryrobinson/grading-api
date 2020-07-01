package com.mednet.mednetgradingapi.services;

import com.mednet.mednetgradingapi.exceptions.InvalidProblemStatementUnitsException;
import com.mednet.mednetgradingapi.models.QuestionPayload;
import com.mednet.mednetgradingapi.models.Temperature;
import org.springframework.stereotype.Service;

/**
 * TemperatureService is a Spring Boot service that handles the business logic involved in converting temperatures
 */
@Service
public class TemperatureService {

    /**
     * The convert method in this service does most of the heavy lifting for this API.
     * calculatedResult is initialized before any calculations begin, this is a Temperature object that will be used
     * to return the converted temperature.
     * A try block is put in place here, with a switch statement used to call the necessary static method that is
     * needed to perform the conversion.
     * Double.parseDouble is used to parse the String questionPayload.getProblemStatement().getInputTemperature() and
     * pull out a Double value if there is one in the String.
     * If questionPayload.getProblemStatement().getInputUnits() does not contain
     * one of the four valid temperature units, then an invalid problemStatement was supplied and
     * an InvalidProblemStatementUnitsException is thrown.
     * The catch statement will catch NullPointerException or NumberFormatException, which will also throw an
     * InvalidProblemStatementUnitsException.
     *
     * @param questionPayload
     * @return calculatedResult
     */

    public Temperature convert(QuestionPayload questionPayload) {
        Temperature calculatedResult;

        try {
            switch (questionPayload.getProblemStatement().getInputUnits().toLowerCase()) {

                case Temperature.FAHRENHEIT:
                    calculatedResult = Temperature.fromFahrenheit(Double.parseDouble(questionPayload.getProblemStatement().getInputTemperature()));
                    break;
                case Temperature.CELSIUS:
                    calculatedResult = Temperature.fromCelsius(Double.parseDouble(questionPayload.getProblemStatement().getInputTemperature()));
                    break;
                case Temperature.RANKINE:
                    calculatedResult = Temperature.fromRankine(Double.parseDouble(questionPayload.getProblemStatement().getInputTemperature()));
                    break;
                case Temperature.KELVIN:
                    calculatedResult = Temperature.fromKelvin(Double.parseDouble(questionPayload.getProblemStatement().getInputTemperature()));
                    break;
                default:
                    // return invalid grade
                    throw new InvalidProblemStatementUnitsException("No problem statement units defined!");
            }
        }
            catch (NullPointerException | NumberFormatException ex) {
                throw new InvalidProblemStatementUnitsException("Problem translating problem statement to Temperature!", ex);
            }

            return calculatedResult;
        }
    }
