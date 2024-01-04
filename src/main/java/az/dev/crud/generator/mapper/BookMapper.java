package az.dev.crud.generator.mapper;

import az.dev.crud.generator.model.dto.BookDto;
import az.dev.crud.generator.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper extends GenericMapper<BookDto, Book> {
}
