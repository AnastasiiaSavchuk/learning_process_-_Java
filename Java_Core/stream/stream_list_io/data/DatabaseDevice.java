package stream.stream_list_io.data;


import stream.stream_list_io.dto.Device;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseDevice {

    public static List<Device> data() {

        List<Device> devices = new ArrayList<>();
        try (FileReader fileReader = new FileReader("E:/Java/input.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                devices.add((createDevice(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devices;
    }

    public static Device createDevice(String data) {
        Device device = new Device();
        String[] deviceData = data.split(", ");
        device.setSerialNumber(Long.parseLong(deviceData[0]));
        device.setBrand(deviceData[1]);
        device.setInfo(deviceData[2]);
        device.setPrice(Integer.parseInt(deviceData[3]));
        return device;
    }
}
