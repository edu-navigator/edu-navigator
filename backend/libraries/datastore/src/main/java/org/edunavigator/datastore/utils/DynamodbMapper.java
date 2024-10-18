package org.edunavigator.datastore.utils;

import org.edunavigator.core.School;
import org.edunavigator.core.SchoolHistory;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;

public class DynamodbMapper {

    public static HashMap<String, AttributeValue> mapSchool(School school) {
        HashMap<String, AttributeValue> itemValues = new HashMap<>();

        itemValues.put(DynamodbSchoolKeyMapper.SCHOOL_UUID, AttributeValue.builder().s(school.getSchoolUUID()).build());
        itemValues.put(DynamodbSchoolKeyMapper.NATIONAL_EMIS_NUMBER, AttributeValue.builder().n(school.getNationalEmisNumber()).build());
        itemValues.put(DynamodbSchoolKeyMapper.DATA_YEAR, AttributeValue.builder().s(school.getDataYear()).build());
        itemValues.put(DynamodbSchoolKeyMapper.PROVINCE, AttributeValue.builder().s(school.getProvince()).build());
        itemValues.put(DynamodbSchoolKeyMapper.INSTITUTION_NAME, AttributeValue.builder().s(school.getInstitutionName()).build());
        itemValues.put(DynamodbSchoolKeyMapper.STATUS, AttributeValue.builder().s(school.getStatus()).build());
        itemValues.put(DynamodbSchoolKeyMapper.SECTOR, AttributeValue.builder().s(school.getSector()).build());
        itemValues.put(DynamodbSchoolKeyMapper.TYPE_OF_DOE, AttributeValue.builder().s(school.getTypeOfDoe()).build());
        itemValues.put(DynamodbSchoolKeyMapper.PHASE, AttributeValue.builder().s(school.getPhase()).build());
        itemValues.put(DynamodbSchoolKeyMapper.SPECIALISATION, AttributeValue.builder().s(school.getSpecialisation()).build());
        itemValues.put(DynamodbSchoolKeyMapper.DISTRICT, AttributeValue.builder().s(school.getDistrict()).build());
        itemValues.put(DynamodbSchoolKeyMapper.LAND_OWNER, AttributeValue.builder().s(school.getLandOwner()).build());
        itemValues.put(DynamodbSchoolKeyMapper.EXTENDED_DEPARTMENT, AttributeValue.builder().s(school.getExtendedDepartment()).build());
        itemValues.put(DynamodbSchoolKeyMapper.EXAM_CENTRE, AttributeValue.builder().s(school.getExamCentre()).build());

        if (school.getGisLongitude() != null) {
            itemValues.put(DynamodbSchoolKeyMapper.GIS_LONGITUDE, AttributeValue.builder().n(school.getGisLongitude().toString()).build());
        }
        if (school.getGisLatitude() != null) {
            itemValues.put(DynamodbSchoolKeyMapper.GIS_LATITUDE, AttributeValue.builder().n(school.getGisLatitude().toString()).build());
        }

        itemValues.put(DynamodbSchoolKeyMapper.DISTRICT_MUN_NAME, AttributeValue.builder().s(school.getDistrictMunName()).build());
        itemValues.put(DynamodbSchoolKeyMapper.STREET_ADDRESS, AttributeValue.builder().s(school.getStreetAddress()).build());
        itemValues.put(DynamodbSchoolKeyMapper.POSTAL_ADDRESS, AttributeValue.builder().s(school.getPostalAddress()).build());
        itemValues.put(DynamodbSchoolKeyMapper.TELEPHONE, AttributeValue.builder().s(school.getTelephone()).build());
        itemValues.put(DynamodbSchoolKeyMapper.QUINTILE, AttributeValue.builder().s(school.getQuintile()).build());

        if (school.getRegistrationDate() != null) {
            itemValues.put(DynamodbSchoolKeyMapper.REGISTRATION_DATE, AttributeValue.builder().s(school.getRegistrationDate().toString()).build());
        }
        if (school.getNoFeeSchool() != null) {
            itemValues.put(DynamodbSchoolKeyMapper.NO_FEE_SCHOOL, AttributeValue.builder().bool(school.getNoFeeSchool()).build());
        }

        itemValues.put(DynamodbSchoolKeyMapper.AREA_TYPE, AttributeValue.builder().s(school.getAreaType()).build());

        return itemValues;
    }

    public static HashMap<String, AttributeValue> mapSchoolHistory(SchoolHistory schoolHistory) {
        HashMap<String, AttributeValue> itemValues = new HashMap<>();

        itemValues.put(DynamodbSchoolHistoryKeyMapper.SCHOOL_UUID, AttributeValue.builder().s(schoolHistory.getSchoolUUID()).build());
        itemValues.put(DynamodbSchoolHistoryKeyMapper.HISTORY_UUID, AttributeValue.builder().s(schoolHistory.getHistoryUUID()).build());

        if (schoolHistory.getNumberOfLearners() != null) {
            itemValues.put(DynamodbSchoolHistoryKeyMapper.NUMBER_OF_LEARNERS, AttributeValue.builder().n(schoolHistory.getNumberOfLearners().toString()).build());
        }

        if (schoolHistory.getNumberOfTeachers() != null) {
            itemValues.put(DynamodbSchoolHistoryKeyMapper.NUMBER_OF_TEACHERS, AttributeValue.builder().n(schoolHistory.getNumberOfTeachers().toString()).build());
        }

        if (schoolHistory.getYear() != null) {
            itemValues.put(DynamodbSchoolHistoryKeyMapper.YEAR, AttributeValue.builder().n(schoolHistory.getYear()).build());
        }

        return itemValues;
    }



}
