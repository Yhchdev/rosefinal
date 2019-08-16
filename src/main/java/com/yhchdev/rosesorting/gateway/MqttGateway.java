package com.yhchdev.rosesorting.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @author XH.M
 * @create 2019-04-28 16:34
 */
@MessagingGateway(defaultRequestChannel = "mqttOutputChannel")
public interface MqttGateway {
    void send(String data, @Header(MqttHeaders.TOPIC) String topic);
}
