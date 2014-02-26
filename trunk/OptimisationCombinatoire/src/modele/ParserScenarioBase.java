package modele;

import affichage.Affichage;

public class ParserScenarioBase extends ParserScenario
{
	public void stockerInformation(String ligne)
	{
		Affichage.afficher("Base : " + ligne);
	}
}
