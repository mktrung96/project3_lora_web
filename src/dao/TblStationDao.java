/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import entities.TblStation;

/**
 * @author phanthanhtrung
 *
 */
public interface TblStationDao {

	

	/**
	 * @return
	 * List<TblStation>
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	List<TblStation> getAllStation() throws SQLException, ClassNotFoundException;

}
