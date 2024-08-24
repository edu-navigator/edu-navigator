package org.edunavigator.s3_manager.s3;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
public class AWSS3Service implements S3Service{
    S3Client s3Client;
    public  AWSS3Service(S3Client s3Client){
        this.s3Client = s3Client;
    }
    @Override
    public void putObject(String bucketName,String key, byte[] file) {
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(objectRequest, RequestBody.fromBytes(file));
    }
    @Override
    public byte[] getObject(String bucketName, String key) {

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        ResponseInputStream<GetObjectResponse> responseObject = s3Client.getObject(getObjectRequest);

        try{
            return responseObject.readAllBytes();
        }catch (Exception ex){
            return null;
        }
    }
}
