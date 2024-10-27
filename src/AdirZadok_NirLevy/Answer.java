package AdirZadok_NirLevy;

import java.io.Serializable;

public class Answer implements Cloneable, Serializable {
	private String text;
	private boolean type;

	public Answer(String text, boolean type) {
		this.text = text;
		this.type = type;
	}

	public String getText() {
		return text;
	}
	

	@Override
	public Answer clone() throws CloneNotSupportedException {
		Answer ans = (Answer) super.clone();
		Answer copy = ans;
		copy.text = String.copyValueOf(copy.text.toCharArray());
		return copy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	public boolean getType() {
		return type;
	}

	public void edit(String update) {
		text = update;
	}

	public void editType(boolean update) {
		type = update;
	}

	public String toString() {
		return text + " ---> " + type;
	}

}
