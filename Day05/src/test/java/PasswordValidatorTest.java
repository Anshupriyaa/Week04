import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tit.regexandjunit.junit.passwordstrengthvalidator.PasswordValidator;
class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("StrongPass1"), "Valid password should pass");
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(PasswordValidator.isValidPassword("Short1"), "Password must be at least 8 characters");
    }

    @Test
    void testPasswordMissingUppercase() {
        assertFalse(PasswordValidator.isValidPassword("weakpassword1"), "Password must have at least one uppercase letter");
    }

    @Test
    void testPasswordMissingDigit() {
        assertFalse(PasswordValidator.isValidPassword("WeakPassword"), "Password must have at least one digit");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValidPassword(null), "Null passwords should be invalid");
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValidPassword(""), "Empty passwords should be invalid");
    }
}
