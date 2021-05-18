package com.example.navigationapp;

public class Question {
    private String question;
    private boolean response;

    public Question(String question, boolean response) {
        this.question = question;
        this.response = response;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
