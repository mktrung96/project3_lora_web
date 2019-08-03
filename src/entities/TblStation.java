/**
 * 
 */
package entities;

/**
 * @author phanthanhtrung
 *
 */
public class TblStation {
	private int stationId;
	private String stationName;
	private String longitude;
	private String latitude;

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

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "TblStation [stationId=" + stationId + ", stationName=" + stationName + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", getLongitude()=" + getLongitude() + ", getLatitude()=" + getLatitude()
				+ ", getStationId()=" + getStationId() + ", getStationName()=" + getStationName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
