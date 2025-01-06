package jhonilavan.studentGrade.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jhonilavan.studentGrade.Error.MessageError;

@RestController
@RequestMapping("/teacher")
public class ControllerTeacher {
     //Adicionando o repósitorio que controlara os dados de professores
    @Autowired
    IRepositoryTeacher repositoryTeacher;

    //Função para adicionar professores
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody ModelTeacher newTeacher){
        try{

            String username = newTeacher.getUsername();

            if(usernameExists(username)){
                MessageError.send("Este usuario não esta disponível.");
            }

            String password = newTeacher.getPassword();
            if(password.length() < 8){
                MessageError.send("Senhas devem ter no minímo 8 digitos.");
            }

            String cryptPassword = BCrypt.withDefaults().hashToString(12,password.toCharArray());
            newTeacher.setPassword(cryptPassword);

            repositoryTeacher.save(newTeacher);

            return ResponseEntity.accepted().body(newTeacher);

        }catch(RuntimeException e){

            String error = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }

    //Conferir se já existe este usuario
    public boolean usernameExists(String username){
        return repositoryTeacher.findByUsername(username) != null;
    }
}
