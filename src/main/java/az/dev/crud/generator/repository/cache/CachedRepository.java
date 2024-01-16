package az.dev.crud.generator.repository.cache;

import java.util.Optional;

public interface CachedRepository<T> {

    void create(String id, T obj);

    Optional<T> findById(String id);

    void deleteById(String id);

}
