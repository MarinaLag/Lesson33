package lesson_33._04_strream_usege.model;

import java.util.Comparator;

public class ChickenComporator implements Comparator<Chicken> {
    @Override
    public int compare(Chicken o1, Chicken o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
