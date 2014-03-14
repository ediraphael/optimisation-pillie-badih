package modele;

import java.util.ArrayList;

public class AlgoBranchAndBound extends AlgoRecherche
{
	private ArrayList<Base> bases;
	private ArrayList<Entreprise> entreprises;
	private int coutOptimal;
	private ArrayList<Base> baseOptimal;

	@Override
	public void rechercher(Scenario scenario)
	{
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
		System.out.println(this.coutOptimal);
		for (Base base : this.baseOptimal)
		{
			System.out.println(base.getNom());
		}
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
			// Si on a pas déja acheter la base
			if (!bases.contains(base))
			{
				/*
				 * for(int i=1;i<profondeur;i++) { System.out.print("  "); }
				 * System
				 * .out.println(base.getNom()+", il reste "+entreprises.size
				 * ()+" entreprises");
				 */
				// On calcul le cout total que ça nous ferait
				int coutRelatif = coutActuel + base.getCout();
				// Si le cout relatif est inférieur a notre cout optimal alors
				// on continu
				if (coutRelatif < coutOptimal)
				{
					// On cré la liste des bases utilisé
					ArrayList<Base> basesUtilise = new ArrayList<Base>(bases);
					basesUtilise.add(base);
					// On cré une nouvelle liste d'entreprise qu'il nous reste a
					// découvrire
					ArrayList<Entreprise> entreprisesInconnu = new ArrayList<Entreprise>(entreprises);
					entreprisesInconnu.removeAll(base.getEntreprises());
					// Si on connait toutes les entreprises
					if (entreprisesInconnu.size() == 0)
					{
						// Et que le coup que l'on a trouvé est inférieur au
						// coup optimal
						// Alors on retient cette solution
						if (coutRelatif < this.coutOptimal)
						{
							this.coutOptimal = coutRelatif;
							this.baseOptimal = new ArrayList<Base>(basesUtilise);
						}
					} else
					{
						// Sinon on continu la recherche
						this.recursive(entreprisesInconnu, basesUtilise, coutRelatif, profondeur + 1);
					}
				}
			}
		}
	}
}
