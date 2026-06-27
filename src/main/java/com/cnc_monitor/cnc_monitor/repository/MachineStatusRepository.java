package com.cnc_monitor.cnc_monitor.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc_monitor.cnc_monitor.entity.MachineStatus;

public interface MachineStatusRepository 
extends JpaRepository<MachineStatus, Long> {
       
       List<MachineStatus>
       findTop50ByOrderByTimestampDesc();

       List<MachineStatus>
       findByMachineName(String machineName);

       MachineStatus findTopByMachineNameOrderByTimestampDesc(String machineName);
       //findtopbymachinenameorderbytimestampdesc significa que se busca el último 
       //estado de la máquina por nombre de máquina y ordenado por timestamp descendente.

       List<MachineStatus>
       findByStatus(String status);

       List<MachineStatus> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
       //esta consulta significa que se busca todos los estados de las máquinas que tengan 
       //un timestamp entre dos fechas específicas.

       long countByStatus(String status);
       
}