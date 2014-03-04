package modele;

import java.util.ArrayList;
import java.util.TreeSet;

public class AlgoGloutonCoutMin extends AlgoRecherche
{
	private ArrayList<Base> bases;
	private ArrayList<Entreprise> entreprises;
	private int coutOptimal;
	private ArrayList<Base> baseOptimal;
	
	@Override
	public void rechercher(Scenario scenario)
	{
		// On fait une copie des bases on les trions par cout croissant
		this.bases = new ArrayList<Base>();
		this.sortCout(scenario.getBases(), bases);
		for(Base base : bases) {
			System.out.println("la "+base.getNom()+" a pour taille: "+base.getEntreprises().size()+" est pour cout: "+base.getCout());
		}

		// On fait une copie des entreprises
		this.entreprises = new ArrayList<Entreprise>();
		for (Entreprise entreprise : scenario.getEntreprises())
		{
			this.entreprises.add(entreprise);
		}
				
		this.coutOptimal = 0;
		this.baseOptimal = new ArrayList<Base>();
		this.recursive(entreprises, bases);
		System.out.println(this.coutOptimal);
		for (Base base : this.baseOptimal)
		{
			System.out.println(base.getNom());
		}
	}

	private void recursive(ArrayList<Entreprise> entreprisesBase, ArrayList<Base> basesMax) 
	{
		boolean checkEntreprises = false;

		// On copie la liste des entreprise et des bases restante
		ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
		ArrayList<Base> bases = new ArrayList<Base>();
		for (Entreprise entrepriseTemp : entreprisesBase)
		{
			entreprises.add(entrepriseTemp);
		}
		for(Base base : basesMax) {
			bases.add(base);
		}
							
		// On prend la première base qui vient dans la liste
		Base base = bases.get(0);
		// Puis on la supprime de la liste pour plus tard
		bases.remove(0);
				
		//On parcour la liste des entreprises
		ArrayList<Entreprise> entrepriseToRemove = new ArrayList<Entreprise>();
		for(Entreprise entreprise : entreprises) {
			if(base.getEntreprises().contains(entreprise)) {
				entrepriseToRemove.add(entreprise);
				checkEntreprises = true;
			}
		}
		//On supprime les entreprises qui sont dans la base actuel
		for(Entreprise entrepriseRemoveTemp : entrepriseToRemove) {
			entreprises.remove(entrepriseRemoveTemp);
		}
				
		//Si on a découvert des entreprises dans la base actuel, on additionne le cout de la base actuel au cout optimale 
		//Et on rajoute la base actuel dans la la liste des bases optimales
		if(checkEntreprises) {
			coutOptimal = coutOptimal + base.getCout();
			baseOptimal.add(base);
		}
				
		if((entreprises.size() != 0) && (bases.size() != 0)) {
			recursive(entreprises, bases);
		}
	}
			
	void sortCout(TreeSet<Base> treeSet, ArrayList<Base> basesActuel) {
		Base baseCoutMin = treeSet.first();
		for(Base base : treeSet) {
			if(base.getCout()<baseCoutMin.getCout()) { baseCoutMin=base;}
		}
		basesActuel.add(baseCoutMin);
		treeSet.remove(baseCoutMin);
		if(treeSet.size()!=0){
			sortCout(treeSet, basesActuel);
		}
	}

}
