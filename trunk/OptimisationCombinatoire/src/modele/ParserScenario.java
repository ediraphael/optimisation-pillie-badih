package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public abstract class ParserScenario extends ParserFichier
{

	@Override
	public void loadFile(String fichier)
	{
		int nbElement = 0;
		try
		{
			BufferedReader inputF = new BufferedReader(new FileReader(fichier));
			int nbNoeud = 0;
			try
			{
				String line = null;
				int compteur = 0;
				// On parcours toutes les lignes
				while ((line = inputF.readLine()) != null)
				{
					if (compteur == 0)
					{
						compteur++;
						nbElement = Integer.parseInt(line);
					} else
					{
						if (!"".equals(line))
						{
							stockerInformation(line);
						}
					}
				}
			} finally
			{
				inputF.close();
			}
		} catch (IOException ex)
		{
			System.err.println("Erreur Graphe:loadFile(" + fichier + "):" + ex.getMessage());
			Affichage.afficher("Erreur Graphe:loadFile(" + fichier + "):" + ex.getMessage());
		}
	}

	public abstract void stockerInformation(String ligne);
}
