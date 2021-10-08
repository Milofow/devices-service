package homeautomationdashboard.devicesservice.models;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Boolean status;

    public Device(){}


    public Device(Integer id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
