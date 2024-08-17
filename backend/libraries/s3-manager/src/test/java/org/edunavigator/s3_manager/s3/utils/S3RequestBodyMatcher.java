package org.edunavigator.s3_manager.s3.utils;
import org.mockito.ArgumentMatcher;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.IOException;
import java.util.Arrays;
public class S3RequestBodyMatcher implements ArgumentMatcher<RequestBody> {
    private final byte[] expectedContent;

    public S3RequestBodyMatcher(byte[] expectedContent) {
        this.expectedContent = expectedContent;
    }

    @Override
    public boolean matches(RequestBody requestBody) {
        try {
            return Arrays.equals(expectedContent, requestBody.contentStreamProvider().newStream().readAllBytes());
        } catch (IOException e) {
            return false;
        }
    }
}

