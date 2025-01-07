package jhonilavan.studentGrade.Error;

public class InvalidPasswordError extends RuntimeException{
    public InvalidPasswordError(String text){
        super(text);
    }
}
