package com.cnc_monitor.cnc_monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc_monitor.cnc_monitor.entity.MachineStatus;

public interface MachineStatusRepository 
extends JpaRepository<MachineStatus, Long> {
       
       List<MachineStatus>
       findTop50ByOrderByTimestampDesc();

       List<MachineStatus>
       findByMachineName(String machineName);

       List<MachineStatus>
       findByStatus(String status);

       long countByStatus(String status);
       
}