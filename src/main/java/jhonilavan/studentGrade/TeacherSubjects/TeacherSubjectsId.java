package jhonilavan.studentGrade.TeacherSubjects;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TeacherSubjectsId implements Serializable {
    private Long idTeacher;
    private Long idSubject;

    public TeacherSubjectsId(){};

    public TeacherSubjectsId(Long idTeacher,Long idSubject){
        this.idSubject = idSubject;
        this.idTeacher = idTeacher;
    }
}
