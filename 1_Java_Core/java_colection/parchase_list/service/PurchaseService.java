package java_colection.parchase_list.service;

import java_colection.parchase_list.dto.Purchase;

import java.util.List;
import java.util.Set;

public interface PurchaseService {

    List<Purchase> getAllByInput();

    Set<Purchase> getAllByHash();

    List<Purchase> getAllByCount();

    List<Purchase> getAllByName();
}
