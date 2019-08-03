/**
 * dao
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import entities.StatParam;

/**
 * @author phanthanhtrung
 *
 */
public interface StatParamDao {

	/**
	 * @return
	 * List<StatParam>
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	List<StatParam> getStatParam() throws SQLException, ClassNotFoundException;

}
