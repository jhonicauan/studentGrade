package jhonilavan.studentGrade.Error;

public class UnmatchIdError extends RuntimeException{
    public UnmatchIdError(String text){
        super(text);
    }
}
