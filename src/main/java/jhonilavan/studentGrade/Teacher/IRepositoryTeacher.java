package jhonilavan.studentGrade.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryTeacher extends JpaRepository<ModelTeacher,Long>{
   ModelTeacher findByUsername(String username); 
}
