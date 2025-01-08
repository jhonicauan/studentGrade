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

@RestController
@RequestMapping("/grade")
public class ControllerGrade {
    
    @Autowired
    ServiceGrade service;

    @PostMapping("/add")
    public ResponseEntity addGrade(@RequestBody ModelGrade newGrade){
        try{
            newGrade = service.addGrade(newGrade);
            return ResponseEntity.accepted().body(newGrade);
        }catch(RuntimeException e){
            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }

    @GetMapping("/bulletin/{idStudent}")
    public ResponseEntity getBulletin(@PathVariable("idStudent") Long idStudent){
        List<BulletinDTO> bulletin = service.getBulletin(idStudent);
        return ResponseEntity.accepted().body(bulletin);
    }
}
