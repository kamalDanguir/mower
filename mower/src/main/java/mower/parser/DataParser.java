package mower.parser;

import mower.entities.Params.Instruction;
import mower.entities.Params.Orientation;

/**
 * this class contains the methods that will validate the format of the rows in
 * the file.
 * 
 * @author danguir
 *
 */
public class DataParser {

	private DataParser() {

	}

	/**
	 * parse the position of the mower and its orientation Position and orientation
	 * are provided in the form of 2 digits and a letter, separated by a space
	 * 
	 * @param mower
	 * @return true if the position line is correct, false otherwise
	 */
	public static boolean parseMower(String mower) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCode()).append("|").append(Orientation.SOUTH.getCode()).append("|")
				.append(Orientation.EAST.getCode()).append("|").append(Orientation.WEST.getCode());
		return mower.matches("(\\d+) (\\d+) (" + stringBuilder.toString() + ")");
	}

	/**
	 * parse the instruction line the instructions are a sequence of characters
	 * without spaces
	 * 
	 * @param instructions
	 * @return true if the instruction line is correct, false otherwise
	 */
	public static boolean parseInstructionLine(String instructions) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(Instruction.AVANCER.getCode()).append("|").append(Instruction.DROITE.getCode())
				.append("|").append(Instruction.GAUCHE.getCode()).append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	/**
	 * parse the position of the lawn the position of the lawn is in the form of 2
	 * digits separated by space
	 * 
	 * @param lawn
	 * @return true if the statement line is correct, false otherwise
	 */
	public static boolean parsePelouse(String lawn) {
		return lawn.matches("(\\d+) (\\d+)");
	}
}