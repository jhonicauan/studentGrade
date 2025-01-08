package jhonilavan.studentGrade.Grade;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class GradeId implements Serializable{
    private Long idSchoolTest;
    private Long idStudent;

    public GradeId(){}
}
