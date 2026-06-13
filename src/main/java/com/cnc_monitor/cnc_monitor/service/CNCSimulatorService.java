package com.cnc_monitor.cnc_monitor.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cnc_monitor.cnc_monitor.entity.MachineStatus;
import com.cnc_monitor.cnc_monitor.repository.MachineStatusRepository;

@Service
public class CNCSimulatorService {

    @Autowired
    private MachineStatusRepository repository;

    private Random random = new Random();

    private String[] states = {
        "RUNNING",
        "IDLE",
        "SETUP",
        "ALARM",
        "TOOL_CHANGE",
        "WAITING_MATERIAL",
        "QUALITY_CHECK"
    };

    private String[] machines = {
        "CNC-01",
        "CNC-02",
        "CNC-03"
    };

    @Scheduled(fixedRate = 5000)
    public void simulateData() {

        MachineStatus data = new MachineStatus();

        data.setMachineName(machines[random.nextInt(machines.length)]);
        data.setStatus(states[random.nextInt(states.length)]);
        data.setProductionCount(random.nextInt(100));
        data.setTimestamp(LocalDateTime.now());

        repository.save(data);

        System.out.println("Datos CNC simulados guardados");
    }
}