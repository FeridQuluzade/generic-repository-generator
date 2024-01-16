package az.dev.crud.generator.config;

import az.dev.crud.generator.model.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class CacheConfiguration {

    private final RedisConnectionFactory redisConnectionFactory;
    private final ObjectMapper objectMapper;

    //todo: in the future that is enough for declaring method for entity and
    @Bean
    public RedisTemplate<String, Book> sessionRedisTemplate() {
        return getRedisTemplate(Book.class);
    }

    //todo: we move this code library in the future
    private <T> RedisTemplate<String, T> getRedisTemplate(Class<T> clazz) {
        RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setDefaultSerializer(getSerializerFor(clazz));
        return redisTemplate;
    }

    private Jackson2JsonRedisSerializer<?> getSerializerFor(Class<?> clazz) {
       return new Jackson2JsonRedisSerializer<>(objectMapper, clazz);
    }

}
