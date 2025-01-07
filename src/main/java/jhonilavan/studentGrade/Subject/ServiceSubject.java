package jhonilavan.studentGrade.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jhonilavan.studentGrade.Error.MessageError;

@Service
public class ServiceSubject {
    
    @Autowired
    private IRepositorySubject repositorySubject;

    public ModelSubject addSubject(ModelSubject newSubject){
        String nameSubject = newSubject.getNameSubject();
        if(subjectExists(nameSubject)){
            MessageError.send("Já existe uma materia com este nome.");
        }

        repositorySubject.save(newSubject);

        return newSubject;
    }

    public List<ModelSubject> viewAll(){
        return repositorySubject.findAll();
    }
    //Função para checar se existem matérias com este nome
    public boolean subjectExists(String nameSubject){
        return repositorySubject.findByNameSubject(nameSubject) != null;
    }
}
