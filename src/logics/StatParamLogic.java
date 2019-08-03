/**
 * logics
 */
package logics;

import java.sql.SQLException;
import java.util.List;

import entities.StatParam;

/**
 * @author phanthanhtrung
 *
 */
public interface StatParamLogic {

	/**
	 * @return
	 * List<StatParam>
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	List<StatParam> getStatParam() throws ClassNotFoundException, SQLException;

}
