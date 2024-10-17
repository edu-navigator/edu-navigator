package org.edunavigator.core;
public class SchoolHistory {
    private String historyUUID;
    private String schoolUUID;
    private String year;
    private Integer numberOfLearners;
    private Integer numberOfTeachers;

    public String getHistoryUUID() {
        return historyUUID;
    }

    public void setHistoryUUID(String historyUUID) {
        this.historyUUID = historyUUID;
    }

    public String getSchoolUUID() {
        return schoolUUID;
    }

    public void setSchoolUUID(String schoolUUID) {
        this.schoolUUID = schoolUUID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getNumberOfLearners() {
        return numberOfLearners;
    }

    public void setNumberOfLearners(Integer numberOfLearners) {
        this.numberOfLearners = numberOfLearners;
    }

    public Integer getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(Integer numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }
}
