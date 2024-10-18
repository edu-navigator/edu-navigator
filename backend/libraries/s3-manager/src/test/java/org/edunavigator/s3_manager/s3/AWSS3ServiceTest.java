package org.edunavigator.s3_manager.s3;

import org.edunavigator.s3_manager.config.S3ClientFactory;
import org.edunavigator.s3_manager.s3.utils.S3RequestBodyMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
class AWSS3ServiceTest {

    private S3Client s3Client;
    private AWSS3Service awss3Service;

    @BeforeEach
    public void setUp(){
//        s3Client = Mockito.mock(S3Client.class);
        //Need to refactor these tests they must have mocks
        s3Client = S3ClientFactory.builder()
                .accessKeyId("")
                .secretKey("")
                .accountId("")
                .region("")
                .createS3Client();;
        awss3Service = new AWSS3Service(s3Client);
    }

    @Test
    void putObject() {
        // Given
        String bucketName = "test-bucket";
        String key = "test-key";
        byte[] fileContent = "file-content".getBytes();
        //when
        awss3Service.putObject(bucketName,key,fileContent);
        //Then
        PutObjectRequest expected = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
//        verify(s3Client, times(1)).putObject(eq(expected), argThat(new S3RequestBodyMatcher(fileContent)));
    }

    @Test
    void getObject() {
        // Given
        String bucketName = "test-bucket";
        String key = "test-key";
        byte[] fileContent = "file-content".getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileContent);
        ResponseInputStream<GetObjectResponse> responseInputStream =
                new ResponseInputStream<>(GetObjectResponse.builder().build(), byteArrayInputStream);

        when(s3Client.getObject(any(GetObjectRequest.class))).thenReturn(responseInputStream);

        // When
        byte[] result = awss3Service.getObject(bucketName, key);

        // Then
        assertArrayEquals(fileContent, result);

        GetObjectRequest expectedRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        verify(s3Client, times(1)).getObject(eq(expectedRequest));
    }

    @Test
    public void testGetObjectException() throws IOException {
        // Given
        String bucketName = "test-bucket";
        String key = "test-key";
        when(s3Client.getObject(any(GetObjectRequest.class))).thenThrow(new RuntimeException("S3 error"));
        // When
        Exception exception = assertThrows(RuntimeException.class, ()->{
           awss3Service.getObject(bucketName, key);
        });
        // Then
        String expectedMessage = "S3 error";
        assertEquals(expectedMessage,exception.getMessage());
    }
}