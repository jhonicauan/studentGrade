package jhonilavan.studentGrade.SchoolTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jhonilavan.studentGrade.Error.InvalidWeightError;
import jhonilavan.studentGrade.Error.UnmatchIdError;
import jhonilavan.studentGrade.TeacherSubjects.IRepositoryTeacherSubjects;
import jhonilavan.studentGrade.TeacherSubjects.ModelTeacherSubjects;
import jhonilavan.studentGrade.TeacherSubjects.TeacherSubjectsId;

@Service
public class ServiceSchoolTest {
    
    @Autowired
    IRepositorySchoolTest repositorySchoolTest;

    @Autowired
    IRepositoryTeacherSubjects repositoryTeacherSubjects;

    public boolean checkTeacherSubjects(Long idTeacher,Long idSubject){
        TeacherSubjectsId teacherSubjectsId = new TeacherSubjectsId(idTeacher, idSubject);
        ModelTeacherSubjects teacherSubjects = repositoryTeacherSubjects.findByIdTeacherSubjects(teacherSubjectsId);
        return teacherSubjects != null;
    }

    public ModelSchoolTest addTest(SchoolTestDTO schoolTestDTO){
        TeacherSubjectsId teacherSubjectsId = schoolTestDTO.getTeacherSubjectsId();
        Long idTeacher = teacherSubjectsId.getIdTeacher();
        Long idSubject = teacherSubjectsId.getIdSubject();
        boolean check = checkTeacherSubjects(idTeacher, idSubject);
        if(!check){
            throw new UnmatchIdError("Não foram encontrados este professor e materia nos dados.");
        }
        double weight = schoolTestDTO.getWeight();
        if(weight <= 0){
            throw new InvalidWeightError("O peso de uma avaliação deve ser maior que 0");
        }


        if(weight > 10){
            throw new InvalidWeightError("O peso de uma avaliação deve ser no maximo 10");
        }
        ModelTeacherSubjects teacherSubjects = repositoryTeacherSubjects.findByIdTeacherSubjects(teacherSubjectsId);
        ModelSchoolTest newTest = new ModelSchoolTest();
        newTest.setTeacherSubjects(teacherSubjects);
        newTest.setTestDescription(schoolTestDTO.getTestDescription());
        newTest.setTitle(schoolTestDTO.getTitle());
        newTest.setWeight(weight);
        return repositorySchoolTest.save(newTest);
    }
}
