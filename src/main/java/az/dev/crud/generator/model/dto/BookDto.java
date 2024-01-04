package az.dev.crud.generator.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String name;
    private String author;
    private String description;

}
