package io.heyram.anomalyalertdashboard.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot application class for Dashboard.
 * 
 * @author kafka
 *
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"io.heyram.anomalyalertdashboard.dashboard", "io.heyram.anomalyalertdashboard.dao"})
public class AnomalyAlertDashboard {

	  public static void main(String[] args)
	  {
		  SpringApplication.run(AnomalyAlertDashboard.class, args);
	  }
	}

