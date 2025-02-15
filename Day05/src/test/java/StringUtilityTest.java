import static org.junit.jupiter.api.Assertions.*;

import com.tit.regexandjunit.junit.StringUtility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringUtilityTest {

    static StringUtility stringUtils;

    @BeforeAll
    static void setUp() {
        stringUtils = new StringUtility(); // Object created once before all tests
    }

    @Test
    void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
        assertEquals("madam", stringUtils.reverse("madam"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null)); // Check null input
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("Racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null)); // Null case
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("WORLD", stringUtils.toUpperCase("world"));
        assertEquals("", stringUtils.toUpperCase("")); // Empty string case
        assertNull(stringUtils.toUpperCase(null)); // Null input check
    }
}
