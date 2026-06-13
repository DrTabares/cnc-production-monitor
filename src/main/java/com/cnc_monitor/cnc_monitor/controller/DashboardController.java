package com.cnc_monitor.cnc_monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnc_monitor.cnc_monitor.repository.MachineStatusRepository;

@Controller
public class DashboardController {

    @Autowired
    private MachineStatusRepository repository;

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
            "machines",
            repository.findTop50ByOrderByTimestampDesc()
        );

        model.addAttribute(
            "totalRecords",
            repository.count()
        );

        return "dashboard";
    }
        
}
