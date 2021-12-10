package homeautomationdashboard.devicesservice;

import homeautomationdashboard.devicesservice.model.Device;
import homeautomationdashboard.devicesservice.repository.DeviceRepository;
import homeautomationdashboard.devicesservice.service.DeviceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;


@DataJpaTest
public class DeviceRepositoryTests {

    @Autowired
    private DeviceRepository deviceRepository;


    @Test
    public void saveDeviceTest() {
        //Arrange
        Device device = Device.builder()
                .name("Lamp")
                .status(true)
                .build();

        //Act
        deviceRepository.save(device);

        //Assert
        Assertions.assertThat(device.getId()).isGreaterThan(0);
    }

    @Test
    public void getDeviceTest() {
        //Arrange
        Device device = Device.builder()
                .name("Lamp")
                .status(true)
                .build();

        //Act
        deviceRepository.save(device);
        Device newDevice = deviceRepository.getById(device.getId());

        //Assert
        Assertions.assertThat(newDevice).isEqualTo(device);
    }

//    @Test
//    public void getListOfDevicesTest() {
//        //Arrange
//
//        //Act
//        List<Device> devices = deviceRepository.findAll();
//
//        //Assert
//        Assertions.assertThat(devices.size()).isGreaterThan(0);
//    }
}