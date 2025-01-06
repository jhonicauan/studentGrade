package jhonilavan.studentGrade.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jhonilavan.studentGrade.Error.MessageError;

@RestController
@RequestMapping("/student")
public class ControllerStudent {

    //Adicionando o repósitorio que controlara os dados de estudantes
    @Autowired
    IRepositoryStudent repositoryStudent;

    //Função para adicionar estudantes
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody ModelStudent newStudent){
        try{

            String enrollment = newStudent.getEnrollment();

            if(enrollmentExists(enrollment)){
                MessageError.send("Esta matricula não esta disponível.");
            }

            String password = newStudent.getPassword();
            if(password.length() < 8){
                MessageError.send("Senhas devem ter no minímo 8 digitos.");
            }

            String cryptPassword = BCrypt.withDefaults().hashToString(12,password.toCharArray());
            newStudent.setPassword(cryptPassword);

            repositoryStudent.save(newStudent);

            return ResponseEntity.accepted().body(newStudent);

        }catch(RuntimeException e){

            String error = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }

    //Conferir se já existe esta matricula
    public boolean enrollmentExists(String enrollment){
        return repositoryStudent.findByEnrollment(enrollment) != null;
    }
}
