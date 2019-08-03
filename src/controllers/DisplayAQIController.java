package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.DisplayInfo;
import entities.Record;
import entities.StatParam;
import entities.TblCabin;
import logics.StatParamLogic;
import logics.TblCabinLogic;
import logics.TblStationLogic;
import logics.TblTrainLogic;
import logics.impl.StatParamLogicImpl;
import logics.impl.TblCabinLogicImpl;
import logics.impl.TblStationLogicImpl;
import logics.impl.TblTrainLogicImpl;
import ultis.Common;
import ultis.ConfigProperties;
import ultis.Constant;
import ultis.MessageProperties;

/**
 * Servlet implementation class DisplayAQIController
 */
@WebServlet("/DisplayAQI.do")
public class DisplayAQIController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TblCabinLogic tblCabinLogicImpl = new TblCabinLogicImpl();
			tblCabinLogicImpl.updateDBFB();

			setDataLogic(request, response);
			// lấy các thông số của cabin và tàu set lên view
			DisplayInfo displayInfo = getDefaultValueAQI(request, response);
			String typeDateStatistic = request.getParameter("typeDateStatistic");
			String typeMonthStatistic = request.getParameter("typeMonthStatistic");

			// set các giá trị lấy được lên view
			request.setAttribute("typeDateStatistic", typeDateStatistic);
			request.setAttribute("typeMonthStatistic", typeMonthStatistic);
			request.setAttribute("displayInfo", displayInfo);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.JSP_AQI);
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect(Constant.URL_SYSTEM_ERROR);
			e.printStackTrace();

		}
	}

	/**
	 * @param request
	 * @param response
	 * @return DisplayInfo
	 * @throws Exception
	 */
	private DisplayInfo getDefaultValueAQI(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DisplayInfo displayInfo = new DisplayInfo();

		HttpSession session = request.getSession();
		String trainName = (String) session.getAttribute(Constant.SESSION_SELECT_TRAIN);
		int cabinID = Integer.parseInt((String) session.getAttribute(Constant.SESSION_SELECT_CABIN));

		// Các giá trị mặc định
		int aqi;
		String nextStation;
		String defaultDate = Common.getYearMonthDayNow();

		// logic
		TblCabinLogic tblCabinLogicImpl = new TblCabinLogicImpl();
		TblTrainLogic tblTrainLogicImpl = new TblTrainLogicImpl();
		TblStationLogic tblStationLogicImpl = new TblStationLogicImpl();

		try {
			int trainID = tblTrainLogicImpl.getTrainIdByName(trainName);
			// lấy ra record mới nhất từ DB
			TblCabin tblCabin = tblCabinLogicImpl.getLastestRecordTblCabinById(cabinID, trainID);

			List<Float> listAQI = Common.calAqi(tblCabin);
			// phương thức tính toán số aqi từ các thông số môi trường
			aqi = Math.round(listAQI.get(listAQI.size() - 1));

			// phương thức lấy so sánh aqi để đưa ra title, description, pinIcon
			List<String> warning = Common.getDescription(aqi);

			// thông số map google

			// Phương thức lấy ra ga sắp tới từ vị trí tọa độ
			nextStation = tblStationLogicImpl.getNextStation(tblCabin.getLongitude(), tblCabin.getLatitude());
			// thống kê ngày
			String selDate = defaultDate;
			String typeDateStat = "aqi";
			String typeDateStatistic = request.getParameter("typeDateStatistic");

			if (typeDateStatistic != null) {
				selDate = request.getParameter("selDate");
				Common.checkFormatDate(selDate);
				typeDateStat = typeDateStatistic;
			}
			// list thông số thống kê 24h ngày đó
			List<Float> listParamAqiDateStat = tblCabinLogicImpl.getParamAqiDateStat(typeDateStat, selDate, trainID,
					cabinID);
			List<String> colorAQIDateStat = Common.getColorAQI(typeDateStat, listParamAqiDateStat);

			// thống kê tháng
			String selMonth = Common.getYearMonthNow();
			String typeMonthStat = "aqi";
			String typeMonthStatistic = request.getParameter("typeMonthStatistic");

			if (typeMonthStatistic != null) {
				selMonth = request.getParameter("selMonth");
				typeMonthStat = typeMonthStatistic;
			}
			int countDayInMonth = Common.countDayOfMonth(selMonth);
			// list thông số thống kê từng ngày của tháng đó
			List<Float> listdParamAqiMonthStat = tblCabinLogicImpl.getParamAqiMonthStat(typeMonthStat, selMonth,
					countDayInMonth, trainID, cabinID);

			List<String> colorAQIMonthStat = Common.getColorAQI(typeMonthStat, listdParamAqiMonthStat);

			// tỷ lệ ô nhiễm: chart3
			String selDate3 = request.getParameter("selDate3");
			if (selDate3 == null) {
				// mặc định
				selDate3 = defaultDate;
			}
			Common.checkFormatDate(selDate3);
			List<Integer> listRatePoll = tblCabinLogicImpl.getListRatePoll(selDate3, trainID, cabinID);

			// thông số div table
			String selDate4 = request.getParameter("selDate4");

			if (selDate4 == null) {
				selDate4 = defaultDate;
			}
			Common.checkFormatDate(selDate4);
			// Khai báo vị trí offset mặc định
			int offSet = Constant.DEFAULT_OFFSET;
			// Khai báo vị trí trang mặc định
			int currentPage = Constant.DEFAULT_CURRENT_PAGE;
			// Xác định số lượng record đc hiển thị trong 1 trang trong properties
			// nếu đọc file bị lỗi mặc định sẽ là 5
			int limit = Common.convertInterger(ConfigProperties.getValue(Constant.LIMIT_RECORD), 5);
			// lấy trang hiện tại trên request
			currentPage = (int) Common.getValueRequest(request, "currentPage", Constant.DEFAULT_CURRENT_PAGE);
			// Tìm vị trí offset để thực hiện việc lấy dữ liệu từ database
			offSet = limit * (currentPage - 1);
			// lấy tông số record theo kết quả tìm được
			int totalRecord = tblCabinLogicImpl.getTotalRecord(selDate4, trainID, cabinID);
			displayInfo.setTotalRecord(totalRecord);
			// Nếu chương trình tìm kiếm được user thì sẽ
			// hiện danh sách và paging
			if (totalRecord > 0) {
				// Lấy list user dựa theo điều kiện tìm kiếm
				List<Record> listRecord = tblCabinLogicImpl.getListRecord(selDate4, offSet, limit, trainID, cabinID);
				// Tìm list Paging
				List<Integer> listPaging = Common.getListPaging(totalRecord, limit, currentPage);
				// lấy giới hạn phân trang trong 1 trang
				int limitPaging = Common.getLimitPaging();
				// tìm trang đầu khi bấm back. Lấy giá trị đầu tiên trong listPaging
				int pageFirstBack = listPaging.get(0) - limitPaging;
				// tìm trang đầu khi bấm next
				int pageFirstNext = listPaging.get(0) + limitPaging;
				// Lấy tổng số page và chuyển sang jsp
				int totalPage = Common.getTotalPaging(totalRecord, limit);

				// Đổi kiểu sort và chuyển qua cho jsp để hiển thị
				displayInfo.setListRecord(listRecord);
				displayInfo.setTotalPage(totalPage);

				displayInfo.setListPaging(listPaging);
				System.out.println("paging: " + listPaging.toString());
				displayInfo.setPageFirstNext(pageFirstNext);
				displayInfo.setPageFirstBack(pageFirstBack);
				// Nếu không tìm thấy record nào thì sẽ hiện câu thông báo không tìm thấy
			} else {
				request.setAttribute("userNotFound", MessageProperties.getValue(Constant.MSG005));
			}
			displayInfo.setNextStation(nextStation);
			displayInfo.setLongitude(tblCabin.getLongitude());
			displayInfo.setLatitude(tblCabin.getLatitude());
			displayInfo.setTime_record(tblCabin.getTimeRecord() + " | " + tblCabin.getDateRecord());
			displayInfo.setAqi(aqi);
//			displayInfo.setCoAQI(Math.round(listAQI.get(0)));
//			displayInfo.setNo2AQI(Math.round(listAQI.get(1)));
//			displayInfo.setSo2AQI(Math.round(listAQI.get(2)));
//			displayInfo.setO3AQI(Math.round(listAQI.get(3)));
//			displayInfo.setPm25AQI(Math.round(listAQI.get(4)));
//			displayInfo.setPm10AQI(Math.round(listAQI.get(5)));

			displayInfo.setCo(tblCabin.getCo());
			displayInfo.setCo2(tblCabin.getCo2());
//			displayInfo.setSo2(tblCabin.getSo2());
//			displayInfo.setPm10(tblCabin.getPm10());
//			displayInfo.setPm25(tblCabin.getPm25());
//			displayInfo.setO3(tblCabin.getO3());
//			displayInfo.setNo2(tblCabin.getNo2());
			displayInfo.setAcetone(tblCabin.getAcetone());
			displayInfo.setToluene(tblCabin.getToluene());
			displayInfo.setEthanol(tblCabin.getEthanol());
			displayInfo.setTemp(tblCabin.getTemp());
			displayInfo.setHumi(tblCabin.getHumi());

			displayInfo.setTitle(warning.get(0));
			displayInfo.setDes(warning.get(1));
			displayInfo.setPinIcon(warning.get(2));
			displayInfo.setColor(warning.get(3));
			displayInfo.setColorAQIDateStat(colorAQIDateStat);

			// giá trị tên tàu và số hiệu khoang được nhập vào ở trang đầu tiên
			displayInfo.setTrainName(trainName);
			displayInfo.setCabinID(cabinID);
			// thống kê ngày
			displayInfo.setSelDate(selDate);
			displayInfo.setListParamAqiDateStat(listParamAqiDateStat);
			// thống kê tháng
			displayInfo.setSelMonth(selMonth);
			displayInfo.setListParamAqiMonthStat(listdParamAqiMonthStat);
			displayInfo.setColorAQIMonthStat(colorAQIMonthStat);
			displayInfo.setCountDayInMonth(countDayInMonth);

			// tỷ lệ ô nhiễm
			displayInfo.setSelDate3(selDate3);
			displayInfo.setListRatePoll(listRatePoll);
			// div Table
			displayInfo.setSelDate4(selDate4);
			displayInfo.setCurrentPage(currentPage);
			System.out.println(displayInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return displayInfo;
	}

	/**
	 * Phương thức set các giá trị mặc định hiển thị màn hình AQI
	 * 
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void setDataLogic(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		StatParamLogic statParamLogicImpl = new StatParamLogicImpl();
		List<StatParam> liStatParams = statParamLogicImpl.getStatParam();
		request.setAttribute("liStatParams", liStatParams);

	}
}
