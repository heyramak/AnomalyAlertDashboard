package io.heyram.anomalyalertdashboard.dashboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import io.heyram.anomalyalertdashboard.dao.AnomalyAlertDataRepository;
import io.heyram.anomalyalertdashboard.dao.entity.AnomalyAlertData;
import io.heyram.anomalyalertdashboard.vo.Response;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * Service class to send anomaly transaction messages to dashboard ui at fixed interval using web-socket.
 * 
 * @author kafka
 *
 */
@Service
public class AnomalyAlertService {
	private static final Logger logger = Logger.getLogger(AnomalyAlertService.class);


	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private AnomalyAlertDataRepository anomalyAlertRepository;
	
	private long previous_timestamp=0L;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	//Method sends anomaly message in every 5 seconds.
	@Scheduled(fixedRate = 5000)
	public void trigger() {

		List<AnomalyAlertData> recentAnomalyList = new ArrayList<AnomalyAlertData>();
		//Call dao methods
		if(previous_timestamp==0) {
			anomalyAlertRepository.findAnomalyDataByTimestamp(new Date().getTime() - 10000).forEach(recentAnomalyList::add);
		}
		else {
			anomalyAlertRepository.findAnomalyDataByTimestamp(previous_timestamp).forEach(recentAnomalyList::add);
		}
		recentAnomalyList.sort(new CustomComparator());
		previous_timestamp = recentAnomalyList.get(0).getTrans_time().getTime();
		logger.info("Previous_timestamp: " + previous_timestamp);


		//prepare response
		Response response = new Response();
		response.setAnomalyAlert(recentAnomalyList);
		logger.info("Sending to UI "+response);
		//send to ui
		this.template.convertAndSend("/topic/anomalyData", response);
	}

	public static class CustomComparator implements Comparator<AnomalyAlertData> {
		@Override
		public int compare(AnomalyAlertData o1, AnomalyAlertData o2) {
			return o2.getTrans_time().compareTo(o1.getTrans_time());

		}
	}
	
}
