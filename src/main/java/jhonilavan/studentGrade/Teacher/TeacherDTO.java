package jhonilavan.studentGrade.Teacher;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Realiza a transferencia dos dados necessarios para criar um professor.")
public class TeacherDTO {
    private String nameTeacher;
    private String username;
    private String password;
}
