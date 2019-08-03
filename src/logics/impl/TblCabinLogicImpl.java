/**
 * 
 */
package logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TblCabinDao;
import dao.TblTrainDao;
import dao.impl.BaseDaoImpl;
import dao.impl.TblCabinDaoImpl;
import dao.impl.TblTrainDaoImpl;
import entities.Record;
import entities.TblCabin;
import logics.TblCabinLogic;

/**
 * @author phanthanhtrung
 *
 */
public class TblCabinLogicImpl extends BaseDaoImpl implements TblCabinLogic {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getAllTblCabin(int)
	 */
	@Override
	public List<TblCabin> getAllTblCabin(int trainId) throws ClassNotFoundException, SQLException {
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		TblTrainDao tblTrainDaoImpl = new TblTrainDaoImpl();

		// lấy ra danh sách cabin
		List<TblCabin> listCabin = new ArrayList<TblCabin>();

		// kiểm tra train có tồn tại trong DB không
		boolean checkExist = tblTrainDaoImpl.checkExistTrainById(trainId);
		if (checkExist) {
			// nếu tồn tại train thì lấy ra tất cả cabin có trong DB
			listCabin = tblCabinDaoImpl.getAllTblCabin(trainId);
		}

		return listCabin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getTblCabinById(int)
	 */
	@Override
	public TblCabin getLastestRecordTblCabinById(int cabinId, int trainId) throws ClassNotFoundException, SQLException {
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		TblCabin tblCabin = null;
		// kiểm tra cabin có tồn tại trong DB không
		boolean checkExist = tblCabinDaoImpl.checkExistCabinById(cabinId, trainId);
		if (checkExist) {
			tblCabin = tblCabinDaoImpl.getLastestRecordTblCabinById(cabinId, trainId);
		}
		return tblCabin;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#checkExistCabin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkExistCabin(String trainName, int cabinId) throws SQLException, ClassNotFoundException {
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		return tblCabinDaoImpl.checkExistCabin(trainName, cabinId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getParamAqiDateStat(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public List<Float> getParamAqiDateStat(String typeStat, String selDate, int trainID, int cabinID)
			throws ClassNotFoundException, SQLException {

		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		// phương thức lấy ra danh sách các giá trị trung bình AQI có trong 24h
		// của ngày đó
		List<Float> listdParamAqiDateStat = new ArrayList<Float>();
		// Xét 1 ngày có 24h từ 0h00 đến 23h59
		for (int i = 0; i <= 23; i++) {
			String dateStat = selDate + " " + i;
			// list lưu danh sách các giá trị AQI có trong 1h
			List<Float> listParamInDate;
			if (!"aqi".equals(typeStat)) {
				// phương thức lấy ra danh sách các giá trị AQI không phải là aqi có trong 1h
				listParamInDate = tblCabinDaoImpl.getParamAqiDateStat(typeStat, dateStat, trainID, cabinID);
			} else {
				listParamInDate = tblCabinDaoImpl.getAqiSumDateStat(dateStat, trainID, cabinID);
			}
			// tổng giá trị các bản ghi có trong 1h
			float tong = 0;
			// số bản ghi có trong 1h
			int div = listParamInDate.size();
			// giá trị trung bình trong 1h
			float avg = 0;
			// tính tổng các giá trị có trong 1h
			for (int j = 0; j < div; j++) {
				tong = tong + listParamInDate.get(j);
			}
			// nếu không có bản ghi nào trong khoảng thời gian đó
			if (div > 0) {
				avg = tong / listParamInDate.size();
			}
			// add các giá trị trung bình tính được vào list
			listdParamAqiDateStat.add(avg);
		}
		return listdParamAqiDateStat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getParamAqiMonthStat(java.lang.String,
	 * java.lang.String, int, int)
	 */
	@Override
	public List<Float> getParamAqiMonthStat(String typeMonthStat, String selMonth, int countDayInMonth, int trainID,
			int cabinID) throws ClassNotFoundException, SQLException {
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		// phương thức lấy ra danh sách các giá trị trung bình AQI có trong 24h
		// của ngày đó
		List<Float> listdParamAqiMonthStat = new ArrayList<Float>();
		// list lưu danh sách các giá trị AQI có trong 1h
		if (!"aqi".equals(typeMonthStat)) {
			// phương thức lấy ra danh sách các giá trị AQI không phải là aqi có trong 1h
			listdParamAqiMonthStat = tblCabinDaoImpl.getParamAqiMonthStat(typeMonthStat, selMonth, countDayInMonth,
					trainID, cabinID);
		} else {
			listdParamAqiMonthStat = tblCabinDaoImpl.getAqiSumMonthStat(selMonth, countDayInMonth, trainID, cabinID);
		}

		return listdParamAqiMonthStat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getTotalRecord(int, int)
	 */
	@Override
	public int getTotalRecord(String selDate4, int trainID, int cabinID) throws ClassNotFoundException, SQLException {
		// Khởi tạo tham số trả về số lượng tìm kiếm mặc định là -1
		int result = -1;
		// Khởi tạo đối tượng
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();

		// Lấy danh sách record dựa theo ngày tìm kiếm
		result = tblCabinDaoImpl.getTotalRecord(selDate4, trainID, cabinID);
		// Trả về số lượng tìm kiếm
		// result = 0 là k tìm thấy
		// result = -1 là có lỗi xảy ra
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getListRecord(int, int, int, int)
	 */
	@Override
	public List<Record> getListRecord(String selDate4, int offSet, int limit, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		// Khởi tạo đối tượng
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		// Khởi tạo danh sách trả về
		List<Record> listRecord = tblCabinDaoImpl.getListRecord(selDate4, offSet, limit, trainID, cabinID);
		// trả về danh sách tìm kiếm
		return listRecord;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#getListRatePoll(java.lang.String, int, int)
	 */
	@Override
	public List<Integer> getListRatePoll(String selDate3, int trainID, int cabinID)
			throws ClassNotFoundException, SQLException {
		// Khởi tạo đối tượng tblUserDao kết nối tới database
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		// Khởi tạo danh sách trả về
		List<Integer> listRatePoll = tblCabinDaoImpl.getListRatePoll(selDate3, trainID, cabinID);
		// trả về danh sách tìm kiếm
		return listRatePoll;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblCabinLogic#updateDBFB()
	 */
	@Override
	public void updateDBFB() {
		TblCabinDao tblCabinDaoImpl = new TblCabinDaoImpl();
		boolean checkUpdate = tblCabinDaoImpl.checkUpdate();

	}

}
