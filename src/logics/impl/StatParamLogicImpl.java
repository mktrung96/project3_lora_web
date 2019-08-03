/**
 * logics.impl
 */
package logics.impl;

import java.sql.SQLException;
import java.util.List;

import dao.StatParamDao;
import dao.impl.StatParamDaoImpl;
import entities.StatParam;
import logics.StatParamLogic;

/**
 * @author phanthanhtrung
 *
 */
public class StatParamLogicImpl implements StatParamLogic {

	/**
	 * @return List<StatParam>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<StatParam> getStatParam() throws ClassNotFoundException, SQLException {
		StatParamDao statParamDaoImpl = new StatParamDaoImpl();
		List<StatParam> liStatParams = statParamDaoImpl.getStatParam();
		return liStatParams;
	}

}
