package org.edunavigator.ingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.edunavigator.ingestion.*","org.edunavigator.s3_manager.config","org.edunavigator.security.config"} )
@EnableAutoConfiguration
public class IngestionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IngestionServiceApplication.class,args);
    }


}
