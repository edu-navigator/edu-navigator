import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.edunavigator.s3_manager.config"} )
@EnableAutoConfiguration
public class IngestionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IngestionServiceApplication.class,args);
    }


}
