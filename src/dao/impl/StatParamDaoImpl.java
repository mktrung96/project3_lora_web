/**
 * dao.impl
 */
package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dao.StatParamDao;
import entities.StatParam;
import ultis.Constant;

/**
 * @author phanthanhtrung
 *
 */
public class StatParamDaoImpl extends BaseDaoImpl implements StatParamDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.StatParamDao#getStatParam()
	 */
	@Override
	public List<StatParam> getStatParam() throws SQLException, ClassNotFoundException {
		List<StatParam> listStatParams = new ArrayList<StatParam>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM " + Constant.TBL_STAT_PARAM + " ;");
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					StatParam statParam = new StatParam();
					statParam.setStatName(rs.getString("param_name"));
					statParam.setNote(rs.getString("note"));
					listStatParams.add(statParam);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listStatParams;
	}

}
