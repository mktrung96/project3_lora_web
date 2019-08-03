/**
 * entities
 */
package entities;

import java.sql.Date;
import java.sql.Time;

/**
 * @author phanthanhtrung
 *
 */
public class Record {

	int stt;
	private float temp;
	private float humi;
	private float pressure;

	// giá trị đo được từ các cảm biến
	private float co;
	private float co2;
//	private float no2;
//	private float so2;
//	private float o3;
//	private float pm25;
//	private float pm10;
	private float ethanol;
	private float toluene;
	private float acetone;
	private Time timeRecord;
	private Date dateRecord;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getHumi() {
		return humi;
	}

	public void setHumi(float humi) {
		this.humi = humi;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getCo() {
		return co;
	}

	public void setCo(float co) {
		this.co = co;
	}

	
//	public float getNo2() {
//		return no2;
//	}
//
//	public void setNo2(float no2) {
//		this.no2 = no2;
//	}
//
//	public float getSo2() {
//		return so2;
//	}
//
//	public void setSo2(float so2) {
//		this.so2 = so2;
//	}
//
//	public float getO3() {
//		return o3;
//	}
//
//	public void setO3(float o3) {
//		this.o3 = o3;
//	}
//
//	public float getPm25() {
//		return pm25;
//	}
//
//	public void setPm25(float pm25) {
//		this.pm25 = pm25;
//	}
//
//	public float getPm10() {
//		return pm10;
//	}
//
//	public void setPm10(float pm10) {
//		this.pm10 = pm10;
//	}

	public float getEthanol() {
		return ethanol;
	}

	public void setEthanol(float ethanol) {
		this.ethanol = ethanol;
	}

	public float getToluene() {
		return toluene;
	}

	public void setToluene(float toluene) {
		this.toluene = toluene;
	}

	public float getAcetone() {
		return acetone;
	}

	public void setAcetone(float acetone) {
		this.acetone = acetone;
	}

	public Time getTimeRecord() {
		return timeRecord;
	}

	public void setTimeRecord(Time timeRecord) {
		this.timeRecord = timeRecord;
	}

	public Date getDateRecord() {
		return dateRecord;
	}

	public void setDateRecord(Date dateRecord) {
		this.dateRecord = dateRecord;
	}

	public float getCo2() {
		return co2;
	}

	public void setCo2(float co2) {
		this.co2 = co2;
	}

	

}
