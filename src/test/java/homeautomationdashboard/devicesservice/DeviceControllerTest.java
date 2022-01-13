package homeautomationdashboard.devicesservice;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import homeautomationdashboard.devicesservice.controller.DeviceController;
import homeautomationdashboard.devicesservice.exception.ResourceNotFoundException;
import homeautomationdashboard.devicesservice.model.Device;
import homeautomationdashboard.devicesservice.repository.DeviceRepository;
import homeautomationdashboard.devicesservice.service.DeviceService;
import homeautomationdashboard.devicesservice.service.impl.DeviceServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import homeautomationdashboard.devicesservice.exception.ResourceNotFoundException;

@WebMvcTest(DeviceController.class)
@AutoConfigureMockMvc
public class DeviceControllerTest {

    private static final int UNKNOWN_ID = Integer.MAX_VALUE;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceServiceImpl service;


    @Test
    public void Should_DeleteDeviceById_When_DeviceIsFound() throws Exception {
        Device device = new Device(12L, "Lamp 1", true);

        when(service.getDeviceById(device.getId())).thenReturn(device);
        doNothing().when(service).deleteDevice(device.getId());

        mockMvc.perform(delete("/api/devices/{id}", device.getId()))
                .andExpect(status().isOk());

        //verify(service, times(1)).getDeviceById(device.getId());
        verify(service, times(1)).deleteDevice(device.getId());
        verifyNoMoreInteractions(service);
    }

//    @Test
//    public void Should_ThrowException_When_DeviceIsNotFound() throws Exception {
//        //when(service.getDeviceById(UNKNOWN_ID)).thenThrow(new ResourceNotFoundException("Device", "Id", UNKNOWN_ID));
//        //when(service.getDeviceById(UNKNOWN_ID)).thenReturn(null);
//        Mockito.when(service.getDeviceById(UNKNOWN_ID)).thenReturn(null);
//
//        mockMvc.perform(delete("/api/devices/{id}", UNKNOWN_ID))
//                .andExpect(status().isNotFound());
//
//        //verify(service, times(1)).getDeviceById(UNKNOWN_ID);
//        //verifyNoMoreInteractions(service);
//    }

}