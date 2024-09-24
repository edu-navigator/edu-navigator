package org.edunavigator.solr.model;
import org.apache.solr.client.solrj.beans.Field;
public class SchoolSolrBean {
    @Field
    private String schoolUUID;
    @Field
    private String natEmis;
    @Field
    private String institutionName;
    @Field
    private String province;
    @Field
    private String status;
    @Field
    private String sector;
    @Field
    private String typeOfDoe;
    @Field
    private String phase;
    @Field
    private String specialisation;
    @Field
    private String district;
    @Field
    private String examCentre;
    @Field
    private String streetAddress;
    @Field
    private Boolean noFeeSchool;
    @Field
    private String areaType;
    public static class  Builder{
        private SchoolSolrBean school = new SchoolSolrBean();
        public Builder setSchoolUUID(String uuid){
            this.school.schoolUUID = uuid;
            return this;
        }

        public Builder setNatEmis(String nationalEmis){
            this.school.natEmis = nationalEmis;
            return this;
        }
        public Builder setInstitutionName(String institutionName) {
            this.school.institutionName = institutionName;
            return this;
        }

        public Builder setProvince(String province) {
            this.school.province = province;
            return this;
        }

        public Builder setStatus(String status) {
            this.school.status = status;
            return this;
        }

        public Builder setSector(String sector) {
            this.school.sector = sector;
            return this;
        }

        public Builder setTypeOfDoe(String typeOfDoe) {
            this.school.typeOfDoe = typeOfDoe;
            return this;
        }

        public Builder setPhase(String phase) {
            this.school.phase = phase;
            return this;
        }

        public Builder setSpecialisation(String specialisation) {
            this.school.specialisation = specialisation;
            return this;
        }

        public Builder setDistrict(String district) {
            this.school.district = district;
            return this;
        }

        public Builder setExamCentre(String examCentre) {
            this.school.examCentre = examCentre;
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.school.streetAddress = streetAddress;
            return this;
        }

        public Builder setNoFeeSchool(Boolean noFeeSchool) {
            this.school.noFeeSchool = noFeeSchool;
            return this;
        }

        public Builder setAreaType(String areaType) {
            this.school.areaType = areaType;
            return this;
        }

        public SchoolSolrBean build() {
            return this.school;
        }
    }
}