package modele;

public class Main
{
	public static void main(String[] args)
	{
		// String nomGraphe = "C2000.9.clq";
		String elements[] = { "Data/ScВnarios/Liste Bases/Liste Bases1.txt" };
		ParserFichier parser = new ParserScenarioBase();
		parser.loadFile(elements[0]);
		String autres = "Data/ScВnarios/Liste Entreprises/Liste Ent1.txt";
		parser = new ParserScenarioEntreprise();
		parser.loadFile(autres);

	}
}
