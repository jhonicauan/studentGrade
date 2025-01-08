package jhonilavan.studentGrade.TeacherSubjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Transferencia dos ids da matéria e professor")
public class TeacherSubjectsDTO {
    private TeacherSubjectsId idTeacherSubjects;
}
