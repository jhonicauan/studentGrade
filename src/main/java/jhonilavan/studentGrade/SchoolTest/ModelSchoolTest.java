package jhonilavan.studentGrade.SchoolTest;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jhonilavan.studentGrade.Grade.ModelGrade;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import lombok.Data;

@Entity(name = "schooltest")
@Data
public class ModelSchoolTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchoolTest;

    private String title;

    private String testDescription;

    private double weight;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_subject",referencedColumnName = "id_subject"),@JoinColumn(name = "id_teacher",referencedColumnName = "id_teacher")})
    ModelTeacherSubjects teacherSubjects;

    @OneToMany(mappedBy = "schoolTest")
    @JsonBackReference
    private List<ModelGrade> grades;
}
