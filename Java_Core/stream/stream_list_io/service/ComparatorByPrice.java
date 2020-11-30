package stream.stream_list_io.service;

import stream.stream_list_io.dto.Device;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return (o1.getPrice() - o2.getPrice());
    }
}
