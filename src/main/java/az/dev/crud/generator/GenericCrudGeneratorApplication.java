package az.dev.crud.generator;

import az.dev.crud.generator.config.properties.CacheProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CacheProperties.class)
public class GenericCrudGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericCrudGeneratorApplication.class, args);
    }

}
