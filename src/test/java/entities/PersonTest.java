package entities;

import gsexceptions.GSException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testNegativeEntityConstructor() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        try {
            Entity entity = new Person(ID,preferences);
            fail("Entity with empty preference list");
        } catch (GSException e) {
            assertEquals("An entity must have non-empty preference list.",e.getMessage());
        }

    }

    @Test
    void testForGetID() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        preferences.add(1);
        Entity entity = new Person(ID,preferences);
        assertEquals(ID,entity.ID);
    }

    @Test
    void testForGetBest() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        Integer best = 1;
        preferences.add(best);
        preferences.add(5);
        Person person = new Person(ID,preferences);
        assertEquals(best,person.getBest());
    }
}