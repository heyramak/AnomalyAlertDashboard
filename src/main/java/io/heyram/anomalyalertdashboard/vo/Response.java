package io.heyram.anomalyalertdashboard.vo;

import io.heyram.anomalyalertdashboard.dao.entity.AnomalyAlertData;

import java.io.Serializable;
import java.util.List;



/**
 * Response object containing creditcard fraud details that will be sent to dashboard.
 * 
 * @author kafka
 *
 */
public class Response implements Serializable {
	private List<AnomalyAlertData> anomalyAlert;
	
	public List<AnomalyAlertData> getAnomalyAlert() {
		return anomalyAlert;
	}
	public void setAnomalyAlert(List<AnomalyAlertData> anomalyAlert) {
		this.anomalyAlert = anomalyAlert;
	}

}
