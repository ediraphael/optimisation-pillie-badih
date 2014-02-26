package modele;

public class Main
{
	public static void main(String[] args)
	{
		/*
		 * String elements[] = { "Data/ScВnarios/Liste Bases/Liste Bases1.txt"
		 * }; ParserFichier parser = new ParserScenarioBase();
		 * //parser.loadFile(elements[0]); String autres =
		 * "Data/ScВnarios/Liste Entreprises/Liste Ent1.txt"; parser = new
		 * ParserScenarioEntreprise(); //parser.loadFile(autres); ParserBase
		 * parserB = new ParserBase(); for(int i=1; i<24; i++) { String file =
		 * "Data/Bases/Base "+i+".txt"; parserB.loadFile(file); }
		 */
		String listeEntreprise = "Data/ScВnarios/Liste Entreprises/Liste Ent1.txt";
		String listeBase = "Data/ScВnarios/Liste Bases/Liste Bases1.txt";

		Scenario scenario = new Scenario();
		scenario.launch(listeBase, listeEntreprise);
	}
}
