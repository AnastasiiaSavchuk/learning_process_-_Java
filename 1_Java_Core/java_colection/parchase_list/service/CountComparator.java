package java_colection.parchase_list.service;

import java_colection.parchase_list.dto.Purchase;

import java.util.Comparator;

public class CountComparator implements Comparator<Purchase> {

    @Override
    public int compare(Purchase o1, Purchase o2) {
        return o1.getCount() - o2.getCount();
    }
}
