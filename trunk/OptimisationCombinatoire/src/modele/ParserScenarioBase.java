package modele;

import affichage.Affichage;

public class ParserScenarioBase extends ParserScenario
{
	public void stockerInformation(String ligne)
	{
		String nomBase = ligne.trim().toUpperCase().replaceAll("\\s", " ");
		Affichage.afficher("Base : " + nomBase);
		Scenario.addBase(new Base(nomBase));
	}
}
