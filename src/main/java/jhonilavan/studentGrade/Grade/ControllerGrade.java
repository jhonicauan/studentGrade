package jhonilavan.studentGrade.Grade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/grade")
public class ControllerGrade {
    
    @Autowired
    ServiceGrade service;

    @PostMapping("/add")
      @Operation(summary = "Definir a nota do aluno",description = "Defini a nota de um aluno em certa prova")
    public ResponseEntity addGrade(@RequestBody GradeDTO gradeDTO){
        try{
            ModelGrade newGrade = service.addGrade(gradeDTO);
            return ResponseEntity.accepted().body(newGrade);
        }catch(RuntimeException e){
            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }
    @Operation(summary = "Ver boletim",description = "Gera uma lista com a media do aluno em todas as matérias que ele participou")
    @GetMapping("/bulletin/{idStudent}")
    public ResponseEntity getBulletin(@PathVariable("idStudent") Long idStudent){
        List<BulletinDTO> bulletin = service.getBulletin(idStudent);
        return ResponseEntity.accepted().body(bulletin);
    }
}
