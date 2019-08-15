package com.yhchdev.rosesorting.controller;


import com.yhchdev.rosesorting.entity.Rosedata;
import com.yhchdev.rosesorting.repository.RoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class restfulController {

    @Autowired
    RoseRepository roseRepository;

    //查询所有信息
    @RequestMapping("/showrosesdata")
    public String getRose(Model model){
        List<Rosedata> roses =  roseRepository.nativeQueryall();
        model.addAttribute("roses",roses);
        return "datatable";
    }

}
