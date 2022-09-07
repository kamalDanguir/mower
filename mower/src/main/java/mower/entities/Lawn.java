package mower.entities;

/**
 * this class represents the Lawn
 * 
 * @author danguir
 *
 */
public class Lawn {

	private Coordinates maxPosition;

	public Lawn() {

	}

	public Lawn(Coordinates maxPosition) {
		this.maxPosition = maxPosition;
	}

	public Coordinates getMaxPosition() {
		return maxPosition;
	}

	public void setMaxPosition(Coordinates maxPosition) {
		this.maxPosition = maxPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxPosition == null) ? 0 : maxPosition.hashCode());
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
		Lawn other = (Lawn) obj;
		if (maxPosition == null) {
			if (other.maxPosition != null)
				return false;
		} else if (!maxPosition.equals(other.maxPosition))
			return false;
		return true;
	}
}