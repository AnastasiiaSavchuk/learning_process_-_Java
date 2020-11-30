package java_colection.store_map_jenerics.data;

import java_colection.store_map_jenerics.dto.Apple;
import java_colection.store_map_jenerics.dto.Price;

import java.util.*;

public class DatabaseApple {

    public Map<Apple<String>, List<Price>> map = new LinkedHashMap<>();

    public Map<Apple<String>, List<Price>> databaseApple() {

        Apple<String> apple1 = new Apple<>("iphone");
        List<Price> prices1 = new ArrayList<>(Arrays.asList(new Price("7", 580),
                new Price("XS", 760), new Price("11 pro", 1005)));
        Apple<String> apple2 = new Apple<>("airPods");
        List<Price> prices2 = new ArrayList<>(Arrays.asList(new Price("1", 280),
                new Price("2", 360), new Price("pro", 405)));
        Apple<String> apple3 = new Apple<>("macBook");
        List<Price> prices3 = new ArrayList<>(Arrays.asList(new Price("air", 826),
                new Price("pro 13'", 1854), new Price("pro 16'", 2189)));
        map.put(apple1, prices1);
        map.put(apple2, prices2);
        map.put(apple3, prices3);

        return map;
    }
}
