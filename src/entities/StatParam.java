/**
 * entities
 */
package entities;

/**
 * @author phanthanhtrung
 *
 */
public class StatParam {
	private String statName;
	private String note;

	public String getStatName() {
		return statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "StatParam [statName=" + statName + ", note=" + note + "]";
	}

}
