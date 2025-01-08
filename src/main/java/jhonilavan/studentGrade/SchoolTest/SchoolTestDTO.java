package jhonilavan.studentGrade.SchoolTest;

import io.swagger.v3.oas.annotations.media.Schema;
import jhonilavan.studentGrade.TeacherSubjects.TeacherSubjectsId;
import lombok.Data;

@Data
@Schema(description = "transferidor de dados para criar provas")
public class SchoolTestDTO {
    private String title;

    private String testDescription;

    private double weight;

    private TeacherSubjectsId teacherSubjectsId;
}
