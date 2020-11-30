package java_colection.store_map_jenerics.service;

import java_colection.store_map_jenerics.dto.Apple;
import java_colection.store_map_jenerics.dto.Price;

public interface AppleService {

    void addApple(Apple apple);

    public void addPrice(Apple apple, Price price);

    Apple getAppleByType(String type) throws NoEntityException;

    void removeAppleByPrice(Apple apple, Price price);

    void showPriceForAppleType(Apple apple);

    Price getPriceByModel(Apple apple, String price);

    void removeAppleByType(Apple apple);

    void showKey();

    void showValue();

    void showAll();
}
