package mower.traitement;

import java.util.ArrayList;
import java.util.List;

import mower.entities.Coordinates;
import mower.entities.Lawn;
import mower.entities.MowerPosition;
import mower.entities.Params.Instruction;
import mower.entities.Params.Orientation;

/**
 * we use this class to format the line of the mower's position
 * 
 * @author danguir
 *
 */
public class LineFormater {

	private static final String SPACE_CHAR = " ";

	private LineFormater() {

	}

	/**
	 * retrieve the position of the mower
	 * 
	 * @param mowerLine : line of the mower position
	 * @return the object that defines the mower's position
	 */
	public static MowerPosition formatMowerLine(String mowerLine) {
		String[] elts = mowerLine.split(SPACE_CHAR);
		Coordinates mowerCoordinates = new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation mowerOrientation = getOrientation(elts[2].charAt(0));
		return new MowerPosition(mowerCoordinates, mowerOrientation);
	}

	/**
	 * retrieve the Lawn object containing the boundary coordinates of the lawn
	 * 
	 * @param LawnLine : lawn's line
	 * @return the object that defines the boundary of the lawn
	 */
	public static Lawn formatLawnLine(String LawnLine) {
		String[] elts = LawnLine.split(SPACE_CHAR);
		return new Lawn(new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	/**
	 * retrieve a list of enumeration Instruction corresponding to the instruction
	 * line
	 * 
	 * @param instructionLine : instruction sequence
	 * @return a list of enum Instruction
	 */
	public static List<Instruction> formatInstructionLine(String instructionLine) {
		List<Instruction> listInstruction = new ArrayList<Instruction>();
		for (char instruction : instructionLine.toCharArray()) {
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	/**
	 * recover an enum Orientation corresponding to the character of the orientation
	 * 
	 * @param orientationCode : character of the orientation (E, W, N, S)
	 * @return the enum corresponding to the orientation
	 */
	public static Orientation getOrientation(char orientationCode) {
		for (Orientation orientation : Orientation.values()) {
			if (orientation.getCode() == orientationCode) {
				return orientation;
			}
		}
		return null;
	}

	/**
	 * retrieve an instruction enum corresponding to the instruction character
	 * 
	 * @param codeInstruction : character of the instruction (A, G, D)
	 * @return the enum corresponding to the instruction
	 */
	public static Instruction getInstruction(char codeInstruction) {
		for (Instruction instruction : Instruction.values()) {
			if (instruction.getCode() == codeInstruction) {
				return instruction;
			}
		}
		return null;
	}
}