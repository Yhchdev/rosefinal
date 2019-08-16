package com.yhchdev.rosesorting.controller;






import com.yhchdev.rosesorting.gateway.MqttGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlController {
    @Autowired
    private MqttGateway mqttGateway;

    @RequestMapping(value ="/control/1")
    public void assess()
    {
        mqttGateway.send("1","hello");
    }
}
