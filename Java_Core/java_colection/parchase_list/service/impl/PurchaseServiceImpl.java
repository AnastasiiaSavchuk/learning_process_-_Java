package java_colection.parchase_list.service.impl;

import java_colection.parchase_list.data.impl.PurchaseRepositoryImpl;
import java_colection.parchase_list.dto.Purchase;
import java_colection.parchase_list.service.CountComparator;
import java_colection.parchase_list.service.PurchaseService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PurchaseServiceImpl implements PurchaseService {

    static PurchaseRepositoryImpl purchaseRepository = new PurchaseRepositoryImpl();

    @Override
    public List<Purchase> getAllByInput() {
        return purchaseRepository.getAll();
    }

    @Override
    public Set<Purchase> getAllByHash() {
        Set<Purchase> purchases = new HashSet<>();
        for (Purchase purchase : purchases) {
            purchases.add(purchase);
        }
        return purchases;
    }

    @Override
    public List<Purchase> getAllByCount() {
        List<Purchase> sortedByCount = purchaseRepository.getAll();
        sortedByCount.sort(new CountComparator());
        return sortedByCount;
    }

    @Override
    public List<Purchase> getAllByName() {
        List<Purchase> sortedByName = purchaseRepository.getAll();
        Collections.sort(sortedByName);
        return sortedByName;
    }
}
