package jhonilavan.studentGrade.Subject;

import org.springframework.data.jpa.repository.JpaRepository;



public interface IRepositorySubject extends JpaRepository<ModelSubject,Long>{
    ModelSubject findByNameSubject(String nameSubject);
    ModelSubject findByIdSubject(Long idSubject);
}
