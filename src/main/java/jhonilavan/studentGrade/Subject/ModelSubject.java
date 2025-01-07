package jhonilavan.studentGrade.Subject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import lombok.Data;

@Entity(name = "subject")
@Data
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
