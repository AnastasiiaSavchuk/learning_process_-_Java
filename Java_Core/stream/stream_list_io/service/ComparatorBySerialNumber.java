package stream.stream_list_io.service;


import stream.stream_list_io.dto.Device;

import java.util.Comparator;

public class ComparatorBySerialNumber implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return (int) (o1.getSerialNumber() - o2.getSerialNumber());
    }
}
