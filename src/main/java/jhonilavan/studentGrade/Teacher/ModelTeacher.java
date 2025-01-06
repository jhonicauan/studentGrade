package jhonilavan.studentGrade.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "teacher")
@Data
public class ModelTeacher {
    @Id
    private String username;

    private String nameTeacher;

    private String password;
}
