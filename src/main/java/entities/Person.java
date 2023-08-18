package entities;

import gsexceptions.GSException;

import java.util.ArrayList;

public class Person extends Entity {
    private boolean isMatched = false;
     /**
     * Constructs an entity with the given ID and list of preferences.
     *
     * @param ID          The Integer to be set as ID.
     * @param preferences The ordered list of preferences.
     * @throws GSException if the given list is empty.
     */
    public Person(Integer ID, ArrayList<Integer> preferences) throws GSException {
        super(ID, preferences);
    }
    /**
     * Entities are able to tell whether they are matched.
     * @return true if the entity cannot accept more pairs.
     */
    @Override
    public boolean isMatched() {
        return isMatched;
    }
    /**
     * Persons can tell which one is their best option left. It corresponds to the first element in its preference list.
     * @return the highest ranked preference of this person
     * @throws GSException if there are no more options for this person.
     */
    public Integer getBest() throws IndexOutOfBoundsException {
        return preferences.get(0);
    }
}
