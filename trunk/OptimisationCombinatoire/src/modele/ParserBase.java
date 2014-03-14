package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import affichage.Affichage;

public class ParserBase extends ParserFichier
{
	@Override
	public void loadFile(String fichier)
	{
		int coutDeLaBase = 0;
		int nbElement = 0;

		TreeSet<Entreprise> listEntrepriseAllBases = new TreeSet<Entreprise>();
		try
		{
			BufferedReader inputF = new BufferedReader(new FileReader(fichier));
			try
			{
				String line = null;
				int compteur = -2;
				// On parcours toutes les lignes
				while ((line = inputF.readLine()) != null)
				{
					if (compteur == -2)
					{
						// Affichage.afficher("Cout de la base pour le fichier ("
						// + fichier + ") : " + line);
						coutDeLaBase = Integer.parseInt(line);
						compteur++;
					} else if (compteur == -1)
					{
						// Affichage.afficher("Nombre d'entreprise composant la base du fichier ("
						// + fichier + ") : " + line);
						nbElement = Integer.parseInt(line);
						compteur++;
					} else
					{
						compteur++;
						listEntrepriseAllBases.add(new Entreprise(line.trim().replaceAll("\\s", " ").toUpperCase()));
					}
				}
				// Incohérence des données
				if (nbElement != compteur)
				{
					Affichage.afficher("Erreur: Incohérence des données dans le fichier (" + fichier + ").\n NbElementAttendu :" + nbElement + "\n nbElement réel :" + compteur);
				} else
				{
					String nomBase = "";
					String[] temp = fichier.split("/");
					nomBase = temp[temp.length - 1];
					Base base = new Base(nomBase, coutDeLaBase, listEntrepriseAllBases);
					Scenario.updateBase(base);
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
}
