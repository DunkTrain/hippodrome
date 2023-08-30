import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    public void ConstructorWithNullHorsesAndMessageForNullHorses() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    public void tConstructorWithEmptyHorsesAndMessageForEmptyHorses() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }


    @Test
    void getHorses() {
        List<Horse> horsesList = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            horsesList.add(new Horse("Horse " + i, 10.0, 100.0));
        }
        Hippodrome hippodrome = new Hippodrome(horsesList);
        assertEquals(horsesList, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse mockHorse = mock(Horse.class);
            horses.add(mockHorse);
        }
        new Hippodrome(horses).move();

        for(Horse mockHorse : horses) {
            verify(mockHorse).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("Horse 1", 10.0, 150.0);
        Horse horse2 = new Horse("Horse 2", 12.0, 200.0);
        Horse horse3 = new Horse("Horse 3", 8.0, 180.0);
        List<Horse> horses = List.of(horse1, horse2, horse3);

        Hippodrome hippodrome = new Hippodrome(horses);
        Horse winner = hippodrome.getWinner();

        assertEquals(horse2, winner);
    }
}