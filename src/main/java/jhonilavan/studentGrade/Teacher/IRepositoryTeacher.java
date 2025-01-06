package jhonilavan.studentGrade.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryTeacher extends JpaRepository<ModelTeacher,String>{
   ModelTeacher findByUsername(String username); 
}
