package java_colection.commodity_list.servise.Impl;

import java_colection.commodity_list.data.impl.CommodityDataImpl;
import java_colection.commodity_list.dto.Commodity;
import java_colection.commodity_list.servise.CommodityService;
import java_colection.commodity_list.servise.LengthComparator;
import java_colection.commodity_list.servise.WeightComparator;
import java_colection.commodity_list.servise.WidthComparator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CommodityServiceImpl implements CommodityService {

    private static Scanner scanner = new Scanner(System.in);
    private static CommodityDataImpl commodityData = new CommodityDataImpl();

    @Override
    public void showList(Collection<Commodity> commodities) {
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    @Override
    public void addCommodity() {
        int stop = 0;
        do {
            commodityData.add(new Commodity("bed", 220, 180, 40));
            commodityData.add(new Commodity("table", 220, 180, 20));
            commodityData.add(new Commodity("wardrobe", 300, 250, 56));
            commodityData.add(new Commodity("shelves", 140, 60, 30));
            commodityData.add(inputCommodity());
            System.out.println("Exit - 0 , continue - eny number :");
            stop = scanner.nextInt();
        } while (stop != 0);
    }

    private static Commodity inputCommodity() {
        System.out.println("Insert name of commodity : ");
        String name = scanner.next();
        System.out.println("Insert length of commodity : ");
        int length = scanner.nextInt();
        System.out.println("Insert width of commodity : ");
        int width = scanner.nextInt();
        System.out.println("Insert weight of commodity : ");
        int weight = scanner.nextInt();
        return new Commodity(name, length, width, weight);
    }

    @Override
    public void removeCommodity() {
        List<Commodity> remove = commodityData.getAll();
        remove.remove(2);
    }

    @Override
    public void replacementCommodity() {
        List<Commodity> replacement = commodityData.getAll();
        Commodity replaceCommodity = replacement.set(1, new Commodity("mirror", 180, 50, 34));
    }

    @Override
    public List<Commodity> getAllByLength() {
        List<Commodity> sortedByLength = commodityData.getAll();
        sortedByLength.sort(new LengthComparator());
        return sortedByLength;
    }

    @Override
    public List<Commodity> getAllByWidth() {
        List<Commodity> sortedByWidth = commodityData.getAll();
        sortedByWidth.sort(new WidthComparator());
        return sortedByWidth;
    }

    @Override
    public List<Commodity> getAllByWeight() {
        List<Commodity> sortedByWeight = commodityData.getAll();
        sortedByWeight.sort(new WeightComparator());
        return sortedByWeight;
    }

    @Override
    public List<Commodity> getAllByName() {
        List<Commodity> sortedByName = commodityData.getAll();
        Collections.sort(sortedByName);
        return sortedByName;
    }

    @Override
    public void getElementFromCollection() {
        List<Commodity> commodities = commodityData.getAll();
        System.out.println("Enter commodity name : ");
        String nameCommodity = scanner.next();
        for (Commodity commodity : commodities) {
            if (nameCommodity.equalsIgnoreCase(commodity.getName())) {
                System.out.println(commodity.toString());
            }
        }
    }
}
