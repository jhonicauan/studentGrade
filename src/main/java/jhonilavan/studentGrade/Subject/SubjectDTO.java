package jhonilavan.studentGrade.Subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Realiza a transferencia dos dados necessarios para criar uma matéria")
public class SubjectDTO {
    private String nameSubject;
    private String descriptionSubject;
}
