package jhonilavan.studentGrade.Student;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.Grade.ModelGrade;
import lombok.Data;

@Entity(name = "student")
@Data
public class ModelStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    private String enrollment;

    private String nameStudent;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "student")
    @JsonBackReference
    List<ModelGrade> grades;
}
