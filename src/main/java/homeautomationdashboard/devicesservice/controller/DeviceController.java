package homeautomationdashboard.devicesservice.controller;


import homeautomationdashboard.devicesservice.model.Device;
import homeautomationdashboard.devicesservice.service.DeviceService;
import homeautomationdashboard.devicesservice.service.impl.DeviceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class DeviceController {

    private final DeviceServiceImpl deviceService;

    public DeviceController(DeviceServiceImpl deviceService) {
        this.deviceService = deviceService;
    }

    //Create device
    @PostMapping("devices")
    public ResponseEntity<Device> saveDevice(@RequestBody Device device) {
        return new ResponseEntity<Device>(deviceService.saveDevice((device)), HttpStatus.CREATED);
    }

    //Get all devices
    @GetMapping("devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    //Get device by id
    @GetMapping("devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") long id) {
        return new ResponseEntity<Device>(deviceService.getDeviceById(id), HttpStatus.OK);
    }

    //Update device
    @PutMapping("devices/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") long id
                                              ,@RequestBody Device device) {
        return new ResponseEntity<Device>(deviceService.updateDevice(device, id), HttpStatus.OK);
    }

    //Delete device
    @DeleteMapping("devices/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") long id) {
        try {
            deviceService.deleteDevice(id);
            return new ResponseEntity<String>("Device deleted successfully", HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.toString(), HttpStatus.NOT_FOUND);
        }

    }

}
