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
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(long id) {
//        Optional<Device> device = deviceRepository.findById(id);
//        if (device.isPresent()) {
//            return device.get();
//        } else {
//            throw new ResourceNotFoundException("Device", "Id", id);
//        }
        return deviceRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Device", "Id", id));
    }

    @Override
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

    @Override
    public void deleteDevice(long id) {
        //Check if device exists
        deviceRepository.findById(id).orElseThrow(() ->
                                new ResourceNotFoundException("Device", "Id", id));
        deviceRepository.deleteById(id);
    }
}
