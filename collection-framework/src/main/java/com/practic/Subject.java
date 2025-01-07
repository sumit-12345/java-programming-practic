package com.practic;

public class Subject {
    private String name;
    private int mark;
    private float passingMark;
    private boolean isLabTestRequired;

    public Subject() {
    }

    public Subject(String name, int mark, float passingMark, boolean isLabTestRequired) {
        this.name = name;
        this.mark = mark;
        this.passingMark = passingMark;
        this.isLabTestRequired = isLabTestRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public float getPassingMark() {
        return passingMark;
    }

    public void setPassingMark(float passingMark) {
        this.passingMark = passingMark;
    }

    public boolean isLabTestRequired() {
        return isLabTestRequired;
    }

    public void setLabTestRequired(boolean labTestRequired) {
        isLabTestRequired = labTestRequired;
    }

    public String toString() {
        return "Name : "+this.name;
    }
}
