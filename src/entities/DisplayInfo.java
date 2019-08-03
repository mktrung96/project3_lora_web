/**
 * 
 */
package entities;

import java.util.List;

/**
 * @author phanthanhtrung
 *
 */
public class DisplayInfo {
	private int cabinID;
	private int trainID;
	private String trainName;
	private float temp;
	private float humi;
	private String longitude;
	private String latitude;

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
	// các giá trị aqi
	private int aqi; // giá trị aqi tổng quát
	private float coAQI;
//	private float no2AQI;
//	private float so2AQI;
//	private float o3AQI;
//	private float pm25AQI;
//	private float pm10AQI;
	private float ethanolAQI;
	private float toluenceAQI;
	private float acetoneAQI;
	private String title;
	private String des;
	private String pinIcon;
	private String time_record;
	private String color;
	private String nextStation;
	private String pinMap;
	// thống kê ngày
	private List<String> colorAQIDateStat;
	private String selDate;
	private String typeParamDateStatistic;
	private List<Float> listParamAqiDateStat;
	// thống kê tháng
	private String selMonth;
	private String typeParamMonthStatistic;
	private List<Float> listParamAqiMonthStat;
	private List<String> colorAQIMonthStat;
	private int countDayInMonth;

	// chart 3
	private String selDate3;
	private List<Integer> listRatePoll;
	// div table
	private List<Record> listRecord;
	private int totalRecord;
	private int totalPage;
	private List<Integer> listPaging;
	private int pageFirstNext;
	private int pageFirstBack;
	private String selDate4;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSelDate4() {
		return selDate4;
	}

	public void setSelDate4(String selDate4) {
		this.selDate4 = selDate4;
	}

	public List<Record> getListRecord() {
		return listRecord;
	}

	public void setListRecord(List<Record> listRecord) {
		this.listRecord = listRecord;
	}

	public List<Integer> getListRatePoll() {
		return listRatePoll;
	}

	public void setListRatePoll(List<Integer> listRatePoll) {
		this.listRatePoll = listRatePoll;
	}

	public int getPageFirstNext() {
		return pageFirstNext;
	}

	public void setPageFirstNext(int pageFirstNext) {
		this.pageFirstNext = pageFirstNext;
	}

	public int getPageFirstBack() {
		return pageFirstBack;
	}

	public void setPageFirstBack(int pageFirstBack) {
		this.pageFirstBack = pageFirstBack;
	}

	public List<Integer> getListPaging() {
		return listPaging;
	}

	public void setListPaging(List<Integer> listPaging) {
		this.listPaging = listPaging;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getSelDate3() {
		return selDate3;
	}

	public void setSelDate3(String selDate3) {
		this.selDate3 = selDate3;
	}

	public int getCountDayInMonth() {
		return countDayInMonth;
	}

	public void setCountDayInMonth(int countDayInMonth) {
		this.countDayInMonth = countDayInMonth;
	}

	public String getTypeParamDateStatistic() {
		return typeParamDateStatistic;
	}

	public void setTypeParamDateStatistic(String typeParamDateStatistic) {
		this.typeParamDateStatistic = typeParamDateStatistic;
	}

	public String getTypeParamMonthStatistic() {
		return typeParamMonthStatistic;
	}

	public void setTypeParamMonthStatistic(String typeParamMonthStatistic) {
		this.typeParamMonthStatistic = typeParamMonthStatistic;
	}

	public List<String> getColorAQIMonthStat() {
		return colorAQIMonthStat;
	}

	public void setColorAQIMonthStat(List<String> colorAQIMonthStat) {
		this.colorAQIMonthStat = colorAQIMonthStat;
	}

	public List<Float> getListParamAqiMonthStat() {
		return listParamAqiMonthStat;
	}

	public void setListParamAqiMonthStat(List<Float> listParamAqiMonthStat) {
		this.listParamAqiMonthStat = listParamAqiMonthStat;
	}

	public String getSelMonth() {
		return selMonth;
	}

	public void setSelMonth(String selMonth) {
		this.selMonth = selMonth;
	}

	public List<String> getColorAQIDateStat() {
		return colorAQIDateStat;
	}

	public void setColorAQIDateStat(List<String> colorAQIDateStat) {
		this.colorAQIDateStat = colorAQIDateStat;
	}

	public List<Float> getListParamAqiDateStat() {
		return listParamAqiDateStat;
	}

	public void setListParamAqiDateStat(List<Float> listParamAqiDateStat) {
		this.listParamAqiDateStat = listParamAqiDateStat;
	}

	public String getSelDate() {
		return selDate;
	}

	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}

	public float getCoAQI() {
		return coAQI;
	}

	public void setCoAQI(float coAQI) {
		this.coAQI = coAQI;
	}

	public float getEthanolAQI() {
		return ethanolAQI;
	}

	public void setEthanolAQI(float ethanolAQI) {
		this.ethanolAQI = ethanolAQI;
	}

	public float getToluenceAQI() {
		return toluenceAQI;
	}

	public void setToluenceAQI(float toluenceAQI) {
		this.toluenceAQI = toluenceAQI;
	}

	public float getAcetoneAQI() {
		return acetoneAQI;
	}

	public void setAcetoneAQI(float acetoneAQI) {
		this.acetoneAQI = acetoneAQI;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
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

	public float getCo() {
		return co;
	}

	public void setCo(float co) {
		this.co = co;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getPinIcon() {
		return pinIcon;
	}

	public void setPinIcon(String pinIcon) {
		this.pinIcon = pinIcon;
	}

	public String getTime_record() {
		return time_record;
	}

	public void setTime_record(String time_record) {
		this.time_record = time_record;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNextStation() {
		return nextStation;
	}

	public void setNextStation(String nextStation) {
		this.nextStation = nextStation;
	}

	public String getPinMap() {
		return pinMap;
	}

	public void setPinMap(String pinMap) {
		this.pinMap = pinMap;
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

	public float getCo2() {
		return co2;
	}

	public void setCo2(float co2) {
		this.co2 = co2;
	}

	@Override
	public String toString() {
		return "DisplayInfo [cabinID=" + cabinID + ", trainID=" + trainID + ", trainName=" + trainName + ", temp="
				+ temp + ", humi=" + humi + ", longitude=" + longitude + ", latitude=" + latitude + ", co=" + co
				+ ", co2=" + co2 + ", ethanol=" + ethanol + ", toluene=" + toluene + ", acetone=" + acetone + ", aqi="
				+ aqi + ", coAQI=" + coAQI + ", ethanolAQI=" + ethanolAQI + ", toluenceAQI=" + toluenceAQI
				+ ", acetoneAQI=" + acetoneAQI + ", title=" + title + ", des=" + des + ", pinIcon=" + pinIcon
				+ ", time_record=" + time_record + ", color=" + color + ", nextStation=" + nextStation + ", pinMap="
				+ pinMap + ", colorAQIDateStat=" + colorAQIDateStat + ", selDate=" + selDate
				+ ", typeParamDateStatistic=" + typeParamDateStatistic + ", listParamAqiDateStat="
				+ listParamAqiDateStat + ", selMonth=" + selMonth + ", typeParamMonthStatistic="
				+ typeParamMonthStatistic + ", listParamAqiMonthStat=" + listParamAqiMonthStat + ", colorAQIMonthStat="
				+ colorAQIMonthStat + ", countDayInMonth=" + countDayInMonth + ", selDate3=" + selDate3
				+ ", listRatePoll=" + listRatePoll + ", listRecord=" + listRecord + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", listPaging=" + listPaging + ", pageFirstNext=" + pageFirstNext
				+ ", pageFirstBack=" + pageFirstBack + ", selDate4=" + selDate4 + ", currentPage=" + currentPage + "]";
	}

}
