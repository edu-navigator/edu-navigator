package org.edunavigator.s3_manager.config;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
public class AWSS3Config {
    public  S3Client BuildS3Client(String region){
        return S3Client.builder()
                .region(Region.of(region))
                .forcePathStyle(true)
                .build();
    }
}
