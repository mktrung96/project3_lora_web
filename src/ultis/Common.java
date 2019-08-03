
package ultis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entities.TblCabin;

/**
 * Class Common Chứa các hàm common của dự án
 * 
 * 
 */
public class Common {

	/**
	 * <b>Phương thức thay thế kí tự "%" và "_"<br>
	 * tránh kí tự wilcard không để xảy ra lỗi Sql injection</b>
	 * 
	 * @param value
	 * @return
	 */
	public static String replaceWilcard(String value) {
		value = value.replace("%", "\\%");
		value = value.replace("_", "\\_");
		return value;
	}

	/**
	 * Phương thức tạo chuỗi paging
	 *
	 * @param totalUser
	 * @param limitUser
	 * @param currentPage
	 * @return
	 */
	public static ArrayList<Integer> getListPaging(int totalUser, int limitUser, int currentPage) {
		// Khởi tạo danh sách cần trả về
		ArrayList<Integer> listPaging = new ArrayList<>();
		// tính tổng số trang dựa trên thương của totalUser và limitUser
		// ta làm tròn cận trên
		int totalPaging = getTotalPaging(totalUser, limitUser);
		// Lấy số paging giới hạn được hiển thị trên 1 trang trong properties
		// và chuyển sang giá trị int
		int limitPaging = getLimitPaging();
		// Kiểm tra số lượng Paging max > 0
		if (limitPaging > 0) {
			// Kiểm tra trang hiện tại có đúng điều kiện hay k
			if (totalPaging >= currentPage) {
				// Tìm paging đầu tiên dựa vào limitPaging và currentPage (trang hiện tại)
				int firstPaging = findFirstPaging(currentPage, limitPaging);
				// để xác định vị trí tiệm cận cuối cùng của Paging
				int asymLatePaging = 0;
				// tính paging max
				int maxPaging = firstPaging + limitPaging - 1;
				// nếu maxPaging < totalPaging
				if (maxPaging < totalPaging) {
					asymLatePaging = maxPaging;
					// ngược lại nếu maxPaging >= totalPaging
				} else {
					asymLatePaging = totalPaging;
				}
				// add vào listPaging và trả về
				for (int i = firstPaging; i <= asymLatePaging; i++) {
					listPaging.add(i);
				}
				// trả về kết quả tìm được
				return listPaging;
			}
		}
		// Nếu không tìm được trả về null
		return null;
	}

	/**
	 * Phương thức lấy giới hạn trang hiển thị
	 *
	 * @return
	 */
	public static int getLimitPaging() {
		// lấy dữ liệu từ file config
		String limitPage = ConfigProperties.getValue(Constant.LIMIT_PAGING);
		// chuyển sang kiểu dữ liệu int nếu bị lỗi thì đặt mặc định là 3
		return convertInterger(limitPage, 3);
	}

	/**
	 * Phương thức tìm tổng số paging
	 *
	 * @param totalUser
	 * @param limitUser
	 * @return
	 */
	public static int getTotalPaging(int totalUser, int limitUser) {
		// chia 2 số làm tròn cận trên và trả về kết quả
		return roundDivision(totalUser, limitUser);
	}

	/**
	 * Phương thức tìm trang đầu của Paging
	 *
	 * @param currentPage
	 * @param limitPaging
	 * @return trả về trang đầu luôn > 0
	 */
	public static int findFirstPaging(int currentPage, int limitPaging) {
		// khai bao trang đầu tiên
		int firstPaging = 0;
		// tìm vị trí phân ô của paging
		// qua phép làm tròn cận trên thương của 2 số currentPage và limitPaging
		int localPaging = roundDivision(currentPage, limitPaging);
		firstPaging = (localPaging - 1) * limitPaging + 1;
		if (firstPaging == 0) {
			firstPaging++;
		}
		// trả về kết quả luôn > 0
		return firstPaging;
	}

	/**
	 * Phương thức thực hiện phép chia và làm tròn cận trên
	 *
	 * @param divisor  <b>: int </b> số bị chia
	 * @param dividend <b>: int </b> số chia
	 * @return <b>: int </b> kết quả
	 */
	private static int roundDivision(int divisor, int dividend) {
		// Khai báo kết quả
		int result = 0;
		if (dividend > 0) {
			// tinh tông số trang dựa trên totalUser và limit
			// Kiểu dữ liệu int 4 byte float 4 byte
			result = (int) Math.ceil((float) divisor / dividend);
		}
		// Nếu dividend <= 0 thì return 0
		// Trả về kết quả
		return result;
	}

	/**
	 * 
	 * Phương thức chuyển đối kiểu dữ liệu từ String sang kiểu dữ liệu int
	 * 
	 * @param value  <b>: String</> giá trị cần chuyển đổi
	 * @param desire <b> int </b> Mong muốn của người dùng trả về kết quả<br>
	 *               khi value = null
	 * 
	 * @return <b> int </b> trả về kiểu dữ liệu int
	 * @throws NumberFormatException
	 */
	public static int convertInterger(String value, int desire) {
		// Khai báo kết quả trả về
		int result = desire;
		// Kiểm tra chuỗi có phải là số hay không
		if (checkNumber(value)) {
			// chuyển sang kiểu dữ liệu int
			result = Integer.parseInt(value);
		}
		// trả về kết quả
		return result;
	}

	/**
	 * Phương thức validate kiểm tra id có phải là số nguyên dương hay không
	 * 
	 * @param value giá trị id
	 * @return Boolean trả về true nếu chuỗi là số, false chuỗi đó không phải là số
	 */
	private static boolean checkNumber(String value) {
		// Biểu thức chính quy kiểm tra số nguyên dương
		String regex = "[0-9]+";
		// trả về kết quả kiểm tra
		return value.matches(regex);
	}

	/**
	 * Lấy giá trị từ session nếu giá trị bằng null thì lấy theo mặc định
	 * 
	 * @param session      Object cần chuyển đổi
	 * @param key          String Key của session cần lấy giá trị
	 * @param defaultValue Giá trị mặc định
	 * @return Object Giá trị cần lấy
	 */
	public static Object getValueSession(HttpSession session, String key, Object defaultValue) {
		// Lấy dữ liệu từ sesion
		Object result = session.getAttribute(key);
		// kiểm tra object truyền vào có phải là request thì thực hiện lấy dữ liệu
		return (result != null) ? result : defaultValue;
	}

	/**
	 * Lấy giá trị từ request nếu giá trị bằng null thì lấy theo mặc định
	 *
	 * @param request
	 * @param key
	 * @param defaultValue
	 * @return kết quả cần tìm
	 */
	public static Object getValueRequest(HttpServletRequest request, String key, Object defaultValue) {
		// lấy dữ liệu từ request
		String param = request.getParameter(key);
		// nếu param khác rỗng thì
		if (param != null) {
			// kiểm tra defaultValue truyền vào là kiểu dữ liệu Integer thì
			if (defaultValue instanceof Integer) {
				// kiểm tra param có phải là số thì thực hiện chuyển đổi sang int
				if (checkNumber(param)) {
					// trả về kết quả sau khi đã chuyển sang kiểu dữ liệu int
					return Integer.parseInt(param);
				}
				// nếu kiểu truyền vào defaultValue là kiểu dữ liệu string thì
			} else if (defaultValue instanceof String) {
				// trả về kết quả đã lấy
				return param;
			}
		}
		// trả về kết quả mặc định
		return defaultValue;
	}

	/**
	 * Hàm parseInt từ String sang Integer
	 * 
	 * @param str chuỗi string cần parserInt
	 * @return Trả về số nếu chuỗi là số trả về -1 nếu chuỗi ko phải là số
	 */

	public static int parseInt(String str) {
		int temp = 0;
		try {
			temp = Integer.parseInt(str);
		} catch (Exception e) {
			temp = 0;
		}
		return temp;
	}

	/**
	 * Lấy năm bắt đầu từ file config.properties
	 * 
	 * @return
	 */

	public static int getStartYear() {
		int startYear = Common.parseInt(ConfigProperties.getValue("startYear"));
		return startYear;
	}

	/**
	 * Kiểm tra ngày có hợp lệ
	 * 
	 * @param arrDate
	 * @return true nếu hợp lệ
	 */
	public static boolean checkFormatDate(String date) throws NumberFormatException {
		String[] arrDate = date.split("-");
		try {
			if (arrDate.length == 3) {
				int year = Integer.parseInt(arrDate[0]);
				int month = Integer.parseInt(arrDate[1]);
				int day = Integer.parseInt(arrDate[2]);
				boolean check = true;
				switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (day < 1 || day > 31) {
						check = false;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (day < 1 || day > 30) {
						check = false;
					}
					break;
				case 2:
					// Nếu là năm nhuận
					if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
						if (day < 1 || day > 29) {
							check = false;
						}
					}
					// nếu không phải là năm nhuận
					else {
						if (day < 1 || day > 28) {
							check = false;
						}
					}
					break;
				default:
					check = false;
				}
				return check;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		return false;

	}

	/**
	 * Kiểm tra month có hợp lệ
	 * 
	 * @param arrDate
	 * @return true nếu hợp lệ
	 */
	public static boolean checkFormatMonth(String date) throws NumberFormatException {
		String[] arrDate = date.split("-");
		try {
			if (arrDate.length == 2) {
				Integer.parseInt(arrDate[0]);
				int month = Integer.parseInt(arrDate[1]);
				if (month < 1 || month > 12) {
					return false;
				}
				return true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

		return false;

	}

	/**
	 * Phương thức lấy giá trị ngày tháng năm hiện tại
	 * 
	 * @return List<Integer> arrDate
	 */
	public static List<Integer> getArrYearMonthDayNow() {
		List<Integer> arrDate = new ArrayList<Integer>();
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH) + 1; // vì hàm trả về giá trị từ 0 - 11
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		arrDate.add(nowYear);
		arrDate.add(nowMonth);
		arrDate.add(nowDay);
		return arrDate;
	}

	/**
	 * Hàm lấy key ngẫu nhiên theo thời gian hiện tại
	 * 
	 * @return keySession
	 */
	public static String getKey() {
		String keySession = System.currentTimeMillis() + "";
		return keySession;
	}

	/**
	 * Phương thức tính toán chỉ số AQI từ các thông số đo được từ môi trường Thông
	 * số nào có giá trị lớn nhất sẽ là thông số aqi
	 * 
	 * @param tblCabin
	 * @return int AQI
	 */
	public static List<Float> calAqi(TblCabin tblCabin) {
		List<Float> listAQI = new ArrayList<Float>();
		float klco  = ((tblCabin.getCo())*28)*1000/(float)(24.45);
		float coAQI = (klco / 30000) * 100;
//		float co2AQI = (tblCabin.getCo() / 30000) * 100;
//		float ethanolAQI = (tblCabin.getEthanol() / 30000) * 100;
//		float tolueneAQI = (tblCabin.getToluene() / 30000) * 100;
//		float acetone = (tblCabin.getAcetone() / 30000) * 100;
//		float no2AQI = (tblCabin.getNo2() / 200) * 100;
//		float so2AQI = (tblCabin.getSo2() / 350) * 100;
//		float o3AQI = (tblCabin.getO3() / 180) * 100;
//		float pm25AQI = ((tblCabin.getPm25()) / 50) * 100;
//		float pm10AQI = (tblCabin.getPm10() / 300) * 100;
		listAQI.add(coAQI);
//		listAQI.add(no2AQI);
//		listAQI.add(so2AQI);
//		listAQI.add(o3AQI);
//		listAQI.add(pm25AQI);
//		listAQI.add(pm10AQI);
//		listAQI.add(ethanolAQI);
//		listAQI.add(tolueneAQI);
//		listAQI.add(acetone);
//		listAQI.add(co2AQI);
		float aqi = listAQI.get(0);
		for (int i = 0; i < listAQI.size(); i++) {
			if (listAQI.get(i) > aqi) {
				aqi = listAQI.get(i);
			}
		}
		listAQI.add(aqi);

		return listAQI;
	}

	/*
	 * Phương thức đưa ra cảnh báo cho người dùng khi biết aqi
	 * 
	 * @return List<String>
	 */
	public static List<String> getDescription(int data) {
		String title = null, des = null, pinIcon = null, color = null, colorAQI = null;
		List<String> warning = new ArrayList<String>();
		if (data <= 50) {
			title = "Tốt";
			des = "Chất lượng không khí tốt.";
			pinIcon = Constant.ICON_DETAIL_GREEN;
			color = "green";
			colorAQI = "#00e400";
		}
		if (data > 50 && data <= 100) {
			title = "Trung bình";
			des = "Nhóm nhạy cảm nên hạn chế ở bên ngoài.";
			pinIcon = Constant.ICON_DETAIL_YELLOW;
			color = "yellow";
			colorAQI = "#ffff02";
		}
		if (data > 100 && data <= 200) {
			title = "Kém";
			des = "Nhóm nhạy cảm cần hạn chế thời gian ở bên ngoài.";
			pinIcon = Constant.ICON_DETAIL_ORANGE;
			color = "orange";
			colorAQI = "#ff7e00";
		}
		if (data > 200 && data <= 300) {
			title = "Xấu";
			des = "Nhóm nhạy cảm tránh ra ngoài. Những người khác hạn chế ở bên ngoài.";
			pinIcon = Constant.ICON_DETAIL_RED;
			color = "red";
			colorAQI = "#ff0000";
		}
		if (data > 300) {
			title = "Nguy hiểm";
			des = "Mọi người nên ở trong nhà.";
			pinIcon = Constant.ICON_DETAIL_BROWN;
			color = "brown";
			colorAQI = "#7f0023";
		}
		warning.add(title);
		warning.add(des);
		warning.add(pinIcon);
		warning.add(color);
		warning.add(colorAQI);
		return warning;
	}

	/**
	 * @return String
	 */
	public static String getYearMonthDayNow() {
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH) + 1; // vì hàm trả về giá trị từ 0 - 11
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		String str = nowYear + "-" + nowMonth + "-" + nowDay;
		return str;
	}

	/**
	 * @param typeStat
	 * @param listdParamAqiDateStat
	 * @return List<String>
	 */
	public static List<String> getColorAQI(String typeStat, List<Float> listdParamAqi) {
		List<String> lisColorAQI = new ArrayList<String>();
		System.out.println("getColorAQI type: " + typeStat);
		if ("temp".equals(typeStat) || "humi".equals(typeStat) || "co2".equals(typeStat)|| "ethanol".equals(typeStat) || "acetone".equals(typeStat)|| "toluene".equals(typeStat) || "co".equals(typeStat)) {
			for (int i = 0; i < listdParamAqi.size(); i++) {
				lisColorAQI.add("#bdbdbd");
				System.out.println("#bdbdbd");
			}
		} else {
			for (int i = 0; i < listdParamAqi.size(); i++) {
				float data = listdParamAqi.get(i);
				if (data <= 50) {
					lisColorAQI.add("#00e400");
				}
				if (data > 50 && data <= 100) {
					lisColorAQI.add("#ffff02");
				}
				if (data > 100 && data <= 200) {
					lisColorAQI.add("#ff7e00");
				}
				if (data > 200 && data <= 300) {
					lisColorAQI.add("#ff0000");
				}
			}
		}
		System.out.println("lisColorAQI: " + lisColorAQI.toString());
		return lisColorAQI;
	}

	/**
	 * @return String
	 */
	public static String getYearMonthNow() {
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH) + 1; // vì hàm trả về giá trị từ 0 - 11
		String str = nowYear + "-" + nowMonth;
		return str;
	}

	/**
	 * Phương thức đếm số ngày của tháng
	 * 
	 * @param selMonth
	 * @return int
	 */
	public static int countDayOfMonth(String selMonth) {
		String[] arr = selMonth.split("-");
		int year;
		int month;
		int day = 0;
		try {
			year = Integer.parseInt(arr[0]);
			month = Integer.parseInt(arr[1]);
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			case 2:
				// Nếu là năm nhuận
				if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
					day = 29;
				}
				// nếu không phải là năm nhuận
				else {
					day = 28;
				}
				break;
			default:
			}
		} catch (

		Exception e) {
			// TODO: handle exception
		}
		return day;
	}

//	/**
//	 * 
//	 * void
//	 */
//	public static void SynchWithFB() {
//		FileInputStream serviceAccount;
//		DatabaseReference databaseReference;
//		FirebaseDatabase firebaseDatabase;
//		try {
//			serviceAccount = new FileInputStream(
//					"/C:\\Users\\WIN 10\\eclipse-workspace\\project3_lora_web\\src\\loraweb-f2524-firebase-adminsdk-77gsg-21f76f64bd.json");
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					.setDatabaseUrl("https://loraweb-f2524.firebaseio.com/").build();
//
//			// Khởi tạo phiên bản {@link FirebaseApp} mặc định bằng các tùy chọn đã cho.
//			FirebaseApp.initializeApp(options);
//			firebaseDatabase = FirebaseDatabase.getInstance();
//
//			/* Get database root reference */
//			databaseReference = firebaseDatabase.getReference().child("TblTrain");
//			// System.out.println(databaseReference);
//			System.out.println("databaseReference: " + databaseReference);
//			databaseReference.addValueEventListener(new ValueEventListener() {
//				@Override
//				public void onDataChange(DataSnapshot dataSnapshot) {
//					System.out.println("đã vào");
////					for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//
//					TblTrain tblTrain = dataSnapshot.getValue(TblTrain.class);
//					System.out.println("id: " + tblTrain.getTrainId() + ", name " + tblTrain.getTrainName());
////					lisTblTrain.add(tblTrain);
////					
//
//					// }
//
//				}
//
//				@Override
//				public void onCancelled(DatabaseError error) {
//					System.out.println(error.toException());
//
//				}
//			});
//		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}
