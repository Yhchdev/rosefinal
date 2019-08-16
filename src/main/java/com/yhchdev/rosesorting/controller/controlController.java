package com.yhchdev.rosesorting.controller;
import com.alibaba.fastjson.JSONObject;
import com.yhchdev.rosesorting.gateway.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlController {
    @Autowired
    private MqttGateway mqttGateway;

    // 重拍图片
    @RequestMapping(value ="/control/re")
    public void re()
    {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("state",0);
        jsonObj.put("model",2);
        jsonObj.put("msg","re do detection");
        String data = jsonObj.toString();
        mqttGateway.send(data,"control");
    }

    //评估模式
    @RequestMapping(value = "/control/assess")
    public void assess(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("state",0);
        jsonObj.put("model",3);
        jsonObj.put("msg","评估");
        String data = jsonObj.toString();
        mqttGateway.send(data,"control");
    }
}
