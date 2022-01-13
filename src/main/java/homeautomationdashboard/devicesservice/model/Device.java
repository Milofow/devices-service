package homeautomationdashboard.devicesservice.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Device(){}


    public Device(long id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
