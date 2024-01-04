package az.dev.crud.generator.service;

import az.dev.crud.generator.exception.NoDataFoundException;
import az.dev.crud.generator.mapper.GenericMapper;
import az.dev.crud.generator.model.entity.BaseEntity;
import az.dev.crud.generator.repository.CrudRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractCrudService<D, E extends BaseEntity> implements CrudService<D, E> {

    private final CrudRepository<E> repository;
    private final GenericMapper<D, E> mapper;

    @Override
    public void create(D dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public D getById(long id) {
        return findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> exNoDataEx(id));
    }

    @Override
    public void update(long id, D dto) {
        findById(id)
                .map(e -> mapper.toEntity(e, dto))
                .map(repository::save)
                .orElseThrow(() -> exNoDataEx(id));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    private Optional<E> findById(long id) {
        return repository.findById(id);
    }

    private NoDataFoundException exNoDataEx(long id) {
        return new NoDataFoundException("Data not found, id: " + id);
    }

}
