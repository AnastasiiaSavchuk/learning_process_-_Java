package stream.stream_people;

import java.util.Comparator;

public class SortedByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
