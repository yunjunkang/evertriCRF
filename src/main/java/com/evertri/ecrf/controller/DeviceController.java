package com.evertri.ecrf.controller;

import com.evertri.ecrf.model.Device;
import com.evertri.ecrf.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Handles HTTP POST requests to /devices, which creates a new device
    @PostMapping
    public Device createDevice(@RequestParam("macAddress") String macAddress) {
        return deviceService.createDevice(macAddress);
    }

    // Handles HTTP DELETE requests to /devices/{id}, which deletes the device with the given ID
    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable("id") Long id) {
        deviceService.deleteDevice(id);
    }
}
