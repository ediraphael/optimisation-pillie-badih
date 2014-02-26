package modele;

import java.util.TreeSet;

public class Base
{
	/**
	 * Nom de la base
	 */
	private String nom;
	/**
	 * Cout d'accees à la base
	 */
	private int cout;
	/**
	 * Liste des entreprises présent dans la base
	 */
	private TreeSet<Entreprise> entreprises;

	public Base(String nom, int cout, TreeSet<Entreprise> entreprises)
	{
		this.nom = nom;
		this.cout = cout;
		this.entreprises = entreprises;
	}

	public Base(String nom, TreeSet<Entreprise> entreprises)
	{
		this.nom = nom;
		this.cout = 0;
		this.entreprises = entreprises;
	}

	public Base(String nom)
	{
		this.nom = nom;
		this.cout = 0;
		this.entreprises = new TreeSet<Entreprise>();
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

	public TreeSet<Entreprise> getEntreprises()
	{
		return entreprises;
	}

	public void setEntreprises(TreeSet<Entreprise> entreprises)
	{
		this.entreprises = entreprises;
	}

	public int getCout()
	{
		return cout;
	}

	public void setCout(int cout)
	{
		this.cout = cout;
	}
}
