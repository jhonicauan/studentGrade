package jhonilavan.studentGrade.TeacherSubjects;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@Schema(description = "Id do relacionamento de professor e matéria")
public class TeacherSubjectsId implements Serializable {
    private Long idTeacher;
    private Long idSubject;

    public TeacherSubjectsId(){};

    public TeacherSubjectsId(Long idTeacher,Long idSubject){
        this.idSubject = idSubject;
        this.idTeacher = idTeacher;
    }
}
