package modele;

public class Main
{
	public static void main(String[] args)
	{
		// String nomGraphe = "C2000.9.clq";
		String elements[] = { "Data/ScВnarios/Liste Bases/Liste Bases1.txt" };
		ParserFichier parser = new ParserScenarioBase();
		//parser.loadFile(elements[0]);
		String autres = "Data/ScВnarios/Liste Entreprises/Liste Ent1.txt";
		parser = new ParserScenarioEntreprise();
		//parser.loadFile(autres);
		ParserBase parserB = new ParserBase();
		for(int i=1; i<24; i++) {
			String file = "Data/Bases/Base "+i+".txt";
			parserB.loadFile(file);
		}
		for(String ent : parserB.getListEntrepriseAllBases()) {
			System.out.println(ent);
		}
		//System.out.println(parserB.getListEntrepriseAllBases());
		

	}
}
