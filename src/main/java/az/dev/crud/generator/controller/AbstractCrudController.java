package az.dev.crud.generator.controller;

import static az.dev.crud.generator.constants.ApplicationConstants.PATH_ID;

import az.dev.crud.generator.model.dto.response.GenericResponse;
import az.dev.crud.generator.model.entity.BaseEntity;
import az.dev.crud.generator.service.CrudService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public abstract class AbstractCrudController<D, E extends BaseEntity> {

    private final CrudService<D, E> service;

    @PostMapping
    public GenericResponse save(@RequestBody @Valid D dto) {
        service.create(dto);
        return GenericResponse.ok();
    }

    @GetMapping(PATH_ID)
    public D getById(@PathVariable @Min(1) long id) {
        return service.getById(id);
    }

    @PutMapping(PATH_ID)
    public GenericResponse update(@PathVariable @Min(1) long id, @RequestBody @Valid D dto) {
        service.update(id, dto);
        return GenericResponse.ok();
    }

    @DeleteMapping(PATH_ID)
    public GenericResponse delete(@PathVariable @Min(1) long id) {
        service.delete(id);
        return GenericResponse.ok();
    }

}
