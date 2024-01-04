package az.dev.crud.generator.service;

import az.dev.crud.generator.mapper.GenericMapper;
import az.dev.crud.generator.model.dto.BookDto;
import az.dev.crud.generator.model.entity.Book;
import az.dev.crud.generator.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractCrudService<BookDto, Book> {

    public BookService(CrudRepository<Book> repository,
                       GenericMapper<BookDto, Book> mapper) {
        super(repository, mapper);
    }

}
