/**
 * 
 */
package logics;

import java.sql.SQLException;
import java.util.List;

import entities.Record;
import entities.TblCabin;

/**
 * @author phanthanhtrung
 *
 */
public interface TblCabinLogic {

	/**
	 * @param cabinId
	 * @param trainId
	 * @return z
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	TblCabin getLastestRecordTblCabinById(int cabinId, int trainId) throws ClassNotFoundException, SQLException;

	/**
	 * @param trainId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<TblCabin> getAllTblCabin(int trainId) throws ClassNotFoundException, SQLException;

	/**
	 * @param trainId
	 * @param i
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	boolean checkExistCabin(String trainName, int cabinId) throws SQLException, ClassNotFoundException;

	/**
	 * @param typeStat loại thống kê : aqi, humi, press, co ,..
	 * @param          selDate: ngày thống kê
	 * @param cabinID  : khoang hiện tại
	 * @param trainID  : tàu hiện tại
	 * @return list số liệu trung bình từng giờ trong ngày đó List<Float>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<Float> getParamAqiDateStat(String typeStat, String selDate, int trainID, int cabinID)
			throws ClassNotFoundException, SQLException;

	/**
	 * @param typeMonthStat
	 * @param selMonth
	 * @param trainID
	 * @param cabinID
	 * @return List<Float>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<Float> getParamAqiMonthStat(String typeMonthStat, String selMonth, int countDayInMonth, int trainID,
			int cabinID) throws ClassNotFoundException, SQLException;

	/**
	 * @param trainID
	 * @param cabinID
	 * @return int
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int getTotalRecord(String selDate4, int trainID, int cabinID) throws ClassNotFoundException, SQLException;

	/**
	 * @param offSet
	 * @param limit
	 * @param trainID
	 * @param cabinID
	 * @return List<Record>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Record> getListRecord(String selDate4, int offSet, int limit, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException;

	/**
	 * @param selDate3
	 * @param trainID
	 * @param cabinID
	 * @return List<Integer>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<Integer> getListRatePoll(String selDate3, int trainID, int cabinID)
			throws ClassNotFoundException, SQLException;

	/**
	 * 
	 * void
	 */
	void updateDBFB();

}
