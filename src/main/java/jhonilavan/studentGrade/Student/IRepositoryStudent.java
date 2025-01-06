package jhonilavan.studentGrade.Student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryStudent extends JpaRepository<ModelStudent,String>{
    ModelStudent findByEnrollment(String enrollment);
}
