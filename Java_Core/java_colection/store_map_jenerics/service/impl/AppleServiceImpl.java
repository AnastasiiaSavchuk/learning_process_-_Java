package java_colection.store_map_jenerics.service.impl;

import java_colection.store_map_jenerics.data.DatabaseApple;
import java_colection.store_map_jenerics.dto.Apple;
import java_colection.store_map_jenerics.dto.Price;
import java_colection.store_map_jenerics.service.AppleService;
import java_colection.store_map_jenerics.service.NoEntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppleServiceImpl implements AppleService {

    DatabaseApple database = new DatabaseApple();
    Map<Apple<String>, List<Price>> map = database.databaseApple();

    @Override
    public void addApple(Apple apple) {
        map.put(apple, new ArrayList<>());
    }

    public void addPrice(Apple apple, Price price) {
        for (Map.Entry<Apple<String>, List<Price>> entry : map.entrySet()) {
            if (entry.getKey().equals(apple)) {
                List<Price> priceToAdd = entry.getValue();
                priceToAdd.add(price);
                entry.setValue(priceToAdd);
            }
        }
    }

    public Apple getAppleByType(String type) throws NoEntityException {
        Apple apple = null;
        for (Apple<String> a : map.keySet()) {
            if (type.equalsIgnoreCase(a.getType())) {
                apple = a;
            }
        }
        if (apple == null) {
            throw new NoEntityException("Apple with type " + type + " not found");
        }
        return apple;
    }

    @Override
    public void removeAppleByPrice(Apple apple, Price price) {
        List<Price> priceList;
        for (Map.Entry<Apple<String>, List<Price>> entry : map.entrySet()) {
            if (entry.getKey().equals(apple)) {
                priceList = entry.getValue();
                priceList.remove(price);
                entry.setValue(priceList);
            }
        }
    }

    @Override
    public void showPriceForAppleType(Apple apple) {
        for (Price price : map.get(apple)) {
            System.out.println(price);
        }
    }

    public Price getPriceByModel(Apple apple, String price) {
        Price prices = null;
        for (Price priceToRemove : map.get(apple)) {
            if (priceToRemove.getModel().equalsIgnoreCase(price)) {
                prices = priceToRemove;
            }
        }
        return prices;
    }

    @Override
    public void removeAppleByType(Apple apple) {
        map.remove(apple);
    }

    @Override
    public void showKey() {
        System.out.println("Key : ");
        for (Apple<String> appleList : map.keySet()) {
            System.out.println(appleList);
        }
    }

    @Override
    public void showValue() {
        System.out.println("Value : ");
        for (List<Price> priceList : map.values()) {
            System.out.println(priceList);
        }
    }

    @Override
    public void showAll() {
        for (Map.Entry<Apple<String>, List<Price>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
