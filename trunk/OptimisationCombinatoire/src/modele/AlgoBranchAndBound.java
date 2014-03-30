package modele;

import java.util.ArrayList;

public class AlgoBranchAndBound extends AlgoRecherche
{
	private ArrayList<Base> bases;
	private ArrayList<Entreprise> entreprises;
	private int coutOptimal;
	private ArrayList<Base> baseOptimal;
	private ArrayList<String> logs;
	int majorant;
	int brancheCoupe;
	int branche;
	int noeud;

	@Override
	public void rechercher(Scenario scenario)
	{
		this.logs = new ArrayList<String>();
		// On fait une copie des bases
		this.bases = new ArrayList<Base>();
		for (Base base : scenario.getBases())
		{
			this.bases.add(base);
		}
		// On fait une copie des entreprises
		this.entreprises = new ArrayList<Entreprise>();
		for (Entreprise entreprise : scenario.getEntreprises())
		{
			this.entreprises.add(entreprise);
		}
		// On initialise le coutOptimal
		this.coutOptimal = Integer.MAX_VALUE;
		this.baseOptimal = new ArrayList<Base>();

		this.recursive(entreprises, new ArrayList<Base>(), 0, 0);
		StringBuilder text = new StringBuilder();
		for (String chaine : logs)
		{
			text.append(chaine+"\n");
		}
		this.setChaine(this.getChaine() + "\n" + text);
		this.setChaine(this.getChaine() + "\nCout Optimal :" + coutOptimal);
		for (Base base : this.baseOptimal)
		{
			this.setChaine(this.getChaine() + "\n" + base.getNom());
		}
		this.setChaine(this.getChaine() + "\nMajorant :" + majorant);
		this.setChaine(this.getChaine() + "\nNoeud :" + noeud);
		this.setChaine(this.getChaine() + "\nBranches :" + branche);
		this.setChaine(this.getChaine() + "\nBranches Coupées :" + brancheCoupe);
	}

	private void recursive(ArrayList<Entreprise> entreprisesBase, ArrayList<Base> bases, int coutActuel, int profondeur)
	{
		// On copie la liste des entreprise restante
		ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
		for (Entreprise entreprise : entreprisesBase)
		{
			entreprises.add(entreprise);
		}
		// On prend la première entreprise qui vient dans la liste
		Entreprise entreprise = entreprises.get(0);
		// Puis on la supprime de la liste pour plus tard
		entreprises.remove(0);

		// On parcours la liste des bases de qui contienne l'entreprise
		for (Base base : entreprise.getBases())
		{
			noeud++;
			String chaine = "";
			for (int i = 0; i < profondeur; i++)
			{
				chaine += "  ";
			}
			chaine += base.getNom() + "-->" + entreprise.getNom() + ". Il reste " + entreprises.size() + " à trouver.";
			logs.add(chaine);
			//this.setChaine(this.getChaine() + "\n" + chaine);
			// Affichage.afficher(chaine);
			// On calcul le cout total que ça nous ferait
			int coutRelatif = coutActuel;
			if (!bases.contains(base))
			{
				coutRelatif += base.getCout();
			}

			// Si le cout relatif est inférieur a notre cout optimal alors
			// on continu
			if (coutRelatif < coutOptimal)
			{
				// entreprisesInconnu.remove(entreprise);
				// Si on connait toutes les entreprises
				if (entreprises.size() == 0)
				{
					branche++;
					// Et que le coup que l'on a trouvé est inférieur au
					// coup optimal
					// Alors on retient cette solution
					majorant++;
					this.coutOptimal = coutRelatif;
					this.baseOptimal = new ArrayList<Base>(bases);
				
				} else
				{
					// On cré la liste des bases utilisé
					ArrayList<Base> basesUtilise = new ArrayList<Base>(bases);
					if (!bases.contains(base))
					{
						basesUtilise.add(base);
					}
					// On cré une nouvelle liste d'entreprise qu'il nous reste a
					// découvrire
					ArrayList<Entreprise> entreprisesInconnu = new ArrayList<Entreprise>(entreprises);
					// Sinon on continu la recherche
					this.recursive(entreprisesInconnu, basesUtilise, coutRelatif, profondeur + 1);
				}
			} else
			{
				branche++;
				if(entreprises.size() != 0)
				{
					brancheCoupe++;
				}
			}
		}
	}
}
