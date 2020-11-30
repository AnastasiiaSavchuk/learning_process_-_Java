package stream.stream_people;

import java.util.Comparator;

public class SortedByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
