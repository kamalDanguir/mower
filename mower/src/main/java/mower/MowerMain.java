package mower;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mower.entities.Params;
import mower.parser.MowerParser;
import mower.traitement.LineFormater;
import mower.traitement.MowerTreatment;

public class MowerMain {

	protected static List<String> resultList;

	public static void main(String... args) throws Exception, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			MowerMain instance = new MowerMain();
			resultList = instance.startTreatment(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Reading file and starting treatment
	 * 
	 * @param file
	 * @throws Exception
	 * @throws IOException
	 * @return List<String> : mower positions
	 */
	private List<String> startTreatment(File file) throws Exception, IOException {
		if (!file.isFile()) {
			throw new Exception(Params.INEXISTANT_FILE_ERROR);
		} else {
			MowerParser parser = new MowerParser();
			Scanner scanner = new Scanner(file);
			try {
				treatFirstLine(parser, scanner);
				return treatNextLines(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	/**
	 * treat the first line of the file
	 * 
	 * @param parser
	 * @param scanner
	 * @throws Exception : error if the file contains less than 2 lines
	 */
	protected void treatFirstLine(MowerParser mowerParser, Scanner scanner) throws Exception {
		if (scanner.hasNext()) {
			mowerParser.setLawn(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new Exception(Params.INCORRECT_DATA_ERROR);
		}

	}

	/**
	 * 
	 * @param parser
	 * @param scanner
	 * @return Mower position
	 * @throws Exception
	 */
	private List<String> treatNextLines(MowerParser parser, Scanner scanner) throws Exception {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			parser.setMower(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(parseAndStartTreatement(parser));
			} else {
				throw new Exception(Params.INCORRECT_DATA_ERROR);
			}
		}
		return listePositions;
	}

	/**
	 * Parsing and performing the mower treatment
	 * 
	 * @param parser : the object containing the mower information
	 * @throws Exception
	 */
	private String parseAndStartTreatement(MowerParser parser) throws Exception {
		if (!parser.executeParser()) {
			throw new Exception(Params.INCORRECT_DATA_ERROR);
		} else {
			MowerTreatment traitement = new MowerTreatment();
			traitement.setLawn(LineFormater.formatLawnLine(parser.getLawn()));
			traitement.setMowerPosition(LineFormater.formatMowerLine(parser.getMower()));
			traitement.setListeInstruction(LineFormater.formatInstructionLine(parser.getInstructions()));
			traitement.executeAllInstructions();
			System.out.println(traitement);
			return traitement.toString();
		}
	}
}