package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import affichage.Affichage;

public abstract class ParserScenario extends ParserFichier
{

	@Override
	public void loadFile(String fichier)
	{
		int nbElement = 0;
		try
		{
			BufferedReader inputF = new BufferedReader(new FileReader(fichier));
			try
			{
				String line = null;
				int compteur = -1;
				// On parcours toutes les lignes
				while ((line = inputF.readLine()) != null)
				{
					if (compteur == -1)
					{
						compteur++;
						nbElement = Integer.parseInt(line);
					} else
					{
						if (!"".equals(line))
						{
							compteur++;
							stockerInformation(line);
						}
					}

				}
				if (compteur != nbElement)
				{
					Affichage.afficher("Erreur de fichier, donnée incoherente.\n NbElement attendu : " + nbElement + "\n Etat Compteur :" + compteur);
				}
			} finally
			{
				inputF.close();
			}
		} catch (IOException ex)
		{
			System.err.println("Erreur:loadFile(" + fichier + "):" + ex.getMessage());
			Affichage.afficher("Erreur:loadFile(" + fichier + "):" + ex.getMessage());
		}
	}

	public abstract void stockerInformation(String ligne);
}
