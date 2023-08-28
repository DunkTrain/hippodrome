import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void ConstructorWithNullNameAndExceptionMessageForNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 20.0, 200.0));
        assertEquals("Name cannot be null.", exception.getMessage());
    }


    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}