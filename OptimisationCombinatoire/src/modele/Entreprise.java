package modele;

import java.util.ArrayList;

public class Entreprise implements Comparable<Entreprise>
{
	/**
	 * Nom de l'entreprise
	 */
	private String nom;
	/**
	 * Liste des bases dans lesquelle l'entreprise est présente
	 */
	private ArrayList<Base> bases;

	public Entreprise(String nom, ArrayList<Base> bases)
	{
		this.nom = nom;
		this.bases = bases;
	}

	public Entreprise(String nom)
	{
		this.nom = nom;
		this.bases = new ArrayList<Base>();
	}

	public boolean addBase(Base base)
	{
		return bases.add(base);
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public ArrayList<Base> getBases()
	{
		return bases;
	}

	public void setBases(ArrayList<Base> bases)
	{
		this.bases = bases;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entreprise other = (Entreprise) obj;

		if (nom == null)
		{
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public int compareTo(Entreprise entreprise)
	{
		return this.getNom().compareTo(entreprise.getNom());
	}
}
