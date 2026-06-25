package com.cnc_monitor.cnc_monitor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cnc_monitor.cnc_monitor.entity.MachineStatus;
import com.cnc_monitor.cnc_monitor.repository.MachineStatusRepository;

@Service
public class DashboardService {

    private final MachineStatusRepository repository;

    public DashboardService(
            MachineStatusRepository repository) {
            this.repository = repository;
    }

    public long getRunningMachines() {
        return repository.countByStatus("RUNNING");
    }

    public long getAlarmMachines() {
        return repository.countByStatus("ALARM");
    }

    public long getTotalRecordsActual() {
        return repository.count();
    }

    public List<MachineStatus> getCurrentMachineStatus() {

        List<MachineStatus> currentStatus = new ArrayList<>();

        currentStatus.add(repository.findTopByMachineNameOrderByTimestampDesc("CNC-01"));

        currentStatus.add(repository.findTopByMachineNameOrderByTimestampDesc("CNC-02"));

        currentStatus.add(repository.findTopByMachineNameOrderByTimestampDesc("CNC-03"));

        return currentStatus;
    }

    public int getCurrentProduction() {

        return getCurrentMachineStatus()
                .stream()
                .mapToInt(MachineStatus::getProductionCount)
                .sum();
    }

    
}