package com.example.jsp2.popj;

import java.util.Date;

public class Score {
    private  String name;
    private  double score;
    private Date examData=new Date();

    public Score(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Date getExamData() {
        return examData;
    }

    public void setExamData(Date examData) {
        this.examData = examData;
    }

    public Score() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
