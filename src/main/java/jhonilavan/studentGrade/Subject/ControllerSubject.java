package jhonilavan.studentGrade.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jhonilavan.studentGrade.Error.MessageError;

@RestController
@RequestMapping("/subject")
public class ControllerSubject {

    //Repositorio que ira controlar as matérias
    @Autowired
    IRepositorySubject repositorySubject;

    //Função para criar matérias
    @PostMapping("/add")
    public ResponseEntity addSubject(@RequestBody ModelSubject newSubject){
        try{

            String nameSubject = newSubject.getNameSubject();
            if(subjectExists(nameSubject)){
                MessageError.send("Já existe uma materia com este nome.");
            }

            repositorySubject.save(newSubject);
            return ResponseEntity.accepted().body(newSubject);
        }catch(RuntimeException e){

            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }

    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<ModelSubject> subjects = repositorySubject.findAll();
        return ResponseEntity.accepted().body(subjects);
    }
    //Função para checar se existem matérias com este nome
    public boolean subjectExists(String nameSubject){
        return repositorySubject.findByNameSubject(nameSubject) != null;
    }
}
