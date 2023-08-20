package entities;

import gsexceptions.GSException;

import java.util.ArrayList;

public class School extends Entity {
    /**
     * The number of positions this school offers.
     */
    private final int maxPositions;
    public final ArrayList<Integer> currentMatched = new ArrayList<>();
    /**
     * Constructs an entity with the given ID and list of preferences. Additionally, school offers a given number
     * of positions.
     *
     * @param ID           The Integer to be set as ID.
     * @param preferences  The ordered list of preferences.
     * @param maxPositions The number of open positions this school has.
     * @throws GSException if the given list is empty.
     */
    public School(Integer ID, ArrayList<Integer> preferences, int maxPositions) throws GSException {
        super(ID, preferences);
        if (maxPositions > 0) {
            this.maxPositions = maxPositions;
        } else {
            throw new GSException("A school should offer at least one position!");
        }
    }
    /**
     * Entities are able to tell whether they are matched.
     * @return true if the entity cannot accept more pairs.
     */
    @Override
    public boolean isMatched() {
        return currentMatched.size()  >= maxPositions;
    }

    /**
     * Given two people, a school can tell which one prefers. The lower the index, the higher the rank.
     * @param person1 First person's ID given for rank comparison.
     * @param person2 Second person's ID given for rank comparison.
     * @return true if this school prefers person1 over person2.
     */
    public boolean prefers(Integer person1,Integer person2) {
        int rank1 = preferences.indexOf(person1);
        int rank2 = preferences.indexOf(person2);
        return rank1 < rank2;
    }

    /**
     * A school closes positions adding person to a list.
     * @param person the ID of the person to add in the choices.
     */
    public void addMatch(Integer person) {
        currentMatched.add(person);
    }
}
