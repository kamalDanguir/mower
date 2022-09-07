package mower.parser;

/**
 * we use this class to validate the informations that allow you to launch a
 * mower
 * 
 * @author danguir
 *
 */
public class MowerParser {

	private String lawn;
	private String mower;
	private String instructions;

	public MowerParser() {
		this.lawn = "";
		this.mower = "";
		this.instructions = "";
	}

	/**
	 * @return true if the mower informations are correct, false otherwise
	 */
	public boolean executeParser() {
		return DataParser.parseMower(mower) && DataParser.parsePelouse(lawn)
				&& DataParser.parseInstructionLine(instructions);
	}

	public String getLawn() {
		return lawn;
	}

	public void setLawn(String lawn) {
		this.lawn = lawn;
	}

	public String getMower() {
		return mower;
	}

	public void setMower(String mower) {
		this.mower = mower;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}