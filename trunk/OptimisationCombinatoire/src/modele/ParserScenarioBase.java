package modele;

import affichage.Affichage;

public class ParserScenarioBase extends ParserScenario
{
	public void stockerInformation(String ligne)
	{
		String nomBase = ligne;
		Affichage.afficher("Base : " + nomBase);
		Scenario.addBase(new Base(nomBase));
	}
}
