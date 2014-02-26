package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import affichage.Affichage;

public class ParserBase extends ParserFichier
{
	private ArrayList<String> listEntrepriseAllBases = new ArrayList<String>();

	@Override
	public void loadFile(String fichier)
	{
		try
		{
			BufferedReader inputF = new BufferedReader(new FileReader(fichier));
			try
			{
				String line = null;
				int compteur = 0;
				// On parcours toutes les lignes
				while ((line = inputF.readLine()) != null)
				{
					if(compteur == 0) {
						System.out.println("Cout de la base pour le fichier ("+fichier+") : " + line);
						compteur++;
					} else if(compteur == 1) {
						System.out.println("Nombre d'entreprise composant la base du fichier ("+fichier+") : " + line);
						compteur++;
					} else {
						listEntrepriseAllBases.add(line.replaceAll("\\s", " ").toUpperCase());

						Collections.sort(listEntrepriseAllBases, new Comparator<String>()
                        {
							public int compare(String o1, String o2)
							{
								return o1.compareTo(o2);
							}
                        });

						//System.out.println("Base : " + line.replaceAll("\\s", " ").toUpperCase());
					}
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
	
	public ArrayList<String> getListEntrepriseAllBases() {
		return listEntrepriseAllBases;
	}

	public void setListEntrepriseAllBases(ArrayList<String> listEntrepriseAllBases) {
		this.listEntrepriseAllBases = listEntrepriseAllBases;
	}

}
