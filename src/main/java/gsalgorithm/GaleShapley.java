package gsalgorithm;

import entities.Person;
import entities.School;
import gsexceptions.GSException;

import java.util.ArrayList;
import java.util.HashMap;

public class GaleShapley {
    private ArrayList<Person> students;
    private ArrayList<School> schools;
    private HashMap<Integer,Integer> match;

    public GaleShapley(ArrayList<Person> men, ArrayList<School> women) {
        if (!men.isEmpty() && !women.isEmpty()) {
            while (!men.isEmpty()){
                Person freeStudent = men.get(0);
                Integer bestOptionID = null;
                try {
                    bestOptionID = freeStudent.getBest();
                } catch (GSException e) {
                    men.remove(freeStudent);
                    continue;
                }
                School bestOption = women.get(bestOptionID);
                if (!bestOption.isMatched()) {
                    match.put(freeStudent.ID,bestOptionID);
                } else {
                    Integer studentMatched = bestOption.currentMatched.get(0);
                    if (bestOption.prefers(freeStudent.getBest(),studentMatched)) {

                    }
                }

            }
        } else {
            throw new GSException("An instance of the Gale-Shapley algorithm needs a non-empty set of students and schools!");
        }


    }
}
