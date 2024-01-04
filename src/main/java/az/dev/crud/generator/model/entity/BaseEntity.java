package az.dev.crud.generator.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.OptimizableGenerator;
import org.hibernate.id.enhanced.TableGenerator;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "pooled_sequence")
    @GenericGenerator(name = "pooled_sequence", parameters = {
            @Parameter(name = TableGenerator.VALUE_COLUMN_PARAM, value = "next"),
            @Parameter(name = TableGenerator.CONFIG_PREFER_SEGMENT_PER_ENTITY, value = "true"),
            @Parameter(name = OptimizableGenerator.OPT_PARAM, value = "pooled-lo"),
            @Parameter(name = OptimizableGenerator.INITIAL_PARAM, value = "1"),
            @Parameter(name = OptimizableGenerator.INCREMENT_PARAM, value = "1")})
    private long id;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
