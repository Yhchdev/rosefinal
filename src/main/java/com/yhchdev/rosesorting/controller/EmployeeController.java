package com.yhchdev.rosesorting.controller;


import com.yhchdev.rosesorting.entity.Employee;
import com.yhchdev.rosesorting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;


    @RequestMapping("/emps")
    public String getEmplist(Model model){
        List<Employee> emps= employeeRepository.Queryallemps();
        model.addAttribute("emps",emps);
        return "emp/emplo";
    }

}
