import com.tit.regexandjunit.junit.PerformanceTimeout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class TestingPerformanceTimeout {
    private final PerformanceTimeout timeout = new PerformanceTimeout();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fails if method takes more than 2 seconds
    void testLongRunningTaskTimesOut() throws InterruptedException {
        timeout.longRunningTask(); // Expected to exceed the timeout
    }
}
