package java_colection.commodity_list.servise;

import java_colection.commodity_list.dto.Commodity;

import java.util.Comparator;

public class WidthComparator implements Comparator<Commodity> {

    @Override
    public int compare(Commodity o1, Commodity o2) {
        return o1.getWidth() - o2.getWidth();
    }
}
