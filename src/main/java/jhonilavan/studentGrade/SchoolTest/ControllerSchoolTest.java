package jhonilavan.studentGrade.SchoolTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/schooltest")
public class ControllerSchoolTest {
    
    @Autowired
    ServiceSchoolTest service;

    @PostMapping("/add")
      @Operation(summary = "Adicionar provas",description = "Faz com que provas seja registrado no banco de dados")
    public ResponseEntity addSchoolTest(@RequestBody SchoolTestDTO schoolTestDTO){
        try{
            ModelSchoolTest newTest = service.addTest(schoolTestDTO);
            return ResponseEntity.accepted().body(newTest);
        }catch(RuntimeException e){
            String errorMessage = e.getLocalizedMessage();
            return ResponseEntity.accepted().body(errorMessage);
        }
    }
}
