package java_colection.parchase_list.data.impl;

import java_colection.parchase_list.dto.Purchase;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRepositoryImpl {

    static List<Purchase> purchases = new ArrayList<>();

    public void add(Purchase purchase) {
        purchases.add(purchase);
    }

    public List<Purchase> getAll() {
        return purchases;
    }
}
