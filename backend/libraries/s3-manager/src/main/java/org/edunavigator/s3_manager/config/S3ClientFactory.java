package org.edunavigator.s3_manager.config;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class S3ClientFactory {

    private static S3Client s3Client;

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

        public S3Client createS3Client(){
            AwsCredentials credentials = AwsBasicCredentials
                    .builder()
                    .accessKeyId(accessKey)
                    .secretAccessKey(secretKey)
                    .accountId(accountId)
                    .build();
            Region clientRegion = Region.of(region);

            s3Client = S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(credentials))
                    .region(clientRegion)
                    .build();
            return s3Client;
        }
    }
}
