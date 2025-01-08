package jhonilavan.studentGrade.Student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryStudent extends JpaRepository<ModelStudent,Long>{
    ModelStudent findByEnrollment(String enrollment);
    ModelStudent findByIdStudent(Long idStudent);
}
