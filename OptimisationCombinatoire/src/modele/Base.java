package modele;

import java.util.ArrayList;

public class Base
{
	/**
	 * Nom de la base
	 */
	private String nom;
	/**
	 * Liste des entreprises présent dans la base
	 */
	private ArrayList<Entreprise> entreprises;

	public Base(String nom, ArrayList<Entreprise> entreprises)
	{
		this.nom = nom;
		this.entreprises = entreprises;
	}

	public Base(String nom)
	{
		this.nom = nom;
		this.entreprises = new ArrayList<Entreprise>();
	}

	public boolean addEntreprise(Entreprise entreprise)
	{
		return this.entreprises.add(entreprise);
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
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
