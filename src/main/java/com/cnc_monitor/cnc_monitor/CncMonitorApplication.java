package com.cnc_monitor.cnc_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CncMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CncMonitorApplication.class, args);
	}

}