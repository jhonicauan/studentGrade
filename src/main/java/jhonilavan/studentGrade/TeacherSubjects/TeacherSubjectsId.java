package jhonilavan.studentGrade.TeacherSubjects;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TeacherSubjectsId implements Serializable {
    private Long idTeacher;
    private Long idSubject;
}
