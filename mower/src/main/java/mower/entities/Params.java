package mower.entities;

/**
 * this class represents the mower's parameters
 * 
 * @author danguir
 *
 */
public class Params {

	private Params() {

	}

	/**
	 * this enumeration contains the four orientations
	 * 
	 * @author danguir
	 *
	 */
	public static enum Orientation {
		NORTH('N', "Nord"), EAST('E', "est"), WEST('W', "ouest"), SOUTH('S', "sud");

		private char code;
		private String libelle;

		private Orientation(char orientationCode, String orientationLibelle) {
			this.code = orientationCode;
			this.libelle = orientationLibelle;
		}

		public char getCode() {
			return code;
		}

		public String getLibelle() {
			return libelle;
		}
	}

	/**
	 * this enumeration contains the possible instructions
	 * 
	 * @author danguir
	 *
	 */
	public static enum Instruction {
		DROITE('D', "Pivoter à droite"), GAUCHE('G', "Pivoter à gauche"), AVANCER('A', "Avancer");

		private String libelle;
		private char code;

		private Instruction(char codeInstruction, String libelleInstruction) {
			this.libelle = libelleInstruction;
			this.code = codeInstruction;
		}

		public String getLibelle() {
			return libelle;
		}

		public char getCode() {
			return code;
		}

	}

	public static final String INCORRECT_DATA_ERROR = "données incorrectes";
	public static final String INEXISTANT_FILE_ERROR = "fichier inexistant";
	public static final String INCORRECT_ORIENTATION = "orientation incorrecte";
	public static final String INCORRECTE_INSTRUCTION = "instruction incorrecte";
	public static final String INCORRECTE_POSITION = "position incorrecte";
}