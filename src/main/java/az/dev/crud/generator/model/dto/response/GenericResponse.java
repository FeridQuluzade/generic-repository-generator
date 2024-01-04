package az.dev.crud.generator.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {

    private String message;

    public static GenericResponse ok() {
        return new GenericResponse("Operation successfully completed");
    }

}
