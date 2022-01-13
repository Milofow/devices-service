package homeautomationdashboard.devicesservice.service.impl;

import homeautomationdashboard.devicesservice.exception.ResourceNotFoundException;
import homeautomationdashboard.devicesservice.model.Device;
import homeautomationdashboard.devicesservice.repository.DeviceRepository;
import homeautomationdashboard.devicesservice.service.DeviceService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl {

    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }


    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


    public Device getDeviceById(long id) {
        return deviceRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Device", "Id", id));
    }


    public Device updateDevice(Device device, long id) {
        //Check if device exists
        Device existingDevice = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device", "Id", id));

        //Update device
        existingDevice.setName(device.getName());
        existingDevice.setStatus(device.getStatus());

        //Save Device to db
        deviceRepository.save(existingDevice);

        return existingDevice;
    }


    public void deleteDevice(long id) {
        //Check if device exists
        getDeviceById(id);
        deviceRepository.deleteById(id);

    }
}
