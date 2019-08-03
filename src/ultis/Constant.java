
package ultis;

/**
 * Class Constant Chứa các constant của dự án
 */
public class Constant {
	// Khai báo giá trị quyền admin
	public static final int ADMIN = 0;
	// Khai báo giá trị quyền user
	public static final int USER = 1;

	// Khai bao kiểu sắp xếp
	public static final String ASC = "ASC";
	public static final String DESC = "DESC";

	// Khai báo paging mặc định
	public static final int CURRENT_PAGE_DEFAULT = 1;

	// Khai báo giá trị key của file config properties
	public static final String LIMIT_PAGING = "limitpaging";
	public static final String LIMIT_RECORD = "limitrecord";

	// Khai báo kiểu mã hóa
	public static final String HASH_CODE = "SHA1";

	// Khai báo lỗi
	public static final String ER001_TRAIN_NAME = "ER001_TRAIN_NAME";
	public static final String ER001_CABINID = "ER001_CABINID";
	public static final String ER016 = "ER016";
	public static final String ER019_CABINID = "ER019_CABINID";

	// Khai báo url servlet
	public static final String URL_SYSTEM_ERROR = "systemerror";
	public static final String URL_LOGOUT = "logout.do";
	public static final String URL_LOGIN = "login.do";
	public static final String SUCCESS = "success.do";
//	public static final String ADD_USER_INPUT = "adduserinput.do";
	// Khai báo tên của các jsp
	public static final String JSP_SELECTTRAINCABIN = "view/jsp/SelectTrainCabin.jsp";
	public static final String JSP_AQI = "view/jsp/AQI.jsp";
	public static final String JSP_SYSTEM_ERROR = "view/jsp/SystemError.jsp";
	public static final String JSP_SUCCESS = "view/jsp/Success.jsp";
	public static final String JSP_INFORMATION = "view/jsp/Information.jsp";

	// Khai báo kiểu chức năng trên màn hình ADM002
	public static final String TYPE_SORT = "sort";
	public static final String TYPE_PAGING = "paging";
	public static final String TYPE_SEARCH = "search";
	public static final String TYPE_BACK = "back";

	// Khai báo id của group để thực hiện chức năng tìm kiếm all
	public static final int ID_GROUP_FIND_ALL = 0;

	// khai báo các điều kiện mặc định của ListUserController
	public static final String DEFAULT_SORT_FULLNAME = "ASC";
	public static final String DEFAULT_SORT_CODE_LEVEL = "ASC";
	public static final String DEFAULT_SORT_END_DATE = "DESC";
	public static final int DEFAULT_OFFSET = 0;
	public static final String DEFAULT_FULLNAME = "";
	public static final int DEFAULT_GROUP_ID = 0;
	public static final String DEFAULT_SORT_TYPE = "sortFullName";
	public static final int DEFAULT_CURRENT_PAGE = 1;

	// Khai báo session cho ListUserController
	public static final String SESSION_SELECT_TRAIN = "session_select_train";
	public static final String SESSION_SELECT_CABIN = "session_select_cabin";
	public static final String SESSION_FULLNAME = "session_fullName";
	public static final String SESSION_GROUP_ID = "session_groupID";
	public static final String SESSION_SORT_TYPE = "session_sortType";
	public static final String SESSION_SORT_VALUE = "session_sortValue";
	public static final String SESSION_SORT_FULLNAME = "session_sort_fullName";
	public static final String SESSION_SORT_CODE_LEVEL = "session_sort_codeLevel";
	public static final String SESSION_SORT_END_DATE = "session_sort_endDate";
	public static final String SESSION_CURRENT_PAGE = "session_currentPage";

	// type sort
	public static final String TYPE_SORT_FULLNAME = "sortFullName";
	public static final String TYPE_SORT_CODE_LEVEL = "sortCodeLevel";
	public static final String TYPE_SORT_END_DATE = "sortEndDate";

	// khai báo thuộc tính tên cột trong bảng tbl_cabin
	public static final String TBL_CABIN = "tbl_cabin";
	public static final String TBL_CABIN_CABIN_ID = "tbl_cabin.cabin_id";
	public static final String TBL_CABIN_TRAIN_ID = "tbl_cabin.train_id";
	public static final String TBL_CABIN_TEMP = "tbl_cabin.temp";
	public static final String TBL_CABIN_HUMI = "tbl_cabin.humi";
	public static final String TBL_CABIN_PRESSURE = "tbl_cabin.pressure";
	public static final String TBL_CABIN_CO = "tbl_cabin.co";
	public static final String TBL_CABIN_CO2 = "tbl_cabin.co2";
	public static final String TBL_CABIN_ETHANOL = "tbl_cabin.ethanol";
	public static final String TBL_CABIN_TOLUENE = "tbl_cabin.toluene";
	public static final String TBL_CABIN_ACETONE = "tbl_cabin.acetone";
	public static final String TBL_CABIN_LONGITUDE = "tbl_cabin.longitude";
	public static final String TBL_CABIN_LATITUDE = "tbl_cabin.latitude";
	public static final String TBL_CABIN_TIME_RECORD = "tbl_cabin.time_record";
	public static final String TBL_CABIN_RECORD_ID = "tbl_cabin.record_id";

	// khai báo thuộc tính tên cột trong bảng tbl_train
	public static final String TBL_TRAIN = "tbl_train";
	public static final String TBL_TRAIN_ID = "tbl_train.train_id";
	public static final String TBL_TRAIN_NAME = "tbl_train.train_name";

	// khai báo thuộc tính tên cột trong bảng tbl_station
	public static final String TBL_STATION = "tbl_station";
	public static final String TBL_STATION_ID = "tbl_station.station_id";
	public static final String TBL_STATION_NAME = "tbl_station.station_name";

	// khai báo thuộc tính tên cột trong bảng tbl_trip
	public static final String TBL_TRIP = "tbl_trip";
	public static final String TBL_TRIP_TRIP_ID = "tbl_trip.trip_id";
	public static final String TBL_TRIP_TRIP_NAME = "tbl_trip.trip_name";
	public static final String TBL_TRIP_TRAIN_ID = "tbl_trip.train_id";
	public static final String TBL_TRIP_START_DATE_TIME = "tbl_trip.start_date_time";
	public static final String TBL_TRIP_END_DATE_TIME = "tbl_trip.end_date_time";
	public static final String TBL_TRIP_ROUTE_ID = "tbl_trip.route_id";

	// Khai bao thuộc tinh tên các cột trong tbl_user
	public static final String TBL_USER = "tbl_user";
	public static final String TBL_USER_GROUP_ID = "tbl_user.group_id";
	public static final String TBL_USER_LOGIN_NAME = "tbl_user.login_name";
	public static final String TBL_USER_RULE = "tbl_user.rule";
	public static final String TBL_USER_PASS = "tbl_user.pass";
	public static final String TBL_USER_SALT = "tbl_user.salt";
	public static final String TBL_USER_USER_ID = "tbl_user.user_id";
	public static final String TBL_USER_FULLNAME = "tbl_user.full_name";
	public static final String TBL_USER_FULLNAME_KANA = "tbl_user.full_name_kana";
	public static final String TBL_USER_BIRTHDAY = "tbl_user.birthday";
	public static final String TBL_USER_EMAIL = "tbl_user.email";
	public static final String TBL_USER_TEL = "tbl_user.tel";
	
	
	// Khai bao thuộc tinh tên các cột trong stat_param
	public static final String TBL_STAT_PARAM = "stat_param";

	// Khai báo các câu thông báo trong chương trình
	public static final String MSG001 = "MSG001";
	public static final String MSG002 = "MSG002";
	public static final String MSG003 = "MSG003";
	public static final String MSG004 = "MSG004";
	public static final String MSG005 = "MSG005";
	public static final String MSG006 = "MSG006";

	public static final String SYSTEM_ERROR = "error";
	public static final String INSERT_SUCCESS = "insertsuccess";
	public static final String EDIT_SUCCESS = "editsuccess";
	public static final String DELETE_SUCCESS = "deletesuccess";
	public static final String CHANGE_PASSWORD_SUCCESS = "changepasswordsuccess";
	public static final String MESSAGE = "message";
	public static final String STR_KEY_FLAG = "key_flag";
	public static final String ICON_DETAIL_GREEN = "view/asset/img/icon_detail_green.png";
	public static final String ICON_DETAIL_YELLOW = "view/asset/img/icon_detail_yellow.png";
	public static final String ICON_DETAIL_ORANGE = "view/asset/img/icon_detail_orange.png";
	public static final String ICON_DETAIL_RED = "view/asset/img/icon_detail_red.png";
	public static final String ICON_DETAIL_BROWN = "view/asset/img/icon_detail_brown.png";
	
	

}
