package org.edunavigator.s3_manager.s3;

import java.io.IOException;

public interface S3Service {
    void putObject(String bucketName,String key, byte[] file);
    byte[] getObject(String bucketName, String key) throws IOException;
}
