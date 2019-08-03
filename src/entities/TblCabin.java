/**
 * 
 */
package entities;

import java.sql.Date;
import java.sql.Time;

/**
 * @author phanthanhtrung
 *
 */
public class TblCabin {
	private int cabinID;
	private int trainID;
	private float temp;
	private float humi;
	private float co;
	private float ethanol;
	private float toluene;
	private float acetone;
	private float co2;
//	private float no2;
//	private float so2;
//	private float o3;
//	private float pm25;
//	private float pm10;
	private Date DateRecord;
	private Time TimeRecord;

	private String longitude;
	private String latitude;

	public Date getDateRecord() {
		return DateRecord;
	}

	public void setDateRecord(Date dateRecord) {
		DateRecord = dateRecord;
	}

	public Time getTimeRecord() {
		return TimeRecord;
	}

	public void setTimeRecord(Time timeRecord) {
		TimeRecord = timeRecord;
	}

	public int getCabinID() {
		return cabinID;
	}

	public void setCabinID(int cabinID) {
		this.cabinID = cabinID;
	}

	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
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

//	public float getPressure() {
//		return pressure;
//	}
//
//	public void setPressure(float pressure) {
//		this.pressure = pressure;
//	}

	public float getCo() {
		return co;
	}

	public void setCo(float co) {
		this.co = co;
	}

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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public float getCo2() {
		return co2;
	}

	public void setCo2(float co2) {
		this.co2 = co2;
	}

}
