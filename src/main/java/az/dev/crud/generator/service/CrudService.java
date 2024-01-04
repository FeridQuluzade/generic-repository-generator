package az.dev.crud.generator.service;

import az.dev.crud.generator.model.entity.BaseEntity;

public interface CrudService<D, E extends BaseEntity> {

    void create(D dto);

    D getById(long id);

    void update(long id, D dto);

    void delete(long id);

}
