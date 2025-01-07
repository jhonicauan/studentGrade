package jhonilavan.studentGrade.SchoolTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schooltest")
public class ControllerSchoolTest {
    
    @Autowired
    ServiceSchoolTest service;

    @PostMapping("/add")
    public ResponseEntity addSchoolTest(@RequestBody ModelSchoolTest newTest){
        try{
            newTest = service.addTest(newTest);
            return ResponseEntity.accepted().body(newTest);
        }catch(RuntimeException e){
            String errorMessage = e.getLocalizedMessage();
            return ResponseEntity.accepted().body(errorMessage);
        }
    }
}
