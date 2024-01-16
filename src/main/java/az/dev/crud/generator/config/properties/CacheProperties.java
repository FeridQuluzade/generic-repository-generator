package az.dev.crud.generator.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("book")
public class CacheProperties {

    private Long ttl;

}
