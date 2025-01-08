package jhonilavan.studentGrade.Student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Realiza a transferencia dos dados necessarios para criar um aluno.")
public class StudentDTO {
    private String enrollment;
    private String nameStudent;
    private String password;
}
