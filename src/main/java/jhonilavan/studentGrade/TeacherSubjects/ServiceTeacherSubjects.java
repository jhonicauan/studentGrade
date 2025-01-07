package jhonilavan.studentGrade.TeacherSubjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jhonilavan.studentGrade.Error.UnmatchIdError;
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

    
    public ModelTeacherSubjects finishAdd(ModelTeacherSubjects newLecture){
        TeacherSubjectsId ids = newLecture.getIdTeacherSubjects();
        Long idTeacher = ids.getIdTeacher();
        Long idSubject = ids.getIdSubject();
        boolean validIds = idsAreValid(idSubject, idTeacher);
        if(!validIds){
            throw new UnmatchIdError("Não foi possivel encontrar o professor ou materia.");
        }
        ModelTeacher teacher =  repositoryTeacher.findByIdTeacher(idTeacher);
        ModelSubject subject = repositorySubject.findByIdSubject(idSubject);
        newLecture.setSubject(subject);
        newLecture.setTeacher(teacher);
        repositoryTeacherSubjects.save(newLecture);
        return newLecture;
    }
    
    public List<TeacherSubjectsDetailsDTO> getTeacherLectures(Long idTeacher){
        if(!teacherExists(idTeacher)){
            throw new UnmatchIdError("Este professor não existe.");
        }
        return repositoryTeacherSubjects.findLecturesByTeacher(idTeacher);
    }

    public  boolean idsAreValid(Long idSubject,Long idTeacher){
        ModelTeacher teacher =  repositoryTeacher.findByIdTeacher(idTeacher);
        ModelSubject subject = repositorySubject.findByIdSubject(idSubject);
        return teacher != null && subject != null;
    }

    public boolean teacherExists(Long idTeacher){
        ModelTeacher teacher =  repositoryTeacher.findByIdTeacher(idTeacher);
        return teacher != null;
    }
}
