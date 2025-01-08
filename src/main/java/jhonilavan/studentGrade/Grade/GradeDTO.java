package jhonilavan.studentGrade.Grade;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "transferir os dados para definir a nota do aluno em uma prova")
public class GradeDTO {
    private GradeId idGrade;

    private double weight;

    private String password;
}
