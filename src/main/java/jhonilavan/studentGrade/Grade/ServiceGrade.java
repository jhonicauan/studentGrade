package jhonilavan.studentGrade.Grade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jhonilavan.studentGrade.Error.InvalidPasswordError;
import jhonilavan.studentGrade.Error.InvalidWeightError;
import jhonilavan.studentGrade.Error.UnmatchIdError;
import jhonilavan.studentGrade.SchoolTest.IRepositorySchoolTest;
import jhonilavan.studentGrade.SchoolTest.ModelSchoolTest;
import jhonilavan.studentGrade.Student.IRepositoryStudent;
import jhonilavan.studentGrade.Student.ModelStudent;

@Service
public class ServiceGrade {
    
    @Autowired
    IRepositoryGrade repositoryGrade;

    @Autowired 
    IRepositorySchoolTest repositorySchoolTest;

    @Autowired
    IRepositoryStudent repositoryStudent;

    public void checkSchoolTest(Long idSchoolTest){
        if(repositorySchoolTest.findByIdSchoolTest(idSchoolTest) == null){
            throw new UnmatchIdError("Esta prova não existe ou esta disponivel.");
        }
    }

    public void checkStudent(Long idStudent){
        if(repositoryStudent.findByIdStudent(idStudent) == null){
            throw new UnmatchIdError("Este aluno não existe ou esta disponivel.");
        }
    }

    public ModelGrade addGrade(GradeDTO gradeDTO){
        Long idStudent = gradeDTO.getIdGrade().getIdStudent();
        Long idSchoolTest = gradeDTO.getIdGrade().getIdSchoolTest();
        GradeId gradeId = gradeDTO.getIdGrade();
        String password = gradeDTO.getPassword();
        checkAvaliable(gradeId);
        checkPassword(idStudent, password);
        checkSchoolTest(idSchoolTest);
        checkStudent(idStudent);
        double weight = gradeDTO.getWeight();
        if(weight <=0 || weight > 10){
            throw new InvalidWeightError("O peso deve ser acima de 0 e no maxímo 10");
        }

        ModelStudent student = repositoryStudent.findByIdStudent(idStudent);
        ModelSchoolTest schoolTest = repositorySchoolTest.findByIdSchoolTest(idSchoolTest);
        ModelGrade newGrade = new ModelGrade();

        newGrade.setIdGrade(gradeDTO.getIdGrade());
        newGrade.setWeight(weight);
        newGrade.setSchoolTest(schoolTest);
        newGrade.setStudent(student);

        return repositoryGrade.save(newGrade);
    }

    public List<BulletinDTO> getBulletin(Long idStudent){
        return repositoryGrade.bulletin(idStudent);
    }

    public void checkPassword(Long idStudent,String password){
        ModelStudent student = repositoryStudent.findByIdStudent(idStudent);
        String studentPassword = student.getPassword();
        boolean check = BCrypt.verifyer().verify(password.toCharArray(),studentPassword.toCharArray()).verified;
        if(!check){
            throw new InvalidPasswordError("Não foi possivel autenticar o aluno");
        }
    }

    public void checkAvaliable(GradeId gradeId){
        ModelGrade grade = repositoryGrade.findById(gradeId).get();
        if(grade != null){
            throw new UnmatchIdError("Este aluno já fez essa prova");
        }
    }
}
