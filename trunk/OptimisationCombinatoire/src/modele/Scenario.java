package modele;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Scenario
{
	/**
	 * Liste des bases
	 */
	private ArrayList<Base> bases;
	/**
	 * Liste des entreprises
	 */
	private ArrayList<Entreprise> entreprises;

	public Scenario(ArrayList<Base> bases, ArrayList<Entreprise> entreprises)
	{
		this.bases = bases;
		this.entreprises = entreprises;
	}

	public Scenario()
	{
		this.bases = new ArrayList<Base>();
		this.entreprises = new ArrayList<Entreprise>();
	}

	public boolean addBase(Base base)
	{
		return this.bases.add(base);
	}

	public boolean addEntreprise(Entreprise entreprise)
	{
		return this.entreprises.add(entreprise);
	}

	public ArrayList<Base> getBases()
	{
		return bases;
	}

	public void setBases(ArrayList<Base> bases)
	{
		this.bases = bases;
	}

	public ArrayList<Entreprise> getEntreprises()
	{
		return entreprises;
	}

	public void setEntreprises(ArrayList<Entreprise> entreprises)
	{
		this.entreprises = entreprises;
	}
}
