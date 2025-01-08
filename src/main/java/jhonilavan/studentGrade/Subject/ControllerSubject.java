package jhonilavan.studentGrade.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/subject")
public class ControllerSubject {

    //Repositorio que ira controlar as matérias
    @Autowired
    ServiceSubject service;

    //Função para criar matérias
    @PostMapping("/add")
     @Operation(summary = "Adicionar matéria",description = "Faz com que uma matéria seja registrado no banco de dados")
    public ResponseEntity addSubject(@RequestBody SubjectDTO subjectDTO){
        try{
            ModelSubject newSubject = service.addSubject(subjectDTO);
            return ResponseEntity.accepted().body(newSubject);
        }catch(RuntimeException e){

            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }
    @Operation(summary = "Mostrar matérias",description = "Mostra todas as matérias cadastradas no banco")
    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<ModelSubject> subjects = service.viewAll();
        return ResponseEntity.accepted().body(subjects);
    }
}
