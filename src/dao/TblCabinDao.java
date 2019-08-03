/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Record;
import entities.TblCabin;

/**
 * @author phanthanhtrung
 *
 */
public interface TblCabinDao {

	/**
	 * @param cabinId
	 * @param trainId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	boolean checkExistCabinById(int cabinId, int trainId) throws SQLException, ClassNotFoundException;

	/**
	 * @param cabinId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	TblCabin getLastestRecordTblCabinById(int cabinId, int trainId) throws SQLException, ClassNotFoundException;

	/**
	 * @param trainId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<TblCabin> getAllTblCabin(int trainId) throws SQLException, ClassNotFoundException;

	/**
	 * @param trainName
	 * @param cabinId
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	boolean checkExistCabin(String trainName, int cabinId) throws SQLException, ClassNotFoundException;

	/**
	 * @param typeStat
	 * @param dateStat
	 * @param cabinID
	 * @param trainID
	 * @return List<Float>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Float> getParamAqiDateStat(String typeStat, String dateStat, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException;

	/**
	 * @param dateStat
	 * @param typeStat
	 * @param trainID
	 * @param cabinID
	 * @return List<Float>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Float> getAqiSumDateStat(String dateStat, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException;

	/**
	 * @param typeMonthStat
	 * @param dateStat
	 * @param trainID
	 * @param cabinID
	 * @return List<Float>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Float> getParamAqiMonthStat(String typeMonthStat, String dateStat, int countDayInMonth, int trainID,
			int cabinID) throws SQLException, ClassNotFoundException;

	/**
	 * @param dateStat
	 * @param trainID
	 * @param cabinID
	 * @return List<Float>
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Float> getAqiSumMonthStat(String dateStat, int countDayInMonth, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException;

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
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Integer> getListRatePoll(String selDate3, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException;

	/**
	 * @param selDate4
	 * @param trainID
	 * @param cabinID
	 * @return int
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	int getTotalRecord(String selDate4, int trainID, int cabinID) throws SQLException, ClassNotFoundException;

	/**
	 * @return
	 * boolean
	 */
	boolean checkUpdate();
}
