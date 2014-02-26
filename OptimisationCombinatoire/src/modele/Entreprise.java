package modele;

import java.util.ArrayList;

//Test
public class Entreprise
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

}
