package java_colection.commodity_list.data.impl;

import java_colection.commodity_list.data.CommodityData;
import java_colection.commodity_list.dto.Commodity;

import java.util.ArrayList;
import java.util.List;

public class CommodityDataImpl implements CommodityData {

    static List<Commodity> commodityList = new ArrayList<>();

    @Override
    public void add(Commodity commodity) {
        commodityList.add(commodity);
    }

    @Override
    public List<Commodity> getAll() {
        return commodityList;
    }
}
