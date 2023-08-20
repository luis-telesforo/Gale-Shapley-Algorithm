package entities;

import gsexceptions.GSException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    static Integer ID;
    static ArrayList<Integer> preferences;
    @BeforeAll
    static void setup(){
        ID = 0;
        preferences = new ArrayList<>();
    }
    @Test
    void testNegativeEntityConstructor() {
        try {
            Entity entity = new Person(ID,preferences);
            fail("Entity with empty preference list");
        } catch (GSException e) {
            assertEquals("An entity must have non-empty preference list.",e.getMessage());
        }

    }

    @Test
    void testForGetID() {
        Integer entityID = 1;
        preferences.add(entityID);
        Person entity = new Person(ID,preferences);
        assertEquals(ID,entity.ID);
    }

    @Test
    void testForGetBest() {
        Integer secondPreferenceID = 2;
        preferences.add(secondPreferenceID);
        Integer bestPreferenceID = 1;
        preferences.add(0,bestPreferenceID);
        Person person = new Person(ID,preferences);
        assertEquals(bestPreferenceID,person.getBest());
    }

    @Test
    void testForRejected() {
        Integer secondPreferenceID = 2;
        preferences.add(secondPreferenceID);
        Integer bestPreferenceID = 1;
        preferences.add(0,bestPreferenceID);
        Person person = new Person(ID,preferences);
        person.rejected(1);
        assertEquals(secondPreferenceID,person.getBest());
    }
}