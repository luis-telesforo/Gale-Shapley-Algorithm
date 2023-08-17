package entities;

import gsexceptions.GSException;

import java.util.ArrayList;

public class Entity {
    /**
     * Each entity has an ID. Two different entities could have the same ID.
     */
    public final Integer ID;
    /**
     * The ordered list of preferences. It stores entities' ID, not entities.
     */
    private final ArrayList<Integer> preferences;

    /**
     * Constructs an entity with the given ID and list of preferences.
     * @param ID The Integer to be set as ID.
     * @param preferences The ordered list of preferences.
     * @throws GSException if the given list is empty.
     */
    public Entity(Integer ID, ArrayList<Integer> preferences) throws GSException {
        if (!preferences.isEmpty()) {
            this.ID = ID;
            this.preferences = preferences;
        } else {
            throw new GSException("An entity must have non-empty preference list.");
        }
    }
    /**
     * To be considered as an option this entity must share its ID.
     * @return the entity's ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Entities can tell which one is their best option left. It corresponds to the first element in its preference list.
     * @return the highest ranked preference of this entity
     * @throws GSException if there are no more options for this entity.
     */
    public Integer getBest() throws GSException {
        try {
            return preferences.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new GSException("This entity has ran out of options.");
        }
    }
}
