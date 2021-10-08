package homeautomationdashboard.devicesservice.controllers;


import homeautomationdashboard.devicesservice.models.Device;
import homeautomationdashboard.devicesservice.repositories.DeviceRepository;
import jdk.dynalink.linker.support.DefaultInternalObjectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    public Iterable<Device> FindAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> FindDeviceById(@PathVariable(value = "id") Integer id) {
        Optional<Device> device = deviceRepository.findById(id);

        if (device.isPresent()) {
            return ResponseEntity.ok().body(device.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Device SaveDevice(@Validated @RequestBody Device device){
        return deviceRepository.save(device);
    }

}
