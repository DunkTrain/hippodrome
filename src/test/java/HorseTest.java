import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Ghost", 20.0, -200.0));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }


    @Test
    void getName() {
        Horse horse = new Horse("Ghost", 20.0, 200.0);
        assertEquals("Ghost", horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("Ghost", 20.0, 200.0);
        assertEquals(20.0, horse.getSpeed());
    }

    @Test
    void getDistance() {
        Horse horse = new Horse("Ghost", 20.0, 200.0);
        assertEquals(200.0, horse.getDistance());
    }

    @Test
    void getDefaultDistance() {
        Horse horse = new Horse("Ghost", 20.0);
        assertEquals(0, horse.getDistance());
    }

    @Test
    void moveRandom() {
        try(MockedStatic<Horse> mocked = mockStatic(Horse.class)) {
            new Horse("Ghost", 20.0,200.0).move();
            mocked.verify(() -> Horse.getRandomDouble(0.2,0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.4, 0.6, 0.8})
    public void moveDistance(double random) {
        try (MockedStatic<Horse> mocked = mockStatic(Horse.class)) {
            mocked.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(random);
            Horse horse = new Horse("Ghost", 20.0, 200.0);
            double distance = horse.getDistance() + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);
            horse.move();
            assertEquals(distance, horse.getDistance());
        }
    }
}