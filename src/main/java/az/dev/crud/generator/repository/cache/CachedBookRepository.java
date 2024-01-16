package az.dev.crud.generator.repository.cache;

import az.dev.crud.generator.config.properties.CacheProperties;
import az.dev.crud.generator.model.entity.Book;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CachedBookRepository extends AbstractCachedRepository<Book> {

    public CachedBookRepository(RedisTemplate<String, Book> redisTemplate,
                                CacheProperties cacheProperties) {
        super(redisTemplate, cacheProperties.getTtl());
    }

}
