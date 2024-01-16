package az.dev.crud.generator.repository.cache;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class AbstractCachedRepository<T> implements CachedRepository<T> {

    private final RedisTemplate<String, T> redisTemplate;
    private final Long ttl;

    public AbstractCachedRepository(RedisTemplate<String, T> redisTemplate,
                                    Long ttl) {
        this.redisTemplate = redisTemplate;
        this.ttl = ttl;
    }

    @Override
    public void create(String id, T obj) {
        redisTemplate.opsForValue()
                .set(id, obj, ttl, TimeUnit.SECONDS);
    }

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id));
    }

    @Override
    public void deleteById(String id) {
        redisTemplate.delete(id);
    }

}
