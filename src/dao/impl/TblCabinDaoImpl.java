
package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dao.TblCabinDao;
import entities.Record;
import entities.TblCabin;
import ultis.Common;
import ultis.Constant;

/**
 * @author phanthanhtrung
 *
 */
public class TblCabinDaoImpl extends BaseDaoImpl implements TblCabinDao {
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#checkExistCabinById(int)
	 */
	@Override
	public boolean checkExistCabinById(int cabinId, int trainId) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();

				sql.append("SELECT * FROM tbl_cabin WHERE cabin_id = ? and train_id = ?; ");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, cabinId);
				preparedStatement.setInt(++i, trainId);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getTblCabinById(int)
	 */
	@Override
	public TblCabin getLastestRecordTblCabinById(int cabinId, int trainId) throws SQLException, ClassNotFoundException {
		TblCabin tblCabin = new TblCabin();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append(
						"SELECT temp,humi,co,co2,ethanol,toluene,acetone,time_record,longitude,latitude FROM tbl_cabin WHERE record_id = ( SELECT max(record_id) FROM tbl_cabin WHERE "
								+ Constant.TBL_CABIN_CABIN_ID + " = ? and " + Constant.TBL_CABIN_TRAIN_ID + " = ?);");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, cabinId);
				preparedStatement.setInt(++i, trainId);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					tblCabin.setCabinID(cabinId);
					tblCabin.setTrainID(trainId);
					tblCabin.setTemp(rs.getFloat("temp"));
					tblCabin.setHumi(rs.getFloat("humi"));
					tblCabin.setCo(rs.getFloat("co"));
					tblCabin.setCo2(rs.getFloat("co2"));
//					tblCabin.setNo2(rs.getFloat("no2"));
//					tblCabin.setSo2(rs.getFloat("so2"));
//					tblCabin.setO3(rs.getFloat("o3"));
//					tblCabin.setPm25(rs.getFloat("pm25"));
//					tblCabin.setPm10(rs.getFloat("pm10"));
					tblCabin.setAcetone(rs.getFloat("acetone"));
					tblCabin.setToluene(rs.getFloat("toluene"));
					tblCabin.setEthanol(rs.getFloat("ethanol"));
					tblCabin.setDateRecord(rs.getDate("time_record"));
					tblCabin.setTimeRecord(rs.getTime("time_record"));

					tblCabin.setLongitude(rs.getString("longitude"));
					tblCabin.setLatitude(rs.getString("latitude"));
				}
//				else {
//					tblCabin.setCabinID(cabinId);
//					tblCabin.setTrainID(trainId);
//					tblCabin.setTemp(0);
//					tblCabin.setHumi(0);
//					tblCabin.setCo(0);
////					tblCabin.setNo2(0);
////					tblCabin.setSo2(0);
////					tblCabin.setO3(0);
////					tblCabin.setPm25(0);
////					tblCabin.setPm10(0);
//					tblCabin.setAcetone(0);
//					tblCabin.setToluene(0);
//					tblCabin.setEthanol(0);
//					tblCabin.setLongitude(null);
//					tblCabin.setLatitude(null);
//				}
				
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return tblCabin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getAllTblCabin(int)
	 */
	@Override
	public List<TblCabin> getAllTblCabin(int trainId) throws SQLException, ClassNotFoundException {
		List<TblCabin> listCabin = new ArrayList<TblCabin>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT " + Constant.TBL_CABIN_CABIN_ID + " FROM tbl_cabin WHERE "
						+ Constant.TBL_CABIN_TRAIN_ID + " = ?;");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, trainId);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					TblCabin tblCabin = new TblCabin();
					tblCabin.setCabinID(rs.getInt("cabin_id"));
					listCabin.add(tblCabin);
				}
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listCabin;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#checkExistCabin(java.lang.String, int)
	 */
	@Override
	public boolean checkExistCabin(String trainName, int cabinId) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tbl_cabin ");
				sql.append(" tbl_cabin INNER JOIN tbl_train  ");
				sql.append(" ON  tbl_cabin.train_id = tbl_train.train_id ");
				sql.append(" WHERE train_name = ? and cabin_id = ?; ");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setString(++i, trainName);
				preparedStatement.setInt(++i, cabinId);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getParamAqiDateStat(java.lang.String, java.util.List)
	 */
	@Override
	public List<Float> getParamAqiDateStat(String typeStat, String dateStat, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		List<Float> listdParamAqiDateStat = new ArrayList<Float>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT " + typeStat + " FROM tbl_cabin WHERE cabin_id = ? "
						+ "and train_id = ? and (time_record >='" + dateStat + ":00:00'AND time_record <'" + dateStat
						+ ":59:59');");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, cabinID);
				preparedStatement.setInt(++i, trainID);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					float param = rs.getFloat(typeStat);
					listdParamAqiDateStat.add(param);
				}
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listdParamAqiDateStat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getAqiSumDateStat(java.lang.String, java.lang.String,
	 * int, int)
	 */
	@Override
	public List<Float> getAqiSumDateStat(String dateStat, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		List<Float> listdParamAqiDateStat = new ArrayList<Float>();
		try {
			openMySQLConnection();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT * FROM tbl_cabin WHERE cabin_id = ? " + "and train_id = ? and (time_record >='"
						+ dateStat + ":00:00'AND time_record <'" + dateStat + ":59:59');");
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
				preparedStatement.setInt(++i, cabinID);
				preparedStatement.setInt(++i, trainID);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					TblCabin tblCabin = new TblCabin();
					tblCabin.setTemp(rs.getFloat("temp"));
					tblCabin.setHumi(rs.getFloat("humi"));
					tblCabin.setCo(rs.getFloat("co"));
					tblCabin.setCo2(rs.getFloat("co2"));
//					tblCabin.setNo2(rs.getFloat("no2"));
//					tblCabin.setSo2(rs.getFloat("so2"));
//					tblCabin.setO3(rs.getFloat("o3"));
//					tblCabin.setPm25(rs.getFloat("pm25"));
//					tblCabin.setPm10(rs.getFloat("pm10"));
					tblCabin.setAcetone(rs.getFloat("acetone"));
					tblCabin.setToluene(rs.getFloat("toluene"));
					tblCabin.setEthanol(rs.getFloat("ethanol"));
					float aqi = Common.calAqi(tblCabin).get(0);
					listdParamAqiDateStat.add(aqi);
				}
			}

		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listdParamAqiDateStat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getParamAqiMonthStat(java.lang.String, java.lang.String,
	 * int, int)
	 */
	@Override
	public List<Float> getParamAqiMonthStat(String typeMonthStat, String selMonth, int countDayInMonth, int trainID,
			int cabinID) throws SQLException, ClassNotFoundException {
		List<Float> listdParamAqiMonthStat = new ArrayList<Float>();
		try {
			openMySQLConnection();
			if (conn != null) {
				for (int count = 1; count <= countDayInMonth; count++) {
					String dateStat = selMonth + "-" + count;
					StringBuilder sql = new StringBuilder();
					sql.append("SELECT " + typeMonthStat + " FROM tbl_cabin WHERE cabin_id = ? "
							+ "and train_id = ? and (time_record >='" + dateStat + " 00:00:00'AND time_record <'"
							+ dateStat + " 23:59:59');");
					int i = 0;
					preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
					preparedStatement.setInt(++i, cabinID);
					preparedStatement.setInt(++i, trainID);
					ResultSet rs = preparedStatement.executeQuery();
					int temp = 0;
					float sum = 0;
					while (rs.next()) {
						float param = rs.getFloat(typeMonthStat);
						sum = param + sum;
						temp++;
					}
					if (temp != 0) {
						listdParamAqiMonthStat.add(sum / temp);
					} else {
						listdParamAqiMonthStat.add(sum);
					}
				}

			}
		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}

		return listdParamAqiMonthStat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getAqiSumMonthStat(java.lang.String, int, int)
	 */
	@Override
	public List<Float> getAqiSumMonthStat(String selMonth, int countDayInMonth, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		List<Float> listdParamAqiMonthStat = new ArrayList<Float>();
		try {
			openMySQLConnection();
			if (conn != null) {
				for (int count = 1; count <= countDayInMonth; count++) {
					String dateStat = selMonth + "-" + count;
					StringBuilder sql = new StringBuilder();
					sql.append("SELECT * FROM tbl_cabin WHERE cabin_id = ? " + "and train_id = ? and (time_record >='"
							+ dateStat + " 00:00:00'AND time_record <'" + dateStat + " 23:59:59');");
					int i = 0;
					preparedStatement = (PreparedStatement) conn.prepareStatement(sql.toString());
					preparedStatement.setInt(++i, cabinID);
					preparedStatement.setInt(++i, trainID);
					ResultSet rs = preparedStatement.executeQuery();
					int temp = 0;
					float sum = 0;
					while (rs.next()) {
						TblCabin tblCabin = new TblCabin();
						tblCabin.setTemp(rs.getFloat("temp"));
						tblCabin.setHumi(rs.getFloat("humi"));
						tblCabin.setCo(rs.getFloat("co"));
						tblCabin.setCo2(rs.getFloat("co2"));

//						tblCabin.setNo2(rs.getFloat("no2"));
//						tblCabin.setSo2(rs.getFloat("so2"));
//						tblCabin.setO3(rs.getFloat("o3"));
//						tblCabin.setPm25(rs.getFloat("pm25"));
//						tblCabin.setPm10(rs.getFloat("pm10"));
						tblCabin.setAcetone(rs.getFloat("acetone"));
						tblCabin.setToluene(rs.getFloat("toluene"));
						tblCabin.setEthanol(rs.getFloat("ethanol"));
						float aqi = Common.calAqi(tblCabin).get(0);
						sum = aqi + sum;
						temp++;
					}
					if (temp != 0) {
						listdParamAqiMonthStat.add(sum / temp);
					} else {
						listdParamAqiMonthStat.add(sum);
					}
				}
			}
		} catch (SQLException   e) {
			throw e;
		}catch (ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnection();
		}
		return listdParamAqiMonthStat;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getTotalRecord(int, int)
	 */
	@Override
	public int getTotalRecord(String selDate4, int trainID, int cabinID) throws SQLException, ClassNotFoundException {
		int result = -1;
		try {
			// mở kết nối tới database
			openMySQLConnection();
			// nếu Connection đã có thì thực thi dòng câu lệnh phía dưới
			if (conn != null) {
				// khai báo câu lệnh SQL và append lần lượt các giá trị
				// đã đúng điều kiện
				StringBuilder sqlB = new StringBuilder();
				sqlB.append("SELECT COUNT(" + Constant.TBL_CABIN_RECORD_ID);
				sqlB.append(") FROM " + Constant.TBL_CABIN);
				sqlB.append(" where 1=1");
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_TRAIN_ID + " = ? ");
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_CABIN_ID + " = ?");
				sqlB.append(" and (time_record >='" + selDate4 + " 00:00:00'AND time_record <'" + selDate4
						+ " 23:59:59') ");

				sqlB.append(";");
				// Khai báo vị tri parameter
				int i = 0;
				// chuyển stringbuilder sang string
				String sql = sqlB.toString();
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				// Gán các giá trị lên preparedStatement
				preparedStatement.setInt(++i, trainID);
				preparedStatement.setInt(++i, cabinID);
				// get data theo câu lệnh truy vấn sql ở trên.
				// lấy danh sách kết quả đã tìm kiếm được
				ResultSet rs = preparedStatement.executeQuery();
				// lấy kết quả trả về
				while (rs.next()) {
					result = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}
		// Nếu bị lỗi thấy trả về -1
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getListRecord(int, int, int, int)
	 */
	@Override
	public List<Record> getListRecord(String selDate4, int offSet, int limit, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		try {
			// khởi tạo danh sách trả về
			ArrayList<Record> listRecord = new ArrayList<>();
			// mở kết nối tới database
			openMySQLConnection();
			// nếu Connection đã có thì thực thi dòng câu lệnh phía dưới
			if (conn != null) {
				// khai báo câu lệnh SQL và append lần lượt các giá trị
				// đã đúng điều kiện
				StringBuilder sqlB = new StringBuilder();
				sqlB.append("SELECT " + Constant.TBL_CABIN_TIME_RECORD + ", ");
				sqlB.append(Constant.TBL_CABIN_TEMP + ", ");
				sqlB.append(Constant.TBL_CABIN_HUMI + ", ");
				sqlB.append(Constant.TBL_CABIN_CO + ", " + Constant.TBL_CABIN_ETHANOL + ", ");
				sqlB.append(Constant.TBL_CABIN_CO2 + ", ");
				sqlB.append(Constant.TBL_CABIN_TOLUENE + ", " + Constant.TBL_CABIN_ACETONE);

				sqlB.append(" FROM ");
				sqlB.append(Constant.TBL_CABIN);
				sqlB.append(" where 1=1");
				// Kiểm tra xem tìm kiesm group id kiểu tất cả hay theo group id
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_CABIN_ID + " = ? ");
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_TRAIN_ID + " = ? ");
				sqlB.append(" and (time_record >='" + selDate4 + " 00:00:00'AND time_record <'" + selDate4
						+ " 23:59:59') ");
				// thêm điều kiện lấy ra bao nhiêu bản ghi
				sqlB.append(" LIMIT " + limit);
				// thêm điều kiện lấy từ bản ghi thứ bao nhiêu
				sqlB.append(" OFFSET " + offSet);
				sqlB.append(";");
				// chuyển stringbuilder sang string
				String sql = sqlB.toString();
				// Khai báo vị tri parameter
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				// Chuyển đối dữ liệu fullname truyền vào tránh kí tự wilcard
				preparedStatement.setInt(++i, trainID);
				// Gán các giá trị lên preparedStatement
				preparedStatement.setInt(++i, cabinID);
				ResultSet rs = preparedStatement.executeQuery();
				int stt = offSet;
				// lây tất cả bản ghi tìm được và add vào danh sách
				while (rs.next()) {
					Record record = new Record();
					record.setStt(++stt);
					record.setTimeRecord(rs.getTime("time_record"));
					record.setDateRecord(rs.getDate("time_record"));
					record.setTemp(rs.getFloat("temp"));
					record.setHumi(rs.getFloat("humi"));
//					record.setPressure(rs.getFloat("pressure"));
					record.setCo(rs.getFloat("co"));
					record.setCo2(rs.getFloat("co2"));
//					record.setNo2(rs.getFloat("no2"));
//					record.setSo2(rs.getFloat("so2"));
//					record.setO3(rs.getFloat("o3"));
//					record.setPm25(rs.getFloat("pm25"));
//					record.setPm10(rs.getFloat("pm10"));
					record.setAcetone(rs.getFloat("acetone"));
					record.setToluene(rs.getFloat("toluene"));
					record.setEthanol(rs.getFloat("ethanol"));
					listRecord.add(record);
				}
				// trả về danh sách đã tìm kiếm được
				return listRecord;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.TblCabinDao#getListRatePoll(java.lang.String, int, int)
	 */
	@Override
	public List<Integer> getListRatePoll(String selDate3, int trainID, int cabinID)
			throws SQLException, ClassNotFoundException {
		try {
			// khởi tạo danh sách trả về
			ArrayList<Integer> listRatePoll = new ArrayList<>();
			// mở kết nối tới database
			openMySQLConnection();
			// nếu Connection đã có thì thực thi dòng câu lệnh phía dưới
			if (conn != null) {
				// khai báo câu lệnh SQL và append lần lượt các giá trị
				// đã đúng điều kiện
				StringBuilder sqlB = new StringBuilder();
				sqlB.append("SELECT " + Constant.TBL_CABIN_TIME_RECORD + ", ");
				sqlB.append(Constant.TBL_CABIN_CO + ", " + Constant.TBL_CABIN_ETHANOL + ", ");
				sqlB.append(Constant.TBL_CABIN_CO2 + ", ");
				sqlB.append(Constant.TBL_CABIN_TOLUENE + ", " + Constant.TBL_CABIN_ACETONE);
				sqlB.append(" FROM ");
				sqlB.append(Constant.TBL_CABIN);
				sqlB.append(" where 1=1 ");
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_TRAIN_ID + " = ? ");
				sqlB.append(" AND ");
				sqlB.append(Constant.TBL_CABIN_CABIN_ID + " = ? ");
				sqlB.append(" and (time_record >='" + selDate3 + " 00:00:00'AND time_record <'" + selDate3
						+ " 23:59:59') ");
				sqlB.append(";");
				// chuyển stringbuilder sang string
				String sql = sqlB.toString();
				// Khai báo vị tri parameter
				int i = 0;
				preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
				// Chuyển đối dữ liệu fullname truyền vào tránh kí tự wilcard
				preparedStatement.setInt(++i, trainID);
				// Gán các giá trị lên preparedStatement
				preparedStatement.setInt(++i, cabinID);
				ResultSet rs = preparedStatement.executeQuery();
				int tot = 0;
				int tb = 0;
				int kem = 0;
				int xau = 0;
				int nguyHiem = 0;

				// lây tất cả bản ghi tìm được và add vào danh sách
				while (rs.next()) {
					TblCabin tblCabin = new TblCabin();
					tblCabin.setCo(rs.getFloat("co"));
					tblCabin.setCo2(rs.getFloat("co2"));
//					tblCabin.setNo2(rs.getFloat("no2"));
//					tblCabin.setSo2(rs.getFloat("so2"));
//					tblCabin.setO3(rs.getFloat("o3"));
//					tblCabin.setPm25(rs.getFloat("pm25"));
//					tblCabin.setPm10(rs.getFloat("pm10"));
					tblCabin.setAcetone(rs.getFloat("acetone"));
					tblCabin.setToluene(rs.getFloat("toluene"));
					tblCabin.setEthanol(rs.getFloat("ethanol"));
					float aqi = Common.calAqi(tblCabin).get(0);

					if (aqi <= 50) {
						tot++;
					}
					if (aqi > 50 && aqi <= 100) {
						tb++;
					}
					if (aqi > 100 && aqi <= 200) {
						kem++;
					}
					if (aqi > 200 && aqi <= 300) {
						xau++;
					}
					if (aqi > 300) {
						nguyHiem++;
					}
				}
				int sum = tot + xau + kem + tb + nguyHiem;
				if (sum != 0) {
					listRatePoll.add(tot * 100 / sum);
					listRatePoll.add(tb * 100 / sum);
					listRatePoll.add(kem * 100 / sum);
					listRatePoll.add(xau * 100 / sum);
					listRatePoll.add(nguyHiem * 100 / sum);
				} else {
					listRatePoll.add(0);
					listRatePoll.add(0);
					listRatePoll.add(0);
					listRatePoll.add(0);
					listRatePoll.add(0);
					listRatePoll.add(100);

				}

				// trả về danh sách đã tìm kiếm được
				return listRatePoll;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			closeConnection();
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see dao.TblCabinDao#checkUpdate()
	 */
	@Override
	public boolean checkUpdate() {
		
		return false;
	}

}
