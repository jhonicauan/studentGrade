package jhonilavan.studentGrade.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jhonilavan.studentGrade.Error.DuplicateValueError;
import jhonilavan.studentGrade.Error.InvalidPasswordError;

@Service
public class ServiceTeacher {
    @Autowired
    private IRepositoryTeacher repositoryTeacher;

    public ModelTeacher addTeacher(ModelTeacher newTeacher){
        String username = newTeacher.getUsername();

        if(usernameExists(username)){
           throw new DuplicateValueError("Este nome de usuario já tem dono.");
        }

        String password = newTeacher.getPassword();
        if(password.length() < 8){
            throw new InvalidPasswordError("Senhas devem ter no minímo 8 digitos");
        }

        String cryptPassword = BCrypt.withDefaults().hashToString(12,password.toCharArray());
        newTeacher.setPassword(cryptPassword);

        repositoryTeacher.save(newTeacher);

        return newTeacher;
    }

    //Conferir se já existe este usuario
    public boolean usernameExists(String username){
        return repositoryTeacher.findByUsername(username) != null;
    }
}
