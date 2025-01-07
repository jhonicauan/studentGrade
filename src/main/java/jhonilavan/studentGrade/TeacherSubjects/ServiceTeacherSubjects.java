package jhonilavan.studentGrade.TeacherSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jhonilavan.studentGrade.Subject.IRepositorySubject;
import jhonilavan.studentGrade.Subject.ModelSubject;
import jhonilavan.studentGrade.Teacher.IRepositoryTeacher;
import jhonilavan.studentGrade.Teacher.ModelTeacher;

@Service
public class ServiceTeacherSubjects {
    
    @Autowired
    private IRepositoryTeacher repositoryTeacher;

    @Autowired
    private IRepositorySubject repositorySubject;

    @Autowired
    private IRepositoryTeacherSubjects repositoryTeacherSubjects;

    public  boolean idsAreValid(Long idSubject,Long idTeacher){
        ModelTeacher teacher =  repositoryTeacher.findByIdTeacher(idTeacher);
        ModelSubject subject = repositorySubject.findByIdSubject(idSubject);
        return teacher != null && subject != null;
    }

    public ModelTeacherSubjects finishAdd(ModelTeacherSubjects newLecture){
        TeacherSubjectsId ids = newLecture.getIdTeacherSubjects();
        Long idTeacher = ids.getIdTeacher();
        Long idSubject = ids.getIdSubject();
        ModelTeacher teacher =  repositoryTeacher.findByIdTeacher(idTeacher);
        ModelSubject subject = repositorySubject.findByIdSubject(idSubject);
        newLecture.setSubject(subject);
        newLecture.setTeacher(teacher);
        repositoryTeacherSubjects.save(newLecture);
        return newLecture;
    }
}
