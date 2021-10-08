package homeautomationdashboard.devicesservice.repositories;

import homeautomationdashboard.devicesservice.models.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Integer> {}
