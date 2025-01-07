package jhonilavan.studentGrade.TeacherSubjects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jhonilavan.studentGrade.Subject.ModelSubject;
import jhonilavan.studentGrade.Teacher.ModelTeacher;
import lombok.Data;

@Entity(name = "teacher_subjects")
@Data
public class ModelTeacherSubjects {
    @EmbeddedId
    private TeacherSubjectsId idTeacherSubjects;

    @ManyToOne
    @MapsId("idSubject")
    @JoinColumn(name = "id_subject")
    @JsonIgnore
    private ModelSubject subject;

    @ManyToOne
    @MapsId("idTeacher")
    @JoinColumn(name = "id_teacher")
    @JsonIgnore
    private ModelTeacher teacher;
}
