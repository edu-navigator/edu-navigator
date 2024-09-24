package org.edunavigator.solr.api;
public class SchoolSolrResponse {
    private String schoolUUID;
    private String natEmis;
    private String institutionName;
    private String province;
    private String status;
    private String sector;
    private String typeOfDoe;
    private String phase;
    private String specialisation;
    private String district;
    private String examCentre;
    private String streetAddress;
    private Boolean noFeeSchool;
    private String areaType;
    public SchoolSolrResponse(String schoolUUID,
                              String natEmis,
                              String institutionName,
                              String province,
                              String status,
                              String sector,
                              String typeOfDoe,
                              String phase,
                              String specialisation,
                              String district,
                              String examCentre,
                              String streetAddress,
                              Boolean noFeeSchool,
                              String areaType) {
        this.schoolUUID = schoolUUID;
        this.natEmis = natEmis;
        this.institutionName = institutionName;
        this.province = province;
        this.status = status;
        this.sector = sector;
        this.typeOfDoe = typeOfDoe;
        this.phase = phase;
        this.specialisation = specialisation;
        this.district = district;
        this.examCentre = examCentre;
        this.streetAddress = streetAddress;
        this.noFeeSchool = noFeeSchool;
        this.areaType = areaType;
    }

    public SchoolSolrResponse() {
    }

    public String getSchoolUUID() {
        return schoolUUID;
    }

    public void setSchoolUUID(String schoolUUID) {
        this.schoolUUID = schoolUUID;
    }

    public String getNatEmis() {
        return natEmis;
    }

    public void setNatEmis(String natEmis) {
        this.natEmis = natEmis;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getExamCentre() {
        return examCentre;
    }

    public void setExamCentre(String examCentre) {
        this.examCentre = examCentre;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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
}
