package jhonilavan.studentGrade.TeacherSubjects;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRepositoryTeacherSubjects extends JpaRepository<ModelTeacherSubjects,TeacherSubjectsId>{
    
    @Query("SELECT ts.teacher.nameTeacher AS nameTeacher,ts.subject.nameSubject AS nameSubject from teacher_subjects ts where ts.teacher.idTeacher = ?1")
    public List<TeacherSubjectsDetailsDTO> findLecturesByTeacher(Long idTeacher);

    ModelTeacherSubjects findByIdTeacherSubjects(TeacherSubjectsId idTeacherSubjects);
}
