package org.edunavigator.database_lib.entity;
import java.time.LocalDate;
public class SchoolEntity {
    private String schoolUUID;
    private String nationalEmisNumber;
    private String dataYear;
    private String province;
    private String institutionName;
    private String status;
    private String sector;
    private String typeOfDoe;
    private String phase;
    private String specialisation;
    private String district;
    private String landOwner;
    private String extendedDepartment;
    private String examCentre;
    private Double gisLongitude;
    private Double gisLatitude;
    private String districtMunName;
    private String streetAddress;
    private String postalAddress;
    private String telephone;
    private String quintile;
    private LocalDate registrationDate;
    private Boolean noFeeSchool;
    private String areaType;
    private Integer numberOfLearners;
    private Integer numberOfTeachers;

    public SchoolEntity(String schoolUUID, String nationalEmisNumber,
                        String dataYear, String province,
                        String institutionName, String status,
                        String sector, String typeOfDoe,
                        String phase, String specialisation,
                        String district, String landOwner,
                        String extendedDepartment, String examCentre,
                        Double gisLongitude, Double gisLatitude,
                        String districtMunName, String streetAddress,
                        String postalAddress, String telephone,
                        String quintile, LocalDate registrationDate,
                        Boolean noFeeSchool,String areaType,
                        Integer numberOfLearners,Integer numberOfTeachers) {
        this.schoolUUID = schoolUUID;
        this.nationalEmisNumber = nationalEmisNumber;
        this.dataYear = dataYear;
        this.province = province;
        this.institutionName = institutionName;
        this.status = status;
        this.sector = sector;
        this.typeOfDoe = typeOfDoe;
        this.phase = phase;
        this.specialisation = specialisation;
        this.district = district;
        this.landOwner = landOwner;
        this.extendedDepartment = extendedDepartment;
        this.examCentre = examCentre;
        this.gisLongitude = gisLongitude;
        this.gisLatitude = gisLatitude;
        this.districtMunName = districtMunName;
        this.streetAddress = streetAddress;
        this.postalAddress = postalAddress;
        this.telephone = telephone;
        this.quintile = quintile;
        this.registrationDate = registrationDate;
        this.noFeeSchool = noFeeSchool;
        this.areaType = areaType;
        this.numberOfLearners = numberOfLearners;
        this.numberOfTeachers = numberOfTeachers;
    }

    public SchoolEntity() {}

    public String getSchoolUUID() {
        return schoolUUID;
    }

    public void setSchoolUUID(String schoolUUID) {
        this.schoolUUID = schoolUUID;
    }

    public String getNationalEmisNumber() {
        return nationalEmisNumber;
    }

    public void setNationalEmisNumber(String nationalEmisNumber) {
        this.nationalEmisNumber = nationalEmisNumber;
    }

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        this.dataYear = dataYear;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTypeOfDoe() {
        return typeOfDoe;
    }

    public void setTypeOfDoe(String typeOfDoe) {
        this.typeOfDoe = typeOfDoe;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLandOwner() {
        return landOwner;
    }

    public void setLandOwner(String landOwner) {
        this.landOwner = landOwner;
    }

    public String getExtendedDepartment() {
        return extendedDepartment;
    }

    public void setExtendedDepartment(String extendedDepartment) {
        this.extendedDepartment = extendedDepartment;
    }

    public String getExamCentre() {
        return examCentre;
    }

    public void setExamCentre(String examCentre) {
        this.examCentre = examCentre;
    }

    public Double getGisLongitude() {
        return gisLongitude;
    }

    public void setGisLongitude(Double gisLongitude) {
        this.gisLongitude = gisLongitude;
    }

    public Double getGisLatitude() {
        return gisLatitude;
    }

    public void setGisLatitude(Double gisLatitude) {
        this.gisLatitude = gisLatitude;
    }

    public String getDistrictMunName() {
        return districtMunName;
    }

    public void setDistrictMunName(String districtMunName) {
        this.districtMunName = districtMunName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQuintile() {
        return quintile;
    }

    public void setQuintile(String quintile) {
        this.quintile = quintile;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getNoFeeSchool() {
        return noFeeSchool;
    }

    public void setNoFeeSchool(Boolean noFeeSchool) {
        this.noFeeSchool = noFeeSchool;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
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
