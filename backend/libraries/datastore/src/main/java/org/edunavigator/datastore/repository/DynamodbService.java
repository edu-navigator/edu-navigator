package org.edunavigator.datastore.repository;
import org.edunavigator.core.SchoolEntry;
import org.edunavigator.datastore.utils.DynamodbMapper;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
public class DynamodbService {

    private final DynamoDbClient dClient;
    private final String SCHOOL_TABLE = "school";
    private final String SCHOOL_HISTORY_TABLE = "schoolHistory";
    public DynamodbService(DynamoDbClient dClient) {
        this.dClient = dClient;
    }

    public boolean addSchool(SchoolEntry schoolEntry) {
        HashMap<String, AttributeValue> school = DynamodbMapper.mapSchool(schoolEntry.getSchool());
        HashMap<String, AttributeValue> schoolHistory = DynamodbMapper.mapSchoolHistory(schoolEntry.getSchoolHistory());

        try {
            updateDynamoTable(SCHOOL_TABLE, school);
            updateDynamoTable(SCHOOL_HISTORY_TABLE, schoolHistory);
            return true;
        } catch (ResourceNotFoundException e) {
            System.err.format("Error: The DynamoDB table \"%s\" can't be found.\n", e.getMessage());
        } catch (DynamoDbException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void updateDynamoTable(String tableName, HashMap<String, AttributeValue> item) {
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        PutItemResponse response = dClient.putItem(request);
        System.out.println(tableName + " was successfully updated. Request ID: "
                + response.responseMetadata().requestId());
    }
}
