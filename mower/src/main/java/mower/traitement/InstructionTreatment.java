package mower.traitement;

import mower.entities.Coordinates;
import mower.entities.MowerPosition;
import mower.entities.Params;
import mower.entities.Params.Instruction;
import mower.entities.Params.Orientation;

/**
 * we use this class to move the mower
 * 
 * @author danguir
 *
 */
public class InstructionTreatment {

	private InstructionTreatment() {

	}

	/**
	 * move the mower forward
	 * 
	 * @param mowerPosition         : initial position of the mower
	 * @param upperRightCoordinates : lawn coordinates - upper right corner of the
	 *                              lawn
	 * @return coordinates : the new coordinates of the mower
	 * @throws Exception
	 */
	public static Coordinates moveMowerForward(MowerPosition mowerPosition, Coordinates upperRightCoordinates)
			throws Exception {
		Coordinates nextCoordinates = null;
		int x, y;
		switch (mowerPosition.getMowerOrientation()) {
		case NORTH:
			x = mowerPosition.getMowerCoordinates().getX();
			y = mowerPosition.getMowerCoordinates().getY() + 1;
			break;
		case EAST:
			x = mowerPosition.getMowerCoordinates().getX() + 1;
			y = mowerPosition.getMowerCoordinates().getY();
			break;
		case SOUTH:
			x = mowerPosition.getMowerCoordinates().getX();
			y = mowerPosition.getMowerCoordinates().getY() - 1;
			break;
		case WEST:
			x = mowerPosition.getMowerCoordinates().getX() - 1;
			y = mowerPosition.getMowerCoordinates().getY();
			break;
		default:
			throw new Exception(Params.INCORRECTE_POSITION);
		}
		nextCoordinates = new Coordinates(x, y);
		if (nextCoordinates != null && upperRightCoordinates.isCoordinatesOutsideLawn(nextCoordinates)) {
			return nextCoordinates;
		} else {
			return mowerPosition.getMowerCoordinates();
		}
	}

	/**
	 * rotate the mower to the right
	 * 
	 * @param orientation : initial orientation of the mower
	 * @return new orientation
	 * @throws Exception
	 */

	public static Orientation rotateRight(Orientation orientation) throws Exception {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.EAST;
			break;
		case EAST:
			nextOrientation = Orientation.SOUTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.WEST;
			break;
		case WEST:
			nextOrientation = Orientation.NORTH;
			break;
		default:
			throw new Exception(Params.INCORRECT_ORIENTATION);
		}
		return nextOrientation;
	}

	/**
	 * rotate the mower to the left
	 * 
	 * @param orientation : initial orientation of the mower
	 * @return new orientation
	 * @throws Exception
	 */
	public static Orientation rotateLeft(Orientation orientation) throws Exception {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.WEST;
			break;
		case EAST:
			nextOrientation = Orientation.NORTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.EAST;
			break;
		case WEST:
			nextOrientation = Orientation.SOUTH;
			break;
		default:
			throw new Exception(Params.INCORRECT_ORIENTATION);
		}
		return nextOrientation;
	}

	/**
	 * execute a single instruction ( A, D or G)
	 * 
	 * @param mowerPosition
	 * @param instruction
	 * @param upperRightCoordinates
	 * @throws Exception
	 */
	public static void executeInstruction(MowerPosition mowerPosition, Instruction instruction,
			Coordinates upperRightCoordinates) throws Exception {

		switch (instruction) {
		case AVANCER:
			mowerPosition
					.setMowerCoordinates(InstructionTreatment.moveMowerForward(mowerPosition, upperRightCoordinates));
			break;
		case DROITE:
			mowerPosition.setMowerOrientation(InstructionTreatment.rotateRight(mowerPosition.getMowerOrientation()));
			break;
		case GAUCHE:
			mowerPosition.setMowerOrientation(InstructionTreatment.rotateLeft(mowerPosition.getMowerOrientation()));
			break;
		default:
			throw new Exception(Params.INCORRECTE_INSTRUCTION);
		}
	}
}