package jhonilavan.studentGrade.Grade;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@Schema(description = "defini o Id de uma nota relacionada a o aluno e a prova")
public class GradeId implements Serializable{
    private Long idSchoolTest;
    private Long idStudent;

    public GradeId(){}
}
