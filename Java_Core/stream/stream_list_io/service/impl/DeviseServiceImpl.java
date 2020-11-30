package stream.stream_list_io.service.impl;

import stream.stream_list_io.data.DatabaseDevice;
import stream.stream_list_io.dto.Device;
import stream.stream_list_io.service.ComparatorByBrand;
import stream.stream_list_io.service.ComparatorByPrice;
import stream.stream_list_io.service.ComparatorBySerialNumber;
import stream.stream_list_io.service.DeviseService;

import java.util.List;

public class DeviseServiceImpl implements DeviseService {

    private static List<Device> devices = DatabaseDevice.data();

    @Override
    public void showAll() {
        System.out.println("\n1. All devise");
        devices.forEach(System.out::println);
    }

    @Override
    public void showDeviseBySerialNumber() {
        System.out.println("\n2. Devise sorted by serial number.");
        devices.stream().sorted(new ComparatorBySerialNumber()).forEach(System.out::println);
    }

    @Override
    public void sortedByBrand() {
        System.out.println("\n3. Device sorted by brand : ");
        devices.stream().sorted(new ComparatorByBrand()).forEach(System.out::println);
    }

    @Override
    public void showDeviseCostMore() {
        System.out.println("\n4. Devise cost more 400 : ");
        devices.stream().filter(device -> device.getPrice() > 400).forEach(System.out::println);
    }

    @Override
    public void showDeviseBySerialNumberAndCost() {
        System.out.println("\n5. Devise sorted by serial number contain 0 and cost less 800 ");
        devices.stream().filter(device -> String.valueOf(device.getSerialNumber()).contains("0") && device.getPrice() < 800)
                .forEach(System.out::println);
    }

    @Override
    public void maxCostDevise() {
        System.out.println("\n6. Max cost devise");
        Device max = devices.stream().max(new ComparatorByPrice()).orElseThrow();
        System.out.println(max);
    }
}
