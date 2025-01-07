package jhonilavan.studentGrade.Teacher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import lombok.Data;

@Entity(name = "teacher")
@Data
public class ModelTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    private String username;

    private String nameTeacher;

    private String password;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    List<ModelTeacherSubjects> teacherSubjects;
}
