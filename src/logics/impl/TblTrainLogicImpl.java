/**
 * 
 */
package logics.impl;

import java.sql.SQLException;
import java.util.List;

import dao.TblTrainDao;
import dao.impl.TblTrainDaoImpl;
import entities.TblTrain;
import logics.TblTrainLogic;

/**
 * @author phanthanhtrung
 *
 */
public class TblTrainLogicImpl implements TblTrainLogic {

	/*
	 * (non-Javadoc)
	 * 
	 * @see logics.TblTrainLogic#getAllTblTrain()
	 */
	@Override
	public List<TblTrain> getAllTblTrain() throws ClassNotFoundException, SQLException {
		TblTrainDao tblTrainDaoImpl = new TblTrainDaoImpl();
		List<TblTrain> tblTrains = tblTrainDaoImpl.getAllTblTrain();
		return tblTrains;
	}

	/* (non-Javadoc)
	 * @see logics.TblTrainLogic#getTrainIdByName(java.lang.String)
	 */
	@Override
	public int getTrainIdByName(String trainName) throws ClassNotFoundException, SQLException {
		TblTrainDao tblTrainDaoImpl = new TblTrainDaoImpl();
		int trainID = tblTrainDaoImpl.getTrainIdByName(trainName);
		return trainID;
	}

	

}
