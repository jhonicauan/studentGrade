package jhonilavan.studentGrade.TeacherSubjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jhonilavan.studentGrade.Error.UnmatchIdError;

@RestController
@RequestMapping("/lecture")
public class ControllerTeacherSubjects {

    @Autowired
    ServiceTeacherSubjects service;

    @PostMapping("/add")
    public ResponseEntity addLecture(@RequestBody ModelTeacherSubjects newLecture){
        try{
            newLecture = service.finishAdd(newLecture);
            return ResponseEntity.accepted().body(newLecture);
        }catch(RuntimeException e){
            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }

    @GetMapping("/viewLectures/{idTeacher}")
    public ResponseEntity viewLectures(@PathVariable("idTeacher") Long idTeacher){
        try
        {
        List<TeacherSubjectsDetailsDTO> lectures = service.getTeacherLectures(idTeacher);
        return ResponseEntity.accepted().body(lectures);
        }catch(RuntimeException e){
            String messageError = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(messageError);
        }
    }
}
