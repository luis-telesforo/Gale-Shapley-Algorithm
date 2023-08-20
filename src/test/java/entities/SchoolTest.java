package entities;

import gsexceptions.GSException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {
    @Test
    void testNegativeEntityConstructor() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        preferences.add(1);
        try {
            School school = new School(ID,preferences,0);
            fail("School with no open positions");
        } catch (GSException e) {
            assertEquals("A school should offer at least one position!",e.getMessage());
        }

    }
    @Test
    void TestIsInitiallyFree() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        preferences.add(1);
        School school = new School(ID,preferences,1);
        assert (!school.isMatched());
    }
    @Test
    void TestIsMatched(){
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        preferences.add(1);
        School school = new School(ID,preferences,1);
        Integer IDperson = 0;
        school.addMatch(IDperson);
        assertTrue(school.isMatched());
    }
    @Test
    void prefers() {
        Integer ID = 0;
        ArrayList<Integer> preferences = new ArrayList<>();
        Integer person1ID = 1;
        preferences.add(person1ID);
        Integer person2ID = 2;
        preferences.add(person1ID);
        preferences.add(0,person2ID);
        School school = new School(ID,preferences,1);
        assertTrue(school.prefers(person2ID,person1ID));
    }
}