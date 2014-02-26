package modele;

import affichage.Affichage;

public class ParserScenarioEntreprise extends ParserScenario
{
	public void stockerInformation(String ligne)
	{
		String nomEntreprise = ligne.trim().toUpperCase().replaceAll("\\s", " ");
		Affichage.afficher("Entreprise : " + nomEntreprise);
		Scenario.addEntreprise(new Entreprise(nomEntreprise));
	}
}
