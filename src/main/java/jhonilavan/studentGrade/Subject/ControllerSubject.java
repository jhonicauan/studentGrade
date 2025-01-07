package jhonilavan.studentGrade.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class ControllerSubject {

    //Repositorio que ira controlar as matérias
    @Autowired
    ServiceSubject service;

    //Função para criar matérias
    @PostMapping("/add")
    public ResponseEntity addSubject(@RequestBody ModelSubject newSubject){
        try{
            service.addSubject(newSubject);
            return ResponseEntity.accepted().body(newSubject);
        }catch(RuntimeException e){

            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }

    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<ModelSubject> subjects = service.viewAll();
        return ResponseEntity.accepted().body(subjects);
    }
}
