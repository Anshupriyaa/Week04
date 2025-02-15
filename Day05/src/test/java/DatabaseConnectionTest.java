import static org.junit.jupiter.api.Assertions.*;
import com.tit.regexandjunit.junit.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseConnectionTest {
    DatabaseConnection databaseConnection;
    @BeforeEach
    void setUp(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }
    @AfterEach
    void close(){
        databaseConnection.disconnect();
    }
    @Test
    void testConnectionEstablished(){
        assertEquals(databaseConnection.isConnected(),true);
    }
    @Test
    void testConnectionClosedAfterTest() {
        assertTrue(databaseConnection.isConnected(), "Database closed successfully After Each case ");
    }

}
