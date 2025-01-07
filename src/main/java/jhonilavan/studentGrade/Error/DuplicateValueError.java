package jhonilavan.studentGrade.Error;

public class DuplicateValueError extends RuntimeException{
    public DuplicateValueError(String text){
        super(text);
    }
}
