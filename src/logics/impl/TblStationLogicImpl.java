/**
 * 
 */
package logics.impl;

import java.sql.SQLException;
import java.util.List;

import dao.TblStationDao;
import dao.impl.TblStationDaoImpl;
import entities.TblStation;
import logics.TblStationLogic;

/**
 * @author phanthanhtrung
 *
 */
public class TblStationLogicImpl implements TblStationLogic {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblStationLogic#getNextStation(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getNextStation(String longitude, String latitude) throws ClassNotFoundException, SQLException {
		TblStationDao tblStationDaoImpl = new TblStationDaoImpl();
		List<TblStation> listStation = tblStationDaoImpl.getAllStation();
		
		String nStation = "";
		try {
			double R = 6371e3;
			double log1 = Double.parseDouble(longitude);
			double lat1 = Double.parseDouble(latitude);
			double temp1 = R;
			for (int i = 0; i < listStation.size(); i++) {
				double log2 = Double.parseDouble(listStation.get(i).getLongitude());
				double lat2 = Double.parseDouble(listStation.get(i).getLatitude());
//				double dLat = (lat2 - lat1) * (Math.PI / 180);
//				double dLon = (log2 - log1) * (Math.PI / 180);
//				double la1ToRad = lat1 * (Math.PI / 180);
//				double la2ToRad = lat2 * (Math.PI / 180);
//				double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//						+ Math.cos(la1ToRad) * Math.cos(la2ToRad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
//				double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//				System.out.println("c: " + c);
//				double d = R * c;
//				System.out.println("d: " + d);
				
				double d = Math.sqrt((lat2 - lat1) * (lat2 - lat1) + (log2 - log1) * (log2 - log1));
				if (d < temp1) {
					temp1 = d;
					nStation = listStation.get(i).getStationName();
				}

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return nStation;
	}

}
