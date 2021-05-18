package com.example.navigationapp;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static DAO instanceDAO = new DAO();
    private List<Question> questionList;

    private DAO(){
        questionList = new ArrayList<>();
    }

    public static DAO getInstanceDAO(){return instanceDAO;}

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
