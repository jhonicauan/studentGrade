package jhonilavan.studentGrade.Subject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import lombok.Data;

@Entity(name = "subject")
@Data
@Schema(description = "Modelo de entidade para criar matérias")
public class ModelSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;

    private String nameSubject;

    private String descriptionSubject;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference
    List<ModelTeacherSubjects> teacherSubjects;
}
