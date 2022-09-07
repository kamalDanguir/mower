package mower;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;


public class MowerMainTest {
	final String FILE_PATH = "./src/test/resources/"; 


	@Test(expected = IllegalArgumentException.class)
	public void main_fichier_erreur_args() throws Exception, IOException {
		MowerMain.main("1", "2");
	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia() throws Exception, IOException {
		MowerMain.main(FILE_PATH + "mon_fichier.txt");
		assertThat(MowerMain.resultList).isNotNull();
		assertThat(MowerMain.resultList).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
}