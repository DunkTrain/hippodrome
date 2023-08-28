import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void ConstructorWithNullNameAndExceptionMessageForNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 20.0, 200.0));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    public void ConstructorWithBlankNameAndExceptionMessageForBlankName(String name) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 20.0, 200.0));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void ConstructorWithSecondParamNegativeSpeedAndExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Ghost", -20.0, 200.0));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void ConstructorWithThirdParamNegativeDistanceAndExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Ghost", 20.0,-200.0));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }


    @Test
    void getName() {
        Horse horse = new Horse("Ghost", 20.0, 200.0);
        assertEquals("Ghost", horse.getName());
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