package jhonilavan.studentGrade.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class ControllerStudent {

    //Adicionando o repósitorio que controlara os dados de estudantes
    @Autowired
    ServiceStudent service;

    //Função para adicionar estudantes
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody ModelStudent newStudent){
        try{
            newStudent = service.addStudent(newStudent);
            return ResponseEntity.accepted().body(newStudent);
        }catch(RuntimeException e){

            String error = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }
}
