package modele;

import affichage.Affichage;

public class ParserScenarioEntreprise extends ParserScenario
{
	public void stockerInformation(String ligne)
	{
		Affichage.afficher("Entreprise : " + ligne);
	}
}
