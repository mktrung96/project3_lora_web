/**
 * 
 */
package logics;

import java.sql.Date;
import java.sql.SQLException;

import entities.TblCabin;

/**
 * @author phanthanhtrung
 *
 */
public interface TblStationLogic {

	/**
	 * @param longitude
	 * @param latitude
	 * @return
	 * String
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	String getNextStation(String longitude, String latitude) throws ClassNotFoundException, SQLException;

	
}
