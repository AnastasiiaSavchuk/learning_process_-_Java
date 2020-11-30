package java_colection.commodity_list.data;


import java_colection.commodity_list.dto.Commodity;

import java.util.List;

public interface CommodityData {

    void add(Commodity commodity);

    List<Commodity> getAll();
}
