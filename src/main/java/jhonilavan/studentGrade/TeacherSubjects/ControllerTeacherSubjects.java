package jhonilavan.studentGrade.TeacherSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jhonilavan.studentGrade.Error.UnmatchIdError;

@RestController
@RequestMapping("/lecture")
public class ControllerTeacherSubjects {
    
    //Repositorio do relacionamento entre professor e materia
    @Autowired
    IRepositoryTeacherSubjects repositoryTeacherSubjects;

    @Autowired
    ServiceTeacherSubjects service;

    @PostMapping("/add")
    public ResponseEntity addLecture(@RequestBody ModelTeacherSubjects newLecture){
        try{
            TeacherSubjectsId ids = newLecture.getIdTeacherSubjects();
            boolean validIds = service.idsAreValid(ids.getIdSubject(), ids.getIdTeacher());
            if(!validIds){
                throw new UnmatchIdError("Não foi possivel encontrar o professor ou materia.");
            }
            newLecture = service.finishAdd(newLecture);
            return ResponseEntity.accepted().body(newLecture);
        }catch(RuntimeException e){
            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }

    
}
