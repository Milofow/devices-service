package homeautomationdashboard.devicesservice.controller;


import homeautomationdashboard.devicesservice.model.Device;
import homeautomationdashboard.devicesservice.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //Create device
    @PostMapping()
    public ResponseEntity<Device> saveDevice(@RequestBody Device device) {
        return new ResponseEntity<Device>(deviceService.saveDevice((device)), HttpStatus.CREATED);
    }

    //Get all devices
    @GetMapping()
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    //Get device by id
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") long id) {
        return new ResponseEntity<Device>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    //Update device
    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") long id
                                              ,@RequestBody Device device) {
        return new ResponseEntity<Device>(deviceService.updateDevice(device, id), HttpStatus.OK);
    }

    //Delete device
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") long id) {
        deviceService.deleteDevice(id);

        return new ResponseEntity<String>("Device deleted succesfully", HttpStatus.OK);
    }

}
