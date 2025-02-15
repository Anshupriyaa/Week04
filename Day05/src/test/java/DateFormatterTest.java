import static org.junit.jupiter.api.Assertions.*;
import com.tit.regexandjunit.junit.dateformatter.DateFormatter;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("15-02-2025", DateFormatter.formatDate("2025-02-15"), "2025-02-15 should convert to 15-02-2025");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "2000-01-01 should convert to 01-01-2000");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-02-2025"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage(), "Should throw exception for wrong format");
    }

    @Test
    void testEmptyDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
        assertEquals("Input date cannot be null or empty", exception.getMessage(), "Should throw exception for empty date");
    }

    @Test
    void testNullDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(null));
        assertEquals("Input date cannot be null or empty", exception.getMessage(), "Should throw exception for null date");
    }
}
