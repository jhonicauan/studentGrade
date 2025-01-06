package jhonilavan.studentGrade.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "student")
@Data
public class ModelStudent {
    @Id
    private String enrollment;

    private String nameStudent;

    private String password;
}
