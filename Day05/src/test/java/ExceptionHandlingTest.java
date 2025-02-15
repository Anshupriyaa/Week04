import static org.junit.jupiter.api.Assertions.*;
import com.tit.regexandjunit.junit.ExceptionHandling;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ExceptionHandlingTest {
    static ExceptionHandling exceptionHandling;

    @BeforeAll
    static void setUp(){
        exceptionHandling = new ExceptionHandling();
    }

    @Test
    void testDivide() {
        // Valid division cases
        assertDoesNotThrow(() -> exceptionHandling.divide(10, 2));
        assertEquals(5, exceptionHandling.divide(10, 2)); // Checking the actual result
    }

    @Test
    void testDivideByZero() {
        // Verify that divide() throws ArithmeticException when dividing by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> exceptionHandling.divide(10, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
