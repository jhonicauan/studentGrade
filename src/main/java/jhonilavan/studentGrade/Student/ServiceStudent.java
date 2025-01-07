package jhonilavan.studentGrade.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jhonilavan.studentGrade.Error.DuplicateValueError;
import jhonilavan.studentGrade.Error.InvalidPasswordError;

@Service
public class ServiceStudent {
    @Autowired
    private IRepositoryStudent repositoryStudent;

    public ModelStudent addStudent(ModelStudent newStudent){
         String enrollment = newStudent.getEnrollment();

            if(enrollmentExists(enrollment)){
                throw new DuplicateValueError("Matricula já esta em uso");
            }

            String password = newStudent.getPassword();
            if(password.length() < 8){
                throw new InvalidPasswordError("Senhas devem ter no minimo 8 digitos.");
            }

            String cryptPassword = BCrypt.withDefaults().hashToString(12,password.toCharArray());
            newStudent.setPassword(cryptPassword);

            repositoryStudent.save(newStudent);

            return newStudent;
    }

      //Conferir se já existe esta matricula
      public boolean enrollmentExists(String enrollment){
        return repositoryStudent.findByEnrollment(enrollment) != null;
    }
}
