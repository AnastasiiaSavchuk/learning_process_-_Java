package java_colection.set_comparator;

import java.util.*;

public class HashSet {

    public static void main(String[] args) {
        Set<Flower> flowerSet = new java.util.HashSet<>();
        flowerSet.add(new Flower("rose", 15));
        flowerSet.add(new Flower("pidsniznuk", 32));
        flowerSet.add(new Flower("tylpan", 23));
        flowerSet.add(new Flower("orhideia", 1));

        System.out.println("Unsorted :");
        showAll(flowerSet);

        System.out.println("\nSorted by name : ");
        sortedByName(flowerSet);

        System.out.println("\nSorted by count : ");
        sortedByCount(flowerSet);
    }

    public static void showAll(Collection<Flower> collection) {
        for (Flower flower : collection) {
            System.out.println(flower);
        }
    }

    protected static void sortedByName(Collection<Flower> collection) {
        List<Flower> flowers = new ArrayList<>(collection);
        flowers.sort(new SortedByName());
        showAll(flowers);
    }

    public static void sortedByCount(Collection<Flower> collection) {
        List<Flower> flowers = new ArrayList<>(collection);
        Collections.sort(flowers);
        showAll(flowers);
    }
}
