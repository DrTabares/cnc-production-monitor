package com.cnc_monitor.cnc_monitor.service;

import org.springframework.stereotype.Service;

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
}