package com.mednet.mednetgradingapi.models;

public class GradedWorksheet {

    private QuestionPayload questionPayload;
    private String grade;

    public GradedWorksheet(QuestionPayload questionPayload, String grade) {
        this.questionPayload = questionPayload;
        this.grade = grade;
    }

    public QuestionPayload getQuestionPayload() {
        return questionPayload;
    }

    public String getGrade() {
        return grade;
    }
}
