package jhonilavan.studentGrade.Grade;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jhonilavan.studentGrade.SchoolTest.ModelSchoolTest;
import jhonilavan.studentGrade.Student.ModelStudent;
import lombok.Data;

@Entity(name = "grade")
@Data
@Schema(description = "Modelo para cadastrar notas em avaliações")
public class ModelGrade {
    @EmbeddedId
    private GradeId idGrade;

    private double weight;

    @CreationTimestamp
    private LocalDateTime finishAt;

    @MapsId("idSchoolTest")
    @ManyToOne
    @JoinColumn(name = "id_school_test",referencedColumnName = "idSchoolTest")
    private ModelSchoolTest schoolTest;

    @MapsId("idStudent")
    @ManyToOne
    @JoinColumn(name = "id_student",referencedColumnName = "idStudent")
    private ModelStudent student;
}
