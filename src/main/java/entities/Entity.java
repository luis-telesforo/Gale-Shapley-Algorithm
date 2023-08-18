package entities;

import gsexceptions.GSException;

import java.util.ArrayList;

/**
 * An entity has a list of preferences. It should be able to tell whether it is matched.
 */

public abstract class Entity {
    /**
     * Each entity has an ID. Two different entities could have the same ID.
     */
    public final Integer ID;
    /**
     * The ordered list of preferences. It stores entities' ID, not entities.
     */
    protected final ArrayList<Integer> preferences;
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
     * Entities are able to tell whether they are matched.
     * @return true if the entity cannot accept more pairs.
     */
    public abstract boolean isMatched();
}
