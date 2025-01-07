package jhonilavan.studentGrade.Error;

public class InvalidWeightError extends RuntimeException{
    public InvalidWeightError(String text){
        super(text);
    }
}
