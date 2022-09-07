package mower.entities;

/**
 * this class represents the coordinates of the mower
 * 
 * @author danguir
 *
 */
public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}

	/**
	 * check if the coordinates of the mower after movement are outside those of the
	 * lawn
	 * 
	 * @param coordinates
	 * @return true if the coordinates of the mower are inside the lawn
	 */
	public boolean isCoordinatesOutsideLawn(Coordinates coordinates) {
		return coordinates.getX() >= 0 && coordinates.getY() >= 0 && coordinates.getX() <= this.x
				&& coordinates.getY() <= this.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordinates other = (Coordinates) obj;
		if (x != other.x || y != other.y)
			return false;

		return true;
	}
}