package jhonilavan.studentGrade.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/teacher")
public class ControllerTeacher {
     //Adicionando o repósitorio que controlara os dados de professores
    @Autowired
    private ServiceTeacher service;

    //Função para adicionar professores
    @Operation(summary = "Adicionar professor",description = "Faz com que um professor seja registrado no banco de dados")
    @ApiResponse(description = "Retorna o novo objeto de Professor criado")
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody TeacherDTO teacherDTO){
        try{
            ModelTeacher newTeacher = service.addTeacher(teacherDTO);
            return ResponseEntity.accepted().body(newTeacher);

        }catch(RuntimeException e){

            String error = e.getLocalizedMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }
}
