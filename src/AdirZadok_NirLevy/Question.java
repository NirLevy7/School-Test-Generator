package AdirZadok_NirLevy;

import java.io.Serializable;


public class Question implements Cloneable, Serializable {
	private static int counter = 0;
	private String text;
	private int serialNumber;

	public Question(String text) {
		this.text = text;
		this.serialNumber = ++counter;
	}

	public String getText() {
		return text;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void editQuenstion(String update) {
		text = update;
	}

	public void editAnswer() {
	}

	@Override
	public Question clone() throws CloneNotSupportedException {
		Question temp = (Question) super.clone();
		return temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	public boolean equals(String text) {
		if (text == null) {
			return false;
		}
		if (getText().equalsIgnoreCase(text)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return text;
	}

}
