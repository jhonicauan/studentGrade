package jhonilavan.studentGrade.Grade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRepositoryGrade extends JpaRepository<ModelGrade,GradeId> {
    @Query("SELECT g.schoolTest.teacherSubjects.subject.nameSubject AS nameSubject,AVG(g.weight) AS weight from grade g where g.student.idStudent = ?1 GROUP BY nameSubject")
    List<BulletinDTO> bulletin(Long idStudent);
}
