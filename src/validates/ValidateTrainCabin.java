/**
 * validates
 */
package validates;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logics.TblCabinLogic;
import logics.TblTrainLogic;
import logics.impl.TblCabinLogicImpl;
import logics.impl.TblTrainLogicImpl;
import ultis.Common;
import ultis.Constant;
import ultis.MessageErrorProperties;

/**
 * @author phanthanhtrung
 *
 */
public class ValidateTrainCabin {
	/**
	 * 
	 * <b>Phương thức kiểm tra nhập liệu train và cabin</b><br>
	 * 
	 * @param user     String trainName cần kiểm tra
	 * @param password String cabinId cần kiểm tra
	 * @return ArrayList<String> danh sách lỗi trong quá trình kiểm tra.<br>
	 *         Nếu danh sách rỗng thì trainname và cabinId nhập vào là đúng
	 * @throws NoSuchAlgorithmException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<String> checkValidateTrainCabin(String trainName, String cabinId)
			throws NoSuchAlgorithmException, ClassNotFoundException, SQLException {

		TblCabinLogic tblCabinLogicImpl = new TblCabinLogicImpl(); // khai báo đối tượng TblUserLogicImpl
		// Khai báo arraylist lỗi
		List<String> listError = new ArrayList<>();
		// nếu chưa nhập userName
		if (trainName == null || trainName.isEmpty()) {
			// add lỗi chưa nhập username
			listError.add(MessageErrorProperties.getValue(Constant.ER001_TRAIN_NAME));
		}
		// nếu chưa nhập password
		if (cabinId == null || cabinId.isEmpty()) {
			// add lỗi chưa nhập password
			listError.add(MessageErrorProperties.getValue(Constant.ER001_CABINID));
		}
		// nếu chưa nhập password
		if (Common.parseInt(cabinId) == 0) {
			// add lỗi chưa nhập password
			listError.add(MessageErrorProperties.getValue(Constant.ER019_CABINID));
		}
		// nếu không có lỗi
		if (listError.isEmpty()) {

			TblTrainLogic tblTrainLogicImpl = new TblTrainLogicImpl();
			// kiểm tra sự tồn tại của trainName và cabinId trong DB
			boolean checkExist = tblCabinLogicImpl.checkExistCabin(trainName, Common.parseInt(cabinId));
			// nếu không trùng khớp trong DB thì add lỗi
			if (!checkExist) {
				listError.add(MessageErrorProperties.getValue(Constant.ER016));
			}
		}
		return listError;
	}
}
