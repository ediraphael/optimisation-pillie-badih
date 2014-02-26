package modele;

import java.util.TreeSet;

public class Scenario
{
	/**
	 * Liste des bases
	 */
	public static TreeSet<Base> bases;
	/**
	 * Liste des entreprises
	 */
	public static TreeSet<Entreprise> entreprises;

	public Scenario(TreeSet<Base> bases, TreeSet<Entreprise> entreprises)
	{
		Scenario.bases = bases;
		Scenario.entreprises = entreprises;
	}

	public Scenario()
	{
		Scenario.bases = new TreeSet<Base>();
		Scenario.entreprises = new TreeSet<Entreprise>();
	}

	public static boolean addBase(Base base)
	{
		return Scenario.bases.add(base);
	}

	public static void updateBase(Base baseUpdate)
	{
		for (Base base : bases)
		{
			if (base.getNom().equals(baseUpdate.getNom()))
			{
				base.setEntreprises(baseUpdate.getEntreprises());
				base.setCout(baseUpdate.getCout());
			}
		}
	}

	public static boolean addEntreprise(Entreprise entreprise)
	{
		return Scenario.entreprises.add(entreprise);
	}

	public void launch(String listeBase, String listeEntreprise)
	{
		ParserBase parserBase = new ParserBase();
		ParserScenarioBase parserScenarioBase = new ParserScenarioBase();
		ParserScenarioEntreprise parserScenarioEntreprise = new ParserScenarioEntreprise();

		parserScenarioBase.loadFile(listeBase);
		parserScenarioEntreprise.loadFile(listeEntreprise);
		for (Base base : bases)
		{
			parserBase.loadFile("Data/Bases/" + base.getNom());
		}

		System.out.println("Nombre de bases connu : " + bases.size());
		System.out.println("Nombre d'entreprise recherché : " + entreprises.size());
		System.out.println("Test de recherche sur la premiere base : " + bases.first().getEntreprises().size());
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
