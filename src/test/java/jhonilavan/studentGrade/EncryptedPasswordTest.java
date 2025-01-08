package jhonilavan.studentGrade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import at.favre.lib.crypto.bcrypt.BCrypt;
public class EncryptedPasswordTest  {
    
    @Test
    void testPassword(){
        String password = "jhonicauan";
        String newPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        
        boolean isEncrypted = password != newPassword;
        assertTrue(isEncrypted);
    }

    @Test
    void testEncrypted(){
        String password = "jhonicauan";
        String newPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        boolean match = BCrypt.verifyer().verify(password.toCharArray(), newPassword.toCharArray()).verified;
        assertTrue(match);
    }
}
