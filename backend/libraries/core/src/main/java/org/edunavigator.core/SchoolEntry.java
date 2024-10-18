package org.edunavigator.core;
public class SchoolEntry {
    private School school;
    private SchoolHistory schoolHistory;

    public SchoolEntry(School school, SchoolHistory schoolHistory) {
        this.school = school;
        this.schoolHistory = schoolHistory;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public SchoolHistory getSchoolHistory() {
        return schoolHistory;
    }

    public void setSchoolHistory(SchoolHistory schoolHistory) {
        this.schoolHistory = schoolHistory;
    }
}
