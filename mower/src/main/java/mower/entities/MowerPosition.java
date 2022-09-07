package mower.entities;

/**
 * this class represents the mower position
 * 
 * @author danguir
 *
 */
public class MowerPosition {

	private Coordinates mowerCoordinates;
	private Params.Orientation mowerOrientation;

	public MowerPosition(Coordinates mowerCoordinates, Params.Orientation mowerOrientation) {
		this.mowerCoordinates = mowerCoordinates;
		this.mowerOrientation = mowerOrientation;
	}

	public Params.Orientation getMowerOrientation() {
		return mowerOrientation;
	}

	public void setMowerOrientation(Params.Orientation mowerOrientation) {
		this.mowerOrientation = mowerOrientation;
	}

	public Coordinates getMowerCoordinates() {
		return mowerCoordinates;
	}

	public void setMowerCoordinates(Coordinates mowerCoordinates) {
		this.mowerCoordinates = mowerCoordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mowerCoordinates == null) ? 0 : mowerCoordinates.hashCode());
		result = prime * result + ((mowerOrientation == null) ? 0 : mowerOrientation.hashCode());
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
		MowerPosition other = (MowerPosition) obj;
		if (mowerCoordinates == null) {
			if (other.mowerCoordinates != null)
				return false;
		} else if (!mowerCoordinates.equals(other.mowerCoordinates))
			return false;
		if (mowerOrientation != other.mowerOrientation)
			return false;
		return true;
	}
}