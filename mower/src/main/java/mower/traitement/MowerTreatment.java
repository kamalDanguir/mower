package mower.traitement;

import java.util.ArrayList;
import java.util.List;

import mower.entities.Lawn;
import mower.entities.MowerPosition;
import mower.entities.Params;
import mower.entities.Params.Instruction;

/**
 * we use this class to execute all instructions
 * 
 * @author danguir
 *
 */
public class MowerTreatment {

	private Lawn lawn;
	private MowerPosition mowerPosition;
	private List<Params.Instruction> instructions;

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public void setMowerPosition(MowerPosition mowerPosition) {
		this.mowerPosition = mowerPosition;
	}

	public void setListeInstruction(List<Params.Instruction> instructionsList) {
		this.instructions = instructionsList;
		if (instructionsList == null) {
			instructions = new ArrayList<Instruction>();
		}
	}

	/**
	 * execute all instructions by a mower
	 * 
	 * @throws Exception
	 */
	public void executeAllInstructions() throws Exception {
		for (Instruction instruction : instructions) {
			InstructionTreatment.executeInstruction(mowerPosition, instruction, this.lawn.getMaxPosition());
		}
	}

	public String toString() {
		return mowerPosition.getMowerCoordinates().getX() + " " + mowerPosition.getMowerCoordinates().getY() + " "
				+ mowerPosition.getMowerOrientation().getCode();
	}
}