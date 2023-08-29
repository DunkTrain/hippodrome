import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MainTest {


    @Disabled
    @Timeout(value = 22)
    @Test
    public void main() throws Exception {
        Main.main(null);
    }
}