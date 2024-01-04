package az.dev.crud.generator.repository;

import az.dev.crud.generator.model.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book> {
}
