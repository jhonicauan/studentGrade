package jhonilavan.studentGrade.Error;

public class MessageError {
    
    public static void send(String erro){
        throw new RuntimeException(erro);
    }
}
