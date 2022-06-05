package io.heyram.anomalyalertdashboard.dao;

import io.heyram.anomalyalertdashboard.dao.entity.AnomalyAlertData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * DAO class for fraud_transaction
 *
 * @author kafka
 *
 */
@Repository
public interface AnomalyAlertDataRepository extends CassandraRepository<AnomalyAlertData>{

	 @Query("SELECT id, duration, trans_time, service, flag, src_bytes, dst_bytes, trans_time, xAttack FROM intrusiondetection.anomaly WHERE trans_time > ?0 ALLOW FILTERING" )
	 Iterable<AnomalyAlertData> findAnomalyDataByTimestamp(Long timestamp);
}
