package jhonilavan.studentGrade.TeacherSubjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.SchoolTest.ModelSchoolTest;
import jhonilavan.studentGrade.Subject.ModelSubject;
import jhonilavan.studentGrade.Teacher.ModelTeacher;
import lombok.Data;

@Entity(name = "teacher_subjects")
@Data
@Schema(description = "Modelo de entidade para definir o relacionamento de matérias e o professor")
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

    @OneToMany(mappedBy = "teacherSubjects")
    @JsonBackReference
    private List<ModelSchoolTest> schoolTests;
}
