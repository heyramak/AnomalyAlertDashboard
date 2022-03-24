package io.heyram.anomalyalertdashboard.dao.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity class for anomaly db table
 * 
 * @author kafka
 *
 */
@Table("anomaly")
public class FraudAlertData implements Serializable{


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "IST")
	@PrimaryKeyColumn(name = "trans_time",ordinal = 1,type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private Date trans_time;
	@Indexed(value = "xAttack")
	private String xAttack;
	@Column(value = "duration")
	private Double duration;
	@Column(value = "protocol_type")
	private String protocol_type;
	@Column(value = "service")
	private String service;
	@Column(value = "flag")
	private String flag;
	@Column(value = "src_bytes")
	private Double src_bytes;
	@Column(value = "dst_bytes")
	private Double dst_bytes;

	public Date getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(Date trans_time) {
		this.trans_time = trans_time;
	}

	public String getxAttack() {
		return xAttack;
	}

	public void setxAttack(String xAttack) {
		this.xAttack = xAttack;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getProtocol_type() {
		return protocol_type;
	}

	public void setProtocol_type(String protocol_type) {
		this.protocol_type = protocol_type;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Double getSrc_bytes() {
		return src_bytes;
	}

	public void setSrc_bytes(Double src_bytes) {
		this.src_bytes = src_bytes;
	}

	public Double getDst_bytes() {
		return dst_bytes;
	}

	public void setDst_bytes(Double dst_bytes) {
		this.dst_bytes = dst_bytes;
	}

	@Override
	public String toString() {
		return "FraudAlertData{" +
				"trans_time=" + trans_time +
				", xAttack='" + xAttack + '\'' +
				", duration=" + duration +
				", protocol_type='" + protocol_type + '\'' +
				", service='" + service + '\'' +
				", flag='" + flag + '\'' +
				", src_bytes=" + src_bytes +
				", dst_bytes=" + dst_bytes +
				'}';
	}
}
