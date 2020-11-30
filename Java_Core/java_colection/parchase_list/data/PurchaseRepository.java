package java_colection.parchase_list.data;

import java_colection.parchase_list.dto.Purchase;

import java.util.List;

public interface PurchaseRepository {

    void add(Purchase purchase);

    List<Purchase> getAll();
}

