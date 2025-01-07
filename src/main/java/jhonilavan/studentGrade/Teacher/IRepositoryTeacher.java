package jhonilavan.studentGrade.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRepositoryTeacher extends JpaRepository<ModelTeacher,Long>{
   ModelTeacher findByUsername(String username); 
   ModelTeacher findByIdTeacher(Long idTeacher);
}
