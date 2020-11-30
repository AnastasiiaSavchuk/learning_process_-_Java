package java_colection.commodity_list.servise;

import java_colection.commodity_list.dto.Commodity;

import java.util.Collection;
import java.util.List;

public interface CommodityService {

    void showList(Collection<Commodity> commodities);

    void addCommodity();

    void removeCommodity();

    void replacementCommodity();

    List<Commodity> getAllByLength();

    List<Commodity> getAllByWidth();

    List<Commodity> getAllByWeight();

    List<Commodity> getAllByName();

    void getElementFromCollection();
}
