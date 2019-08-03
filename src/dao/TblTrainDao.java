/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import entities.TblTrain;

/**
 * @author phanthanhtrung
 *
 */
public interface TblTrainDao {

	/**
	 * @param trainId
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	boolean checkExistTrainById(int trainId) throws SQLException, ClassNotFoundException;

	/**
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	List<TblTrain> getAllTblTrain() throws SQLException, ClassNotFoundException;

	/**
	 * @param trainName
	 * @return
	 * int
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	int getTrainIdByName(String trainName) throws SQLException, ClassNotFoundException;

	

}
