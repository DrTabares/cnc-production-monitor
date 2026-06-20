package com.cnc_monitor.cnc_monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnc_monitor.cnc_monitor.repository.MachineStatusRepository;
import com.cnc_monitor.cnc_monitor.service.DashboardService;

@Controller
public class DashboardController {

    private final MachineStatusRepository repository;

    private final DashboardService dashboardService;

    public DashboardController(MachineStatusRepository repository, DashboardService dashboardService) {

        this.repository = repository;
        this.dashboardService = dashboardService;
    }

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

        model.addAttribute(
            "runningMachines",
            dashboardService.getRunningMachines()
        );

        model.addAttribute(
            "alarmMachines",
            dashboardService.getAlarmMachines()
        );

        model.addAttribute(
            "totalRecordsActual",
            dashboardService.getTotalRecordsActual()
        );

        return "dashboard";
    }
        
}