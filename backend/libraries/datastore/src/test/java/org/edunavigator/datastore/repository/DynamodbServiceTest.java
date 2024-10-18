package org.edunavigator.datastore.repository;

import org.edunavigator.core.School;
import org.edunavigator.core.SchoolEntry;
import org.edunavigator.core.SchoolHistory;
import org.edunavigator.datastore.factory.DynamoDBClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DynamodbServiceTest {
    private School school;
    private SchoolHistory schoolHistory;
    private SchoolEntry schoolEntry;
    private DynamoDbClient dClient;
    private DynamodbService dynamodbService;
    //Need to refactor these tests they must have mocks
    @BeforeEach
    void setUp() {
        String uuid = UUID.randomUUID().toString();
       school =  new School(
               uuid,           // schoolUUID
                "123456",               // nationalEmisNumber
                "2024",                      // dataYear
                "Eastern Cape",              // province
                "Springfield High School",   // institutionName
                "Active",                    // status
                "Public",                    // sector
                "General",                   // typeOfDoe
                "High School",               // phase
                "Science",                   // specialisation
                "District 10",               // district
                "Government",                // landOwner
                "Department of Education",   // extendedDepartment
                "EC001",                     // examCentre
                26.2041,                     // gisLongitude
                28.0473,                     // gisLatitude
                "Nelson Mandela Bay",        // districtMunName
                "123 Main St",               // streetAddress
                "P.O. Box 456",              // postalAddress
                "012-345-6789",              // telephone
                "3",                         // quintile
                LocalDate.of(1990, 1, 1),    // registrationDate
                true,                        // noFeeSchool
                "Urban",                     // areaType
                1500,                        // numberOfLearners
                50                           // numberOfTeachers
        );

        schoolHistory = new SchoolHistory();
        schoolHistory.setSchoolUUID(uuid);
        uuid = UUID.randomUUID().toString();
        schoolHistory.setHistoryUUID(uuid);
        schoolHistory.setYear("2023");
        schoolHistory.setNumberOfLearners(1400);
        schoolHistory.setNumberOfTeachers(48);

        schoolEntry = new SchoolEntry(school,schoolHistory);

        dClient = DynamoDBClientFactory
                .builder()
                .accessKeyId("")
                .secretKey("")
                .accountId("")
                .region("")
                .createDynamodbClient();
        dynamodbService = new DynamodbService(dClient);
    }

    @Test
    public void testingAdd(){
        boolean results = dynamodbService.addSchool(schoolEntry);
        assertTrue(results);
    }




}