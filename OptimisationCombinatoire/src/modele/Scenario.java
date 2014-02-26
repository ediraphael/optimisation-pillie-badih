package modele;

import java.util.ArrayList;

public class Scenario
{
	/**
	 * Liste des bases
	 */
	public static ArrayList<Base> bases;
	/**
	 * Liste des entreprises
	 */
	public static ArrayList<Entreprise> entreprises;

	public Scenario(ArrayList<Base> bases, ArrayList<Entreprise> entreprises)
	{
		Scenario.bases = bases;
		Scenario.entreprises = entreprises;
	}

	public Scenario()
	{
		Scenario.bases = new ArrayList<Base>();
		Scenario.entreprises = new ArrayList<Entreprise>();
	}

	public static boolean addBase(Base base)
	{
		return Scenario.bases.add(base);
	}

	public static boolean addEntreprise(Entreprise entreprise)
	{
		return Scenario.entreprises.add(entreprise);
	}

	public ArrayList<Base> getBases()
	{
		return bases;
	}

	public void setBases(ArrayList<Base> bases)
	{
		Scenario.bases = bases;
	}

	public ArrayList<Entreprise> getEntreprises()
	{
		return entreprises;
	}

	public void setEntreprises(ArrayList<Entreprise> entreprises)
	{
		Scenario.entreprises = entreprises;
	}
}
