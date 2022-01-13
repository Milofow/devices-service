package homeautomationdashboard.devicesservice.service;

import homeautomationdashboard.devicesservice.model.Device;

import java.util.List;

public interface DeviceService {
    Device saveDevice(Device device);
    List<Device> getAllDevices();
    Device getDeviceById(long id);
    Device updateDevice(Device device, long id);
    void deleteDevice(long id);
}
