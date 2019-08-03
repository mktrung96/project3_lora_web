/**
 * 
 */
package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dao.TblTrainDao;
import entities.TblTrain;

/**
 * @author phanthanhtrung
 *
 */
public class TblTrainDaoImpl extends BaseDaoImpl implements TblTrainDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblTrainDao#checkExistTrainById(int)
	 */
	@Override
	public boolean checkExistTrainById(int trainId) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tbl_train WHERE train_id = ?; ");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, trainId);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblTrainDao#getAllTblTrain()
	 */
	@Override
	public List<TblTrain> getAllTblTrain() throws SQLException, ClassNotFoundException {
		List<TblTrain> listTrain = new ArrayList<TblTrain>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * " + " FROM tbl_train ;");
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					TblTrain tblTrain = new TblTrain();
					tblTrain.setTrainId(rs.getInt("train_id"));
					tblTrain.setTrainName(rs.getString("train_name"));
					listTrain.add(tblTrain);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listTrain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblTrainDao#getTrainIdByName(java.lang.String)
	 */
	@Override
	public int getTrainIdByName(String trainName) throws SQLException, ClassNotFoundException {
		int trainID = 0;
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT train_id FROM tbl_train ");
				sql.append(" WHERE train_name = ? ;");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setString(++i, trainName);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					trainID = rs.getInt("train_id");
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}
		return trainID;
	}

}
