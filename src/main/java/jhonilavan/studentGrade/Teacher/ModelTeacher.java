package jhonilavan.studentGrade.Teacher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import lombok.Data;

@Entity(name = "teacher")
@Data
@Schema(description = "Modelo de entidade para criar professores.")
public class ModelTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    private String username;

    private String nameTeacher;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    List<ModelTeacherSubjects> teacherSubjects;
}
