package stream.stream_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five", "One"));

        long element = list.stream().filter(word -> word.equalsIgnoreCase("one")).count();
        System.out.println("1. Show how often use 'one' in list : ");
        System.out.println("   " + element);

        String firstElement = list.stream().findFirst().orElse("0");
        System.out.println("\n2. First element is : ");
        System.out.println(firstElement);

        System.out.println("\n3. Last element is : ");
        list.stream().skip(list.size() - 1).forEach(System.out::println);

        String equalsThree = list.stream().filter(word -> word.equalsIgnoreCase("three")).findAny().orElseThrow();
        System.out.println("\n4. Element equals 'three' : ");
        System.out.println(equalsThree);

        System.out.println("\n5. Third element is : ");
        list.stream().skip(2).limit(1).forEach(System.out::println);

        System.out.println("\n6. Show two element from second : ");
        list.stream().skip(1).limit(2).forEach(System.out::println);

        System.out.println("\n7. Elements that have more 3 chars in word : ");
        list.stream().filter(word -> word.length() > 3).forEach(System.out::println);

        System.out.println("\n8. List without repetition : ");
        list.stream().distinct().forEach(System.out::println);

        System.out.println("\n9. Is there at least one item 'one' : ");
        boolean anyMatch = list.stream().anyMatch(word -> word.equalsIgnoreCase("one"));
        System.out.println(anyMatch);

        System.out.println("\n10. Whether the symbol 'o' is in all elements : ");
        boolean allMatch = list.stream().allMatch(word -> word.contains("o"));
        System.out.println(allMatch);

        System.out.println("\n11. Whether the symbol 'o' is in all elements : ");
        list.stream().map(word -> word + 1).forEach(System.out::println);

        System.out.println("\n12. Sorted list : ");
        list.stream().sorted().distinct().forEach(System.out::println);
    }
}
