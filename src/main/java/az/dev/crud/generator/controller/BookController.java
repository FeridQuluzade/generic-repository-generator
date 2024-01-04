package az.dev.crud.generator.controller;

import az.dev.crud.generator.model.dto.BookDto;
import az.dev.crud.generator.model.entity.Book;
import az.dev.crud.generator.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractCrudController<BookDto, Book> {

    public BookController(CrudService<BookDto, Book> service) {
        super(service);
    }

}
