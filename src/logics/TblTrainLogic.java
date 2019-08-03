/**
 * 
 */
package logics;

import java.sql.SQLException;
import java.util.List;

import entities.TblTrain;

/**
 * @author phanthanhtrung
 *
 */
public interface TblTrainLogic {

	/**
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	List<TblTrain> getAllTblTrain() throws ClassNotFoundException, SQLException;

	/**
	 * @param trainName
	 * @return
	 * int
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	int getTrainIdByName(String trainName) throws ClassNotFoundException, SQLException;

	
	

}
