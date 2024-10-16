package org.edunavigator.datastore.factory;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
public class DynamoDBClientFactory {

    private static  DynamoDbClient dynamoDbClient;

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String accessKey;
        private String secretKey;
        private String accountId;
        private String region;
        public Builder accessKeyId(String accessKey){
            this.accessKey = accessKey;
            return this;
        }

        public Builder secretKey(String secretKey){
            this.secretKey = secretKey;
            return this;
        }

        public Builder accountId(String accountId){
            this.accountId = accountId;
            return this;
        }

        public Builder region(String region){
            this.region = region;
            return this;
        }

        public DynamoDbClient createDynamodbClient(){
            AwsCredentials credentials = AwsBasicCredentials
                    .builder()
                    .accessKeyId(accessKey)
                    .secretAccessKey(secretKey)
                    .accountId(accountId)
                    .build();
            Region clientRegion = Region.of(region);

            dynamoDbClient = DynamoDbClient.builder().credentialsProvider(StaticCredentialsProvider.create(credentials))
                    .region(clientRegion)
                    .build();
            return dynamoDbClient;
        }
    }
}
