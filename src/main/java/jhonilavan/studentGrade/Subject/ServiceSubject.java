package jhonilavan.studentGrade.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jhonilavan.studentGrade.Error.DuplicateValueError;

@Service
public class ServiceSubject {
    
    @Autowired
    private IRepositorySubject repositorySubject;

    public ModelSubject addSubject(SubjectDTO subjectDTO){
        String nameSubject = subjectDTO.getNameSubject();
        if(subjectExists(nameSubject)){
            throw new DuplicateValueError("Já existe uma materia com este nome.");
        }
        ModelSubject newSubject = new ModelSubject();
        
        newSubject.setDescriptionSubject(subjectDTO.getDescriptionSubject());
        newSubject.setNameSubject(nameSubject);

        return repositorySubject.save(newSubject);
    }

    public List<ModelSubject> viewAll(){
        return repositorySubject.findAll();
    }
    //Função para checar se existem matérias com este nome
    public boolean subjectExists(String nameSubject){
        return repositorySubject.findByNameSubject(nameSubject) != null;
    }
}
