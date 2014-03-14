package modele;

import java.util.TreeSet;

public class Scenario
{
	// Liste des bases
	public static TreeSet<Base> bases;
	// Liste des entreprises
	public static TreeSet<Entreprise> entreprises;

	public Scenario()
	{
		Scenario.bases = new TreeSet<Base>();
		Scenario.entreprises = new TreeSet<Entreprise>();
	}

	/*
	 * public Scenario(TreeSet<Base> bases, TreeSet<Entreprise> entreprises) {
	 * Scenario.bases = bases; Scenario.entreprises = entreprises; }
	 */

	public void loadDatas(String listeBase, String listeEntreprise)
	{
		// On initialise les parseurs
		ParserBase parserBase = new ParserBase();
		ParserScenarioBase parserScenarioBase = new ParserScenarioBase();
		ParserScenarioEntreprise parserScenarioEntreprise = new ParserScenarioEntreprise();
		// On recupère les listes que l'utilisateur fournit
		parserScenarioBase.loadFile(listeBase);
		parserScenarioEntreprise.loadFile(listeEntreprise);

		// On charge les bases
		for (Base base : bases)
		{
			parserBase.loadFile("Data/Bases/" + base.getNom());
		}

		// On trie les bases en fonction des de leurs nombre d'entreprise
		// il suffit de recréer un TreeSet avec les bases complete, et le
		// comparator fait le reste
		TreeSet<Base> basesTrie = new TreeSet<Base>();
		for (Base base : bases)
		{
			basesTrie.add(base);
		}
		bases = basesTrie;

		// Meme opération pour les entreprise
		Entreprise.triage = true;
		TreeSet<Entreprise> entrepriseTrie = new TreeSet<Entreprise>();
		for (Entreprise entreprise : entreprises)
		{
			entrepriseTrie.add(entreprise);
		}
		entreprises = entrepriseTrie;
		Entreprise.triage = false;

		/*
		 * System.out.println("Nombre de bases connu : " + bases.size());
		 * System.out.println("Nombre d'entreprise recherché : " +
		 * entreprises.size()); for (Entreprise entreprise : entreprises) {
		 * System.out.println(entreprise.getNom()); for (Base base :
		 * entreprise.getBases()) { System.out.println("\t" + base.getNom()); }
		 * } System.out.println("Test de recherche sur la premiere base : " +
		 * bases.first().getEntreprises().size()); for (Base base : bases) {
		 * System.out.println(base.getNom()); for (Entreprise entreprise :
		 * base.getEntreprises()) { System.out.println("\t" +
		 * entreprise.getNom()); } }
		 * System.out.println("Test de recherche sur la premiere entreprise : "
		 * + entreprises.first().getNom() + " " +
		 * entreprises.first().getBases().size());
		 */
	}

	public static void updateBase(Base baseUpdate)
	{
		for (Base base : bases)
		{
			if (base.getNom().equals(baseUpdate.getNom()))
			{
				// On supprime toutes les entreprises inutiles
				baseUpdate.getEntreprises().retainAll(entreprises);
				// On met la liste d'entreprise de la base
				base.setEntreprises(baseUpdate.getEntreprises());
				// On met a jour le cout de la base
				base.setCout(baseUpdate.getCout());
				// On met à jour les informations entreprises sur leurs bases
				for (Entreprise entreprise : entreprises)
				{
					if (base.getEntreprises().contains(entreprise))
					{
						entreprise.addBase(base);
					}
				}
			}
		}
	}

	public void launchGloutonEntrepriseMax()
	{
		AlgoRecherche algo = new AlgoGloutonEntrepriseMax();
		algo.rechercher(this);
	}

	public void launchGloutonCoutMax()
	{
		AlgoRecherche algo = new AlgoGloutonCoutMax();
		algo.rechercher(this);
	}

	public void launchGloutonCoutMin()
	{
		AlgoRecherche algo = new AlgoGloutonCoutMin();
		algo.rechercher(this);
	}

	public void launchBranchAndBound()
	{
		AlgoRecherche algo = new AlgoBranchAndBound();
		algo.rechercher(this);
	}
	
	public void launchBranchAndBoundFast()
	{
		AlgoRecherche algo = new AlgoBranchAndBoundFast();
		algo.rechercher(this);
	}

	public static boolean addBase(Base base)
	{
		return Scenario.bases.add(base);
	}

	public static boolean addEntreprise(Entreprise entreprise)
	{
		return Scenario.entreprises.add(entreprise);
	}

	public TreeSet<Base> getBases()
	{
		return bases;
	}

	public void setBases(TreeSet<Base> bases)
	{
		Scenario.bases = bases;
	}

	public TreeSet<Entreprise> getEntreprises()
	{
		return entreprises;
	}

	public void setEntreprises(TreeSet<Entreprise> entreprises)
	{
		Scenario.entreprises = entreprises;
	}
}
