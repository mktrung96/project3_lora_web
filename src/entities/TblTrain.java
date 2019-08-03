/**
 * 
 */
package entities;

/**
 * @author phanthanhtrung
 *
 */
public class TblTrain {
	private int trainId;
	private String trainName;

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "TblTrain [trainId=" + trainId + ", trainName=" + trainName + "]";
	}

}
