/**
 * 
 */
package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dao.TblStationDao;
import entities.TblStation;

/**
 * @author phanthanhtrung
 *
 */
public class TblStationDaoImpl extends BaseDaoImpl implements TblStationDao {



	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblStationDao#getAllStation()
	 */
	@Override
	public List<TblStation> getAllStation() throws SQLException, ClassNotFoundException {
		List<TblStation> listStation = new ArrayList<TblStation>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * " + "FROM tbl_station " + ";");
				
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					TblStation station = new TblStation();
					station.setStationId(rs.getInt("station_id"));
					station.setStationName(rs.getString("station_name"));
					station.setLongitude(rs.getString("longitude"));
					station.setLatitude(rs.getString("latitude"));
					listStation.add(station);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}
		return listStation;
	}

}
