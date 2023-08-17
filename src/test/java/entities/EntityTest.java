package entities;

import gsexceptions.GSException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    @Test
    void testNegativeEntityConstructor() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        try {
            Entity entity = new Entity(ID,preferences);
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
        Entity entity = new Entity(ID,preferences);
        assertEquals(ID,entity.getID());
    }

    @Test
    void testForPositiveGetBest() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        Integer best = 1;
        preferences.add(best);
        preferences.add(5);
        Entity entity = new Entity(ID,preferences);
        assertEquals(best,entity.getBest());
    }
    @Test
    void testForNegativeGetBest() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        Integer best = 1;
        preferences.add(best);
        Entity entity = new Entity(ID,preferences);
        preferences.remove(best);
        try {
            entity.getBest();
        } catch (GSException e ) {
            assertEquals("This entity has ran out of options.",e.getMessage());
        }

    }
}